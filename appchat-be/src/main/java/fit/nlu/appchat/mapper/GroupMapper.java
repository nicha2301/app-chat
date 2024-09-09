package fit.nlu.appchat.mapper;

import fit.nlu.appchat.dto.request.GroupRequest;
import fit.nlu.appchat.dto.response.GroupResponse;
import fit.nlu.appchat.entity.Group;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    Group toGroup(GroupRequest request);

    GroupResponse toGroupResponse(Group group);
}
