package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.request.GroupRequest;
import fit.nlu.appchat.dto.response.GroupResponse;
import fit.nlu.appchat.entity.Group;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.mapper.GroupMapper;
import fit.nlu.appchat.repository.GroupRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupService {
    GroupRepository groupRepository;
    GroupMapper groupMapper;

    public GroupResponse createGroup(GroupRequest groupRequest, String creatorId) {
        Group group = groupMapper.toGroup(groupRequest);
        group.setCreatorId(creatorId);
        group.setAdminIds(Collections.singletonList(creatorId));
        Group savedGroup = groupRepository.save(group);

        return groupMapper.toGroupResponse(savedGroup);
    }

    public List<GroupResponse> getGroupsByUserId(String userId) {
        List<Group> groups = groupRepository.findByMemberIdsContaining(userId);
        return groups.stream().map(groupMapper::toGroupResponse).collect(Collectors.toList());
    }

    public void addAdmin(String groupId, String adminId, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_OR_MEMBER_NOT_FOUND));

        if (!group.getCreatorId().equals(userId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        List<String> adminIds = group.getAdminIds();
        if (!adminIds.contains(adminId)) {
            adminIds.add(adminId);
            group.setAdminIds(adminIds);
            groupRepository.save(group);
        }
    }

    public void removeAdmin(String groupId, String adminId, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_OR_MEMBER_NOT_FOUND));

        if (!group.getCreatorId().equals(userId) && !group.getAdminIds().contains(userId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        List<String> adminIds = group.getAdminIds();
        if (adminIds.contains(adminId)) {
            adminIds.remove(adminId);
            group.setAdminIds(adminIds);
            groupRepository.save(group);
        }
    }


    public GroupResponse addMembers(String groupId, List<String> memberIds, String requesterId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (!group.getAdminIds().contains(requesterId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        List<String> currentMemberIds = group.getMembers();
        for (String memberId : memberIds) {
            if (!currentMemberIds.contains(memberId)) {
                currentMemberIds.add(memberId);
            }
        }
        group.setMembers(currentMemberIds);
        Group updatedGroup = groupRepository.save(group);
        return groupMapper.toGroupResponse(updatedGroup);
    }

    public GroupResponse removeMembers(String groupId, List<String> memberIds, String requesterId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (!group.getAdminIds().contains(requesterId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        List<String> currentMemberIds = group.getMembers();
        for (String memberId : memberIds) {
            currentMemberIds.remove(memberId);
        }
        group.setMembers(currentMemberIds);
        Group updatedGroup = groupRepository.save(group);
        return groupMapper.toGroupResponse(updatedGroup);
    }

    public GroupResponse leaveGroup(String groupId, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (group.getCreatorId().equals(userId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        List<String> currentMembers = group.getMembers();
        currentMembers.remove(userId);

        group.setMembers(currentMembers);
        Group updatedGroup = groupRepository.save(group);
        return groupMapper.toGroupResponse(updatedGroup);
    }


    public void deleteGroup(String groupId, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (!group.getCreatorId().equals(userId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        groupRepository.delete(group);
    }

    public GroupResponse updateGroupDetails(String groupId, GroupRequest groupRequest, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (!group.getAdminIds().contains(userId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        if (groupRequest.getGroupName() != null) {
            group.setGroupName(groupRequest.getGroupName());
        }

        Group updatedGroup = groupRepository.save(group);
        return groupMapper.toGroupResponse(updatedGroup);
    }

    public GroupResponse updateGroupAvatar(String groupId, String img, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (!group.getAdminIds().contains(userId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        if (img != null) {
            group.setAvatar(img);
        }

        Group updatedGroup = groupRepository.save(group);
        return groupMapper.toGroupResponse(updatedGroup);
    }
}
