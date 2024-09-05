package fit.nlu.appchat.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "messages")
public class Message {
    @Id
    String id;
    String senderId;
    String receiverId;
    String content;
    String messageType;
    LocalDateTime timestamp;
}