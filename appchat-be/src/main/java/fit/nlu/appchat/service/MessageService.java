package fit.nlu.appchat.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fit.nlu.appchat.dto.request.MessageRequest;
import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.entity.PrivateMessage;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.enums.FriendStatus;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.mapper.MessageMapper;
import fit.nlu.appchat.repository.FriendRepository;
import fit.nlu.appchat.repository.MessageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    MessageRepository messageRepository;
    MessageMapper messageMapper;
    FriendRepository friendRepository;

    public MessageResponse sendMessage(MessageRequest request) {
        boolean areFriends = friendRepository.existsByUserIdAndFriendIdAndStatus(request.getSenderId(), request.getReceiverId(), FriendStatus.ACCEPTED) ||
                friendRepository.existsByUserIdAndFriendIdAndStatus(request.getReceiverId(), request.getSenderId(), FriendStatus.ACCEPTED);

        if (!areFriends) {
            throw new AppException(ErrorCode.NOT_FRIENDS);
        }

        PrivateMessage privateMessage = messageMapper.toMessage(request);

        privateMessage.setSentAt(new Date());

        PrivateMessage savedPrivateMessage = messageRepository.save(privateMessage);
        return messageMapper.toMessageResponse(savedPrivateMessage);
    }

    public List<MessageResponse> getMessagesForUser(String userId) {
        List<PrivateMessage> privateMessages = messageRepository.findByReceiverId(userId);
        return privateMessages.stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    public List<MessageResponse> getConversation(String user1Id, String user2Id, String cursorId, int limit) {
        Pageable pageable = PageRequest.of(0, limit);

        List<PrivateMessage> privateMessages;
        if (cursorId != null && !cursorId.isEmpty()) {
            privateMessages = messageRepository.findConversationBeforeId(user1Id, user2Id, cursorId, pageable);
        } else {
            privateMessages = messageRepository.findConversation(user1Id, user2Id, pageable);
        }

        return privateMessages.stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    public void deleteMessage(String messageId) {
        PrivateMessage privateMessage = messageRepository.findById(messageId)
                .orElseThrow(() -> new AppException(ErrorCode.MESSAGE_NOT_EXISTED));
        messageRepository.delete(privateMessage);
    }

    private Optional<Date> convertToDate(String cursor) {
        if (cursor == null || cursor.isEmpty()) {
            return Optional.empty();
        }

        try {
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(cursor, DATE_FORMATTER);
            return Optional.of(Date.from(zonedDateTime.toInstant()));
        } catch (Exception e) {
            throw new AppException(ErrorCode.INVALID_DATE_FORMAT);
        }
    }

}
