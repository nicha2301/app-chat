package fit.nlu.appchat.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageResponse {
    private String senderId;
    private String receiverId;
    private String content;
    private LocalDateTime timestamp;
}
