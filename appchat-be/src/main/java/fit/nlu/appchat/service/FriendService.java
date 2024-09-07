package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.request.FriendRequest;
import fit.nlu.appchat.dto.response.FriendResponse;
import fit.nlu.appchat.entity.Friend;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.enums.FriendStatus;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.mapper.FriendMapper;
import fit.nlu.appchat.repository.FriendRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FriendService {
    FriendRepository friendRepository;
    FriendMapper friendMapper;

    public FriendResponse sendFriendRequest(FriendRequest request) {
        Friend friend = friendMapper.toFriend(request);
        friend.setStatus(FriendStatus.PENDING);
        friend.setCreatedAt(new Date());

        Friend savedFriend = friendRepository.save(friend);
        return friendMapper.toFriendResponse(savedFriend);
    }

    public List<FriendResponse> getFriendsForUser(String userId) {
        List<Friend> friends = friendRepository.findByUserIdOrFriendId(userId, userId);
        return friends.stream()
                .map(friendMapper::toFriendResponse)
                .collect(Collectors.toList());
    }

    public void acceptFriendRequest(String userId, String friendId) {
        Friend friend = friendRepository.findByUserIdAndFriendId(userId, friendId)
                .orElseThrow(() -> new AppException(ErrorCode.FRIEND_NOT_EXISTED));

        friend.setStatus(FriendStatus.ACCEPTED);
        friendRepository.save(friend);
    }

    public void rejectFriendRequest(String friendId) {
        Friend friend = friendRepository.findById(friendId)
                .orElseThrow(() -> new AppException(ErrorCode.FRIEND_NOT_EXISTED));
        friend.setStatus(FriendStatus.REJECTED);
        friendRepository.save(friend);
    }
}