package fit.nlu.appchat.mapper;

import fit.nlu.appchat.dto.request.MessageRequest;
import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.entity.PrivateMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    PrivateMessage toMessage(MessageRequest request);
    MessageResponse toMessageResponse(PrivateMessage privateMessage);
}
