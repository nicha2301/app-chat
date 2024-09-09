package fit.nlu.appchat.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupRequest {
    String groupName;
    String creatorId;
    List<String> memberIds;
    List<String> adminIds;
    String avatar;
}
