package fit.nlu.appchat.repository;

import fit.nlu.appchat.entity.Friend;
import fit.nlu.appchat.enums.FriendStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends MongoRepository<Friend, String> {
    List<Friend> findByUserIdOrFriendId(String userId, String friendId);
    Optional<Friend> findByUserIdAndFriendId(String userId, String friendId);
    boolean existsByUserIdAndFriendIdAndStatus(String userId, String friendId, FriendStatus status);
}
