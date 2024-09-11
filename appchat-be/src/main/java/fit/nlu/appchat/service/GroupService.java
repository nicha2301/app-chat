package fit.nlu.appchat.service;

import fit.nlu.appchat.dto.request.GroupRequest;
import fit.nlu.appchat.dto.response.GroupResponse;
import fit.nlu.appchat.entity.Group;
import fit.nlu.appchat.entity.User;
import fit.nlu.appchat.enums.ErrorCode;
import fit.nlu.appchat.exception.AppException;
import fit.nlu.appchat.mapper.GroupMapper;
import fit.nlu.appchat.repository.GroupRepository;
import fit.nlu.appchat.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupService {
    GroupRepository groupRepository;
    UserRepository userRepository;
    GroupMapper groupMapper;

    public GroupResponse createGroup(GroupRequest groupRequest) {
        User user = getAuthenticatedUser();

        List<String> memberIds = groupRequest.getMemberIds();
        if (memberIds == null || memberIds.size() < 2) {
            throw new AppException(ErrorCode.NOT_ENOUGH_MEMBER);
        }

        Group group = Group.builder()
                .groupName(groupRequest.getGroupName())
                .creatorId(user.getId())
                .memberIds(memberIds)
                .adminIds(Collections.singletonList(user.getId()))
                .createdAt(new Date())
                .build();

        return groupMapper.toGroupResponse(groupRepository.save(group));
    }

    public List<GroupResponse> getGroupsByUserId(String userId) {
        return groupRepository.findByMemberIdsContaining(userId)
                .stream()
                .map(groupMapper::toGroupResponse)
                .collect(Collectors.toList());
    }

    public GroupResponse addAdmin(String groupId, String adminId) {
        return modifyRole(groupId, adminId, true, true);
    }

    public GroupResponse removeAdmin(String groupId, String adminId) {
        return modifyRole(groupId, adminId, false, true);
    }

    public GroupResponse addMembers(String groupId, List<String> memberIds) {
        checkUserExist(memberIds);
        return modifyRole(groupId, memberIds, true, false);
    }

    public GroupResponse removeMembers(String groupId, List<String> memberIds) {
        checkUserExist(memberIds);
        return modifyRole(groupId, memberIds, false, false);
    }

    public GroupResponse leaveGroup(String groupId, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (group.getCreatorId().equals(userId))
            throw new AppException(ErrorCode.GROUP_CREATOR);


        Set<String> currentMembers = new HashSet<>(group.getMemberIds());
        if (currentMembers.remove(userId))
            group.setMemberIds(new ArrayList<>(currentMembers));


        return groupMapper.toGroupResponse(groupRepository.save(group));
    }


    public void deleteGroup(String groupId, String userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (!group.getCreatorId().equals(userId)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        groupRepository.delete(group);
    }

    public GroupResponse updateGroupDetails(String groupId, GroupRequest groupRequest) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        if (groupRequest.getGroupName() != null) group.setGroupName(groupRequest.getGroupName());
        if (groupRequest.getAvatar() != null) group.setAvatar(groupRequest.getAvatar());

        return groupMapper.toGroupResponse(groupRepository.save(group));
    }


    private GroupResponse modifyRole(String groupId, Object ids, boolean isAddAction, boolean isAdminAction) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new AppException(ErrorCode.GROUP_NOT_FOUND));

        checkAdminOrCreator(group);

        Set<String> currentMembers = new HashSet<>(group.getMemberIds());
        Set<String> currentAdmins = new HashSet<>(group.getAdminIds());

        if (isAdminAction) {
            modify(currentAdmins, (String) ids, currentMembers, isAddAction, group.getCreatorId());
            group.setAdminIds(new ArrayList<>(currentAdmins));
        } else {
            modify(currentMembers, (List<String>) ids, currentMembers, isAddAction, group.getCreatorId());
            group.setMemberIds(new ArrayList<>(currentMembers));
        }

        return groupMapper.toGroupResponse(groupRepository.save(group));
    }

    private void modify(Set<String> targetSet, String id, Set<String> memberSet, boolean isAddAction, String creatorId) {
        if (!memberSet.contains(id)) throw new AppException(ErrorCode.MEMBER_NOT_FOUND);

        if (isAddAction) {
            targetSet.add(id);
        } else if (!creatorId.equals(id)) {
            targetSet.remove(id);
        } else {
            throw new AppException(ErrorCode.CANNOT_REMOVE_CREATOR);
        }
    }

    private void modify(Set<String> targetSet, List<String> ids, Set<String> memberSet, boolean isAddAction, String creatorId) {
        if (isAddAction) {
            ids.stream()
                    .filter(id -> !targetSet.contains(id))
                    .forEach(targetSet::add);
        } else {
            targetSet.removeAll(ids);
        }
    }

    private void checkAdminOrCreator(Group group) {
        User user = getAuthenticatedUser();
        if (!group.getAdminIds().contains(user.getId()) && !group.getCreatorId().equals(user.getId())) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
    }

    private User getAuthenticatedUser() {
        var context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.UNAUTHENTICATED));
    }

    private List<String> checkUserExist(List<String> memberIds) {
        System.out.println(memberIds);
        List<String> validMemberIds = userRepository.findAllById(memberIds)
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());

        System.out.println(validMemberIds);
        if (validMemberIds.size() != memberIds.size()) {
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }

        return validMemberIds;
    }

}
