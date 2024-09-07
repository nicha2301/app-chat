package fit.nlu.appchat.repository;

import fit.nlu.appchat.entity.PrivateMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends MongoRepository<PrivateMessage, String> {
    List<PrivateMessage> findByReceiverId(String receiverId);

    List<PrivateMessage> findBySenderIdAndReceiverId(String senderId, String receiverId);

    @Query("SELECT m FROM Message m WHERE (m.senderId = :user1Id AND m.receiverId = :user2Id) OR (m.senderId = :user2Id AND m.receiverId = :user1Id)")
    List<PrivateMessage> findConversation(@Param("user1Id") String user1Id, @Param("user2Id") String user2Id);
}
