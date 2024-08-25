package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.entity.Message;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.mapper.MessageMapper;
import fit.nlu.appchat.repository.MessageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageService {
    MessageRepository messageRepository;
    MessageMapper messageMapper;

    public MessageResponse sendMessage(String senderId, String receiverId, String content) {
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());

        Message savedMessage = messageRepository.save(message);
        return messageMapper.toMessageResponse(savedMessage);
    }

    public List<MessageResponse> getMessagesForUser(String userId) {
        List<Message> messages = messageRepository.findByReceiverId(userId);
        return messages.stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    public List<MessageResponse> getConversation(String user1Id, String user2Id) {
        List<Message> messages = messageRepository.findConversation(user1Id, user2Id);
        return messages.stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    public void deleteMessage(String messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new AppException(ErrorCode.MESSAGE_NOT_EXISTED));
        messageRepository.delete(message);
    }

}
