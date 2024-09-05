package fit.nlu.appchat.mapper;

import fit.nlu.appchat.dto.request.MessageRequest;
import fit.nlu.appchat.dto.response.MessageResponse;
import fit.nlu.appchat.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message toMessage(MessageRequest request);
    MessageResponse toMessageResponse(Message message);
}
