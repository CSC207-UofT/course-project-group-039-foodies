package main.java.UseCases.Utilities;

import main.java.Entities.Group;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupManager {
    static HashMap<String, ArrayList<String>> groupMap = new HashMap<>();
    static HashMap<String, String> groupNameMap = new HashMap<>();

    /**
     * Return whether a group with a certain group code is in the groupMap
     * @param groupCode The 7 digit Group Code.
     * @return True if and only if group is in groupMap
     */
    public static boolean containsGroup(String groupCode) {
        return groupMap.containsKey(groupCode);
    }


    /**
     * If the group code does not appear as a key in groupMap,
     * then add the list of the group members as its value to groupMap.
     * @param group The 7 digit Group Code.
     * @return true if the group was successfully added to groupMap, and false otherwise.
     */
    public static boolean addGroup(Group group) {
        String groupCode = group.getGroupCode();
        String groupName = group.getGroupName();

        if (groupMap.containsKey(groupCode)) {
            return false;
        } else {
            groupMap.put(groupCode, group.getGroupMembers());
            groupNameMap.put(groupCode, groupName);
            return true;
        }
    }


    /**
     * Adds a new member to the group.
     * @param groupCode The group object.
     * @param username The username of a user to be added.
     * @return true if the user was successfully added to the group, and false otherwise.
     */
    public static boolean addMember(String groupCode, String username) {
        if (containsGroup(groupCode) && !groupMap.get(groupCode).contains(username)){
            groupMap.get(groupCode).add(username);
            return true;
        } else {
            return false;
        }
    }


    /**
     * If the group contains the username, then remove the user from the group.
     * @param groupCode The 7 digit Group Code.
     * @param username The username of a user to be deleted from the group.
     * @return true if the user was successfully deleted from the group, and false otherwise.
     */
    public static boolean removeMember(String groupCode, String username) {
        if (groupMap.containsKey(groupCode) && groupMap.get(groupCode).contains(username)) {
            groupMap.get(groupCode).remove(username);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Show all the group information that a user has joined in.
     * @param username The username of a user .
     * @return the group name and the group code of the groups that a user has joined in.
     */
    public static String getJoinedGroups(String username) {
        StringBuilder groups = new StringBuilder();
        for (String groupCode : groupMap.keySet()) {
            if (groupMap.get(groupCode).contains(username)) {
                groups.append(groupCode).append(" : ").append(groupNameMap.get(groupCode)).append("\n");
            }
        } return groups.toString();
    }
}
