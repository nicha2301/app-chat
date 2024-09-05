package fit.nlu.appchat.controller;

import fit.nlu.appchat.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/user/queue/messages")
    public Message send(Message message) {
        return message;
    }

    @MessageMapping("/chat/private")
    @SendTo("/user/{receiverId}/queue/messages")
    public Message sendPrivateMessage(Message message) {
        return message;
    }
}
