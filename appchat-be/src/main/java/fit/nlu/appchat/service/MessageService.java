package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.request.MessageRequest;
import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.entity.PrivateMessage;
import fit.nlu.appchat.enums.FriendStatus;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.mapper.MessageMapper;
import fit.nlu.appchat.repository.FriendRepository;
import fit.nlu.appchat.repository.MessageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageService {
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

    public List<MessageResponse> getConversation(String user1Id, String user2Id) {
        boolean areFriends = friendRepository.existsByUserIdAndFriendIdAndStatus(user1Id, user2Id, FriendStatus.ACCEPTED) ||
                friendRepository.existsByUserIdAndFriendIdAndStatus(user2Id, user1Id, FriendStatus.ACCEPTED);

        if (!areFriends) {
            throw new AppException(ErrorCode.NOT_FRIENDS);
        }

        List<PrivateMessage> privateMessages = messageRepository.findConversation(user1Id, user2Id);
        return privateMessages.stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    public void deleteMessage(String messageId) {
        PrivateMessage privateMessage = messageRepository.findById(messageId)
                .orElseThrow(() -> new AppException(ErrorCode.MESSAGE_NOT_EXISTED));
        messageRepository.delete(privateMessage);
    }

}
