package fit.nlu.appchat.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageResponse {
    String senderId;
    String receiverId;
    String content;
    String messageType;
    Date sentAt;
    Date readAt;
}
