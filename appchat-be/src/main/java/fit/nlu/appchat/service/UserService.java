package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.request.UserCreationRequest;
import fit.nlu.appchat.dto.response.ApiResponse;
import fit.nlu.appchat.dto.response.UserResponse;
import fit.nlu.appchat.entity.User;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.exception.ErrorCode;
import fit.nlu.appchat.mapper.UserMapper;
import fit.nlu.appchat.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}

