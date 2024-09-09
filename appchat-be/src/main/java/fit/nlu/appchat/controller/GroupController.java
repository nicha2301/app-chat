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

    @PostMapping
    public ApiResponse<GroupResponse> createGroup(@RequestBody GroupRequest groupRequest,
                                                  @RequestParam String creatorId) {
        GroupResponse response = groupService.createGroup(groupRequest, creatorId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("Group created successfully")
                .result(response)
                .build();
    }

    @PatchMapping("/{groupId}")
    public ApiResponse<GroupResponse> updateGroupDetails(@PathVariable String groupId,
                                                         @RequestBody GroupRequest groupRequest,
                                                         @RequestParam String userId) {
        GroupResponse response = groupService.updateGroupDetails(groupId, groupRequest, userId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Group details updated successfully")
                .result(response)
                .build();
    }

    @PostMapping("/{groupId}/members")
    public ApiResponse<GroupResponse> addMembers(@PathVariable String groupId,
                                                 @RequestBody List<String> memberIds,
                                                 @RequestParam String userId) {
        GroupResponse response = groupService.addMembers(groupId, memberIds, userId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Members added successfully")
                .result(response)
                .build();
    }

    @DeleteMapping("/{groupId}/members")
    public ApiResponse<GroupResponse> removeMembers(@PathVariable String groupId,
                                                    @RequestBody List<String> memberIds,
                                                    @RequestParam String userId) {
        GroupResponse response = groupService.removeMembers(groupId, memberIds, userId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Members removed successfully")
                .result(response)
                .build();
    }

    @PatchMapping("/{groupId}/avatar")
    public ApiResponse<GroupResponse> changeAvatar(@PathVariable String groupId,
                                                   @RequestParam String newAvatar,
                                                   @RequestParam String userId) {
        GroupResponse response = groupService.updateGroupAvatar(groupId, newAvatar, userId);
        return ApiResponse.<GroupResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Group avatar changed successfully")
                .result(response)
                .build();
    }
}
