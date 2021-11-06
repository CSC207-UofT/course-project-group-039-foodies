package main.java.UseCases.Utilities;

import main.java.Entities.User;
import main.java.Entities.Group;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupManager {
    static HashMap<String, ArrayList<String>> groupMap = new HashMap<>();

    /**
     * Return whether a group with a certain group code is in the groupMap
     * @param group The group object.
     * @return True if and only if group is in groupMap
     */
    public static boolean containsGroup(Group group) {
        String groupCode = group.getGroupCode();
        return groupMap.containsKey(groupCode);
    }


    /**
     * Create a group
     * @param groupName The name of the group.
     * @param creator The user who creates the group.
     * @return The group object with the group's unique group code and
     * the list of members that contains the user who creates the group.
     */
    public static Group createNewGroup(String groupName, User creator) {
        Group group = new Group(groupName);
        group.generateGroupCode(group);
        group.getGroupMembers().add(creator.getUsername());
        return group;
    }


    /**
     * If the group code does not appear as a key in groupMap,
     * then add the list of the group members as its value to groupMap.
     * @param group The group code.
     * @return true if the group was successfully added to groupMap, and false otherwise.
     */
    public static boolean addGroup(Group group) {
        String groupCode = group.getGroupCode();
        if (groupMap.containsKey(groupCode)) {
            return false;
        } else {
            groupMap.put(groupCode, group.getGroupMembers());
            return true;
        }
    }


    /**
     * Adds a new member to the group.
     * @param group The group object.
     * @param member The user object to be added.
     * @return true if the user was successfully added to the group, and false otherwise.
     */
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


    /**
     * If the group contains the username, then remove the user from the group.
     * @param group The group object.
     * @param member The user object to be deleted from the group.
     * @return true if the user was successfully deleted from the group, and false otherwise.
     */
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
