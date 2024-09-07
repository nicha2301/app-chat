package fit.nlu.appchat.mapper;

import fit.nlu.appchat.dto.request.FriendRequest;
import fit.nlu.appchat.dto.request.MessageRequest;
import fit.nlu.appchat.dto.response.FriendResponse;
import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.entity.Friend;
import fit.nlu.appchat.entity.PrivateMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FriendMapper {
    Friend toFriend(FriendRequest request);

    FriendResponse toFriendResponse(Friend friend);
}
