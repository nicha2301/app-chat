package fit.nlu.appchat.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fit.nlu.appchat.dto.request.MessageRequest;
import fit.nlu.appchat.dto.response.ApiResponse;
import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.service.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageController {
    MessageService messageService;

    @PostMapping
    public ApiResponse<MessageResponse> sendMessage(@RequestBody MessageRequest request) {
        MessageResponse response = messageService.sendMessage(request);
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
    public ApiResponse<List<MessageResponse>> getConversation(
            @PathVariable String user1Id,
            @PathVariable String user2Id,
            @RequestParam(value = "cursor", required = false) String cursor,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<MessageResponse> messages = messageService.getConversation(user1Id, user2Id, cursor, limit);
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