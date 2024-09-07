package fit.nlu.appchat.entity;

import fit.nlu.appchat.enums.FriendStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "friends")
public class Friend {
    @Id
    String id;
    String userId;
    String friendId;
    FriendStatus status; //"pending", "accepted", "rejected"
    Date createdAt;

}
