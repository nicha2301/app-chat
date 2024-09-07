package fit.nlu.appchat.dto.response;

import fit.nlu.appchat.entity.Friend;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String password;
    String fullName;
    String img;
    Date createAt;
    String status;
    List<Friend> friends;
}