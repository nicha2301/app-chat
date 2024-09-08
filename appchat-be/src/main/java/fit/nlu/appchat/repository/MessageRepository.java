package fit.nlu.appchat.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import fit.nlu.appchat.entity.PrivateMessage;

public interface MessageRepository extends MongoRepository<PrivateMessage, String> {
    List<PrivateMessage> findByReceiverId(String receiverId);

    @Query("{ '$or': [ { 'senderId': ?0, 'receiverId': ?1 }, { 'senderId': ?1, 'receiverId': ?0 } ] }")
    List<PrivateMessage> findConversation(String user1Id, String user2Id, Pageable pageable);
    @Query("{ '$or': [ { 'senderId': ?0, 'receiverId': ?1 }, { 'senderId': ?1, 'receiverId': ?0 } ], '_id': { '$lt': ?2 } }")
    List<PrivateMessage> findConversationBeforeId(String user1Id, String user2Id, String cursorId, Pageable pageable);



}
