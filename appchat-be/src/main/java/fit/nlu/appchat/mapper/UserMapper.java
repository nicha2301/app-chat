package fit.nlu.appchat.mapper;

import fit.nlu.appchat.dto.request.UserCreationRequest;
import fit.nlu.appchat.dto.request.UserUpdateRequest;
import fit.nlu.appchat.dto.response.UserResponse;
import fit.nlu.appchat.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
