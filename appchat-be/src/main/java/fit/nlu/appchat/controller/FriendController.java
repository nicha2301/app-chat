package fit.nlu.appchat.controller;

import fit.nlu.appchat.dto.request.FriendRequest;
import fit.nlu.appchat.dto.response.ApiResponse;
import fit.nlu.appchat.dto.response.FriendResponse;
import fit.nlu.appchat.service.FriendService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FriendController {
    FriendService friendService;

    @PostMapping
    public ApiResponse<FriendResponse> sendFriendRequest(@RequestBody FriendRequest request) {
        FriendResponse response = friendService.sendFriendRequest(request);
        return ApiResponse.<FriendResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("Friend request sent successfully")
                .result(response)
                .build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<List<FriendResponse>> getFriendsForUser(@PathVariable String userId) {
        List<FriendResponse> friends = friendService.getFriendsForUser(userId);
        return ApiResponse.<List<FriendResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("Friends retrieved successfully")
                .result(friends)
                .build();
    }

    @PostMapping("/accept/{userId}/{friendId}") //accept/nguoi gui yeu cau/nguoi chap nhan
    public ApiResponse<String> acceptFriendRequest(@PathVariable String userId, @PathVariable String friendId) {
        friendService.acceptFriendRequest(userId, friendId);
        return ApiResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .message("Friend request accepted")
                .result("Friend request accepted for user " + userId + " and friend " + friendId)
                .build();
    }

    @PostMapping("/reject/{friendId}")
    public ApiResponse<String> rejectFriendRequest(@PathVariable String friendId) {
        friendService.rejectFriendRequest(friendId);
        return ApiResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .message("Friend request rejected")
                .result("Friend request rejected for friend ID " + friendId)
                .build();
    }
}