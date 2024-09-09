package fit.nlu.appchat.repository;

import fit.nlu.appchat.entity.GroupMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMessageRepository extends MongoRepository<GroupMessage, String> {
    List<GroupMessage> findByGroupId(String groupId);
}
