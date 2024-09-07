package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.request.UserCreationRequest;
import fit.nlu.appchat.dto.request.UserUpdateRequest;
import fit.nlu.appchat.dto.response.UserResponse;
import fit.nlu.appchat.entity.Friend;
import fit.nlu.appchat.entity.User;
import fit.nlu.appchat.enums.FriendStatus;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.mapper.UserMapper;
import fit.nlu.appchat.repository.FriendRepository;
import fit.nlu.appchat.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    FriendRepository friendRepository;
    UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        var users = userRepository.findAll();
        if (users.isEmpty())
            throw new AppException(ErrorCode.USER_NOT_EXISTED);

        List<Friend> allFriends = friendRepository.findAll();

        Map<String, List<Friend>> friendsMap = allFriends.stream()
                .filter(friend -> FriendStatus.ACCEPTED.equals(friend.getStatus()))
                .collect(Collectors.groupingBy(Friend::getUserId));

        return users.stream()
                .map(user -> {
                    List<Friend> friends = friendsMap.getOrDefault(user.getId(), new ArrayList<>());
                    UserResponse userResponse = userMapper.toUserResponse(user);
                    userResponse.setFriends(friends);
                    return userResponse;
                })
                .collect(Collectors.toList());
    }

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCreateAt(new Date());
        user.setStatus("active");

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        List<Friend> friends = getFriendsForUser(user.getId());

        UserResponse userResponse = userMapper.toUserResponse(user);
        userResponse.setFriends(friends);

        return userResponse;
    }

    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        List<Friend> friends = getFriendsForUser(user.getId());

        UserResponse userResponse = userMapper.toUserResponse(user);
        userResponse.setFriends(friends);

        return userResponse;
    }

    public Void deleteUserById(String id) {
        if (userRepository.existsByUsername(id))
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        userRepository.deleteById(id);
        return null;
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        applyUpdates(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    private List<Friend> getFriendsForUser(String userId) {
        List<Friend> allFriends = friendRepository.findAll();

        return allFriends.stream()
                .filter(friend -> FriendStatus.ACCEPTED.equals(friend.getStatus()) &&
                        (friend.getUserId().equals(userId) || friend.getFriendId().equals(userId)))
                .collect(Collectors.toList());
    }

    private void applyUpdates(User user, UserUpdateRequest request) {
        Optional.ofNullable(request.getUsername()).ifPresent(user::setUsername);
        Optional.ofNullable(request.getFullName()).ifPresent(user::setFullName);
        Optional.ofNullable(request.getImg()).ifPresent(user::setImg);
        Optional.ofNullable(request.getStatus()).ifPresent(user::setStatus);

        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
    }
}

