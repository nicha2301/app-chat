package fit.nlu.appchat.controller;

import fit.nlu.appchat.entity.PrivateMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/user/queue/messages")
    public PrivateMessage send(PrivateMessage privateMessage) {
        return privateMessage;
    }

    @MessageMapping("/chat/private")
    @SendTo("/user/{receiverId}/queue/messages")
    public PrivateMessage sendPrivateMessage(PrivateMessage privateMessage) {
        return privateMessage;
    }
}
