package fit.nlu.appchat.dto.response;

import fit.nlu.appchat.enums.FriendStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FriendResponse {
    String userId;
    String friendId;
    FriendStatus status;
    Date createdAt;
}
