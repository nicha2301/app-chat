package fit.nlu.appchat.controller;

import fit.nlu.appchat.dto.request.MessageRequest;
import fit.nlu.appchat.dto.response.ApiResponse;
import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.entity.Message;
import fit.nlu.appchat.service.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageController {
    MessageService messageService;

    @PostMapping
    public ApiResponse<MessageResponse> sendMessage(@RequestBody MessageRequest request) {
        MessageResponse response = messageService.sendMessage(request.getSenderId(), request.getReceiverId(), request.getContent());
        return ApiResponse.<MessageResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("Message sent successfully")
                .result(response)
                .build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<List<MessageResponse>> getMessagesForUser(@PathVariable String userId) {
        List<MessageResponse> messages = messageService.getMessagesForUser(userId);
        return ApiResponse.<List<MessageResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("Messages retrieved successfully")
                .result(messages)
                .build();
    }

    @GetMapping("/conversation/{user1Id}/{user2Id}")
    public ApiResponse<List<MessageResponse>> getConversation(@PathVariable String user1Id, @PathVariable String user2Id) {
        List<MessageResponse> messages = messageService.getConversation(user1Id, user2Id);
        return ApiResponse.<List<MessageResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("Conversation retrieved successfully")
                .result(messages)
                .build();
    }

    @DeleteMapping("/{messageId}")
    public ApiResponse<String> deleteMessage(@PathVariable String messageId) {
        messageService.deleteMessage(messageId);
        return ApiResponse.<String>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Message deleted successfully")
                .result("Message with ID " + messageId + " has been deleted.")
                .build();
    }
}