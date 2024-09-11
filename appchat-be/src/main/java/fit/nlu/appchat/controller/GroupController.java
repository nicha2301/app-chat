package fit.nlu.appchat.controller;

import fit.nlu.appchat.dto.request.GroupRequest;
import fit.nlu.appchat.dto.response.ApiResponse;
import fit.nlu.appchat.dto.response.GroupResponse;
import fit.nlu.appchat.service.GroupService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupController {
    GroupService groupService;

    /**
     * template json (at least 2 members)
     * {
     * "groupName": "Test Group 2",
     * "memberIds": [
     * "66dc432eecfe527aebb4cf23",
     * "66dc4329ecfe527aebb4cf22"
     * ]
     * }
     */
    @PostMapping
    public ApiResponse<GroupResponse> createGroup(@RequestBody GroupRequest groupRequest) {
        GroupResponse response = groupService.createGroup(groupRequest);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("Group created successfully")
                .result(response)
                .build();
    }


    @GetMapping("/user/{userId}/groups")
    public ApiResponse<List<GroupResponse>> getGroupsByUserId(@PathVariable String userId) {
        List<GroupResponse> groupResponses = groupService.getGroupsByUserId(userId);
        return ApiResponse.<List<GroupResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("User's groups fetched successfully")
                .result(groupResponses)
                .build();
    }

    /**
     * template json
     * {
     * "groupName": "Test Group 2",
     * "avatar": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgPbd2MBbw3o5_yzYC_pPjoVNKUx7WCrMN3g"
     * }
     */
    @PatchMapping("/{groupId}")
    public ApiResponse<GroupResponse> updateGroupDetails(@PathVariable String groupId,
                                                         @RequestBody GroupRequest groupRequest) {
        GroupResponse response = groupService.updateGroupDetails(groupId, groupRequest);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Group details updated successfully")
                .result(response)
                .build();
    }

    /**
     * /api/groups/{groupId}/admins?adminId={adminId}
     * /api/groups/66e0528ae2d7fe5529bc5589/admins?adminId=66dc4329ecfe527aebb4cf11
     */
    @PostMapping("/{groupId}/admins")
    public ApiResponse<GroupResponse> addAdmin(@PathVariable String groupId,
                                               @RequestParam String adminId) {
        GroupResponse response = groupService.addAdmin(groupId, adminId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Admin added successfully")
                .result(response)
                .build();
    }

    /**
     * /api/groups/{groupId}/admins?adminId={adminId}
     * /api/groups/66e0528ae2d7fe5529bc5589/admins?adminId=66dc4329ecfe527aebb4cf11
     */
    @DeleteMapping("/{groupId}/admins")
    public ApiResponse<GroupResponse> removeAdmin(@PathVariable String groupId,
                                                  @RequestParam String adminId) {
        GroupResponse response = groupService.removeAdmin(groupId, adminId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Admin removed successfully")
                .result(response)
                .build();
    }

    /**
     * template json
     * {
     *     "memberIds": [
     *         "66dc410760fed86a0b9fdc1e",
     *         "66dc410760fed86a0b9fdc1e"
     *     ]
     * }
     */
    @PostMapping("/{groupId}/members")
    public ApiResponse<GroupResponse> addMembers(@PathVariable String groupId,
                                                 @RequestBody List<String> memberIds) {
        GroupResponse response = groupService.addMembers(groupId, memberIds);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Members added successfully")
                .result(response)
                .build();
    }

    /**
     * template json
     * {
     *     "memberIds": [
     *         "66dc410760fed86a0b9fdc1e"
     *     ]
     * }
     */
    @DeleteMapping("/{groupId}/members")
    public ApiResponse<GroupResponse> removeMembers(@PathVariable String groupId,
                                                    @RequestBody List<String> memberIds) {
        GroupResponse response = groupService.removeMembers(groupId, memberIds);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Members removed successfully")
                .result(response)
                .build();
    }

    @DeleteMapping("/{groupId}/leave")
    public ApiResponse<GroupResponse> leaveGroup(@PathVariable String groupId,
                                                 @RequestParam String userId) {
        GroupResponse response = groupService.leaveGroup(groupId, userId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("User left the group successfully")
                .result(response)
                .build();
    }


    @DeleteMapping("/{groupId}")
    public ApiResponse<Void> deleteGroup(@PathVariable String groupId,
                                         @RequestParam String requesterId) {
        groupService.deleteGroup(groupId, requesterId);
        return ApiResponse.<Void>builder()
                .code(HttpStatus.OK.value())
                .message("Group deleted successfully")
                .build();
    }
}
