package main.java.UseCases.Utilities;

import main.java.Entities.User;
import main.java.Entities.Group;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupManager {
    static HashMap<String, ArrayList<String>> groupMap = new HashMap<>(); // Each key is unique group code

    /**
     * Return whether a group with a certain group code is in the groupMap
     * @return True if and only if group is in groupMap
     */
    public static boolean containsGroup(Group group) {
        String groupCode = group.getGroupCode();
        return groupMap.containsKey(groupCode);
    }

    public static Group createNewGroup(String groupName, User creator) {
        Group group = new Group(groupName);
        group.generateGroupCode(group);
        group.getGroupMembers().add(creator.getUsername());
        return group;
    }

    public static boolean addGroup(Group group) {
        String groupCode = group.getGroupCode();
        if (groupMap.containsKey(groupCode)) {
            return false;
        } else {
            groupMap.put(groupCode, group.getGroupMembers());
            return true;
        }
    }

    public static boolean addMember(Group group, User member) {
        String groupCode = group.getGroupCode();
        String username = member.getUsername();
        if (containsGroup(group) && !group.getGroupMembers().contains(username)){
            groupMap.get(groupCode).add(username);
            return true;
        } else {
            return false;
        }
    }

    public static boolean removeMember(Group group, User member) {
        String groupCode = group.getGroupCode();
        String username = member.getUsername();
        if (groupMap.containsKey(groupCode) && groupMap.get(groupCode).contains(username)) {
            groupMap.get(groupCode).remove(username);
            return true;
        } else {
            return false;
        }
    }
}
