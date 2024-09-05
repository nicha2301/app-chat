package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.request.UserCreationRequest;
import fit.nlu.appchat.dto.request.UserUpdateRequest;
import fit.nlu.appchat.dto.response.UserResponse;
import fit.nlu.appchat.entity.User;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.mapper.UserMapper;
import fit.nlu.appchat.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        var list = userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
        if (list.isEmpty())
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        return list;
    }

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
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

        user.builder()
                .username(request.getUsername())
                .fullName(request.getFullName());

        User updatedUser = userRepository.save(user);
        return userMapper.toUserResponse(updatedUser);
    }
}

