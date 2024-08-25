package fit.nlu.appchat.repository;

import fit.nlu.appchat.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByReceiverId(String receiverId);

    List<Message> findBySenderIdAndReceiverId(String senderId, String receiverId);

    @Query("SELECT m FROM Message m WHERE (m.senderId = :user1Id AND m.receiverId = :user2Id) OR (m.senderId = :user2Id AND m.receiverId = :user1Id)")
    List<Message> findConversation(@Param("user1Id") String user1Id, @Param("user2Id") String user2Id);
}
