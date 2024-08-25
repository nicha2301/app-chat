package fit.nlu.appchat.controller;

import fit.nlu.appchat.dto.request.UserCreationRequest;
import fit.nlu.appchat.dto.request.UserUpdateRequest;
import fit.nlu.appchat.dto.response.ApiResponse;
import fit.nlu.appchat.dto.response.UserResponse;
import fit.nlu.appchat.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("create successfully")
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponses = userService.getAllUsers();
        return ApiResponse.<List<UserResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("get users successfully")
                .result(userResponses)
                .build();
    }

    @GetMapping("/{username}")
    ApiResponse<UserResponse> getUserByUsername(@PathVariable String username) {
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .message("get user successfully")
                .result(userService.findByUsername(username))
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<UserResponse> getUserById(@PathVariable String id) {
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .message("get user successfully")
                .result(userService.getUserById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse deleteUserById(@PathVariable String id) {
        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("delete user successfully")
                .result(userService.deleteUserById(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .message("update user successfully")
                .result(userService.updateUser(id, request))
                .build();
    }
}