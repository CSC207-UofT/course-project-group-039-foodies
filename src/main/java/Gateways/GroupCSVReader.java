package main.java.Gateways;

import main.java.Entities.Group;
import main.java.UseCases.GroupFactory;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupCSVReader extends CSVReader {
    private final static GroupCSVReader instance = new GroupCSVReader(
            System.getProperty("user.dir") + "/src/main/java/Gateways/databases/groups.csv"
    ); // a singleton

    private final static GroupCSVReader testInstance = new GroupCSVReader(
            System.getProperty("user.dir") + "/src/test/java/GatewaysTests/groupsTest.csv"
    ); // a singleton for testing safely

    public static GroupCSVReader getInstance() {
        return instance;
    }

    public static GroupCSVReader getTestInstance() {
        return testInstance;
    }

    private GroupCSVReader(String path) {
        super(path, new String[]{"code", "name", "members"});
    }

    /**
     * Adds a group to the database given a group object
     * @param group The group to add
     * @return A boolean representing whether the group is successfully added to groups.csv
     */
    public boolean saveGroup(Group group) {
        return saveGroup(group.getGroupCode(), group.getGroupName(), group.getGroupMembers());
    }

    /**
     * Adds a group to groups.csv given all the required information
     * @param groupName The name of the group
     * @param members The list of the group members
     * @return A boolean representing whether the group is successfully added to groups.csv
     */
    public boolean saveGroup(String groupCode, String groupName, ArrayList<String> members) {
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(0).equals(groupCode)) {
                return false;
            }
        }
        ArrayList<String> groupData = new ArrayList<>();

        groupData.add(groupCode);
        groupData.add(groupName);
        groupData.add(String.join(",", members));

        writeLine(groupData);
        return true;
    }


    /**
     * Checks if a group exists with a certain groupName
     * @param groupCode The group code to check
     * @return A boolean representing whether there is a group with certain groupCode
     */
    public boolean isGroup(String groupCode) {
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(0).equals(groupCode)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Removes a group from the database
     * @param groupCode The group code of the group to remove
     */
    public void removeGroup(String groupCode) {
        removeLine(groupCode, "code");
    }


    /**
     * Checks if a username exists in a certain group
     * @param groupCode The group code
     * @param username The username to check
     * @return A boolean representing whether a certain group contains the username
     */
    public boolean containsMember(String groupCode, String username) {
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(0).equals(groupCode)) {
                return line.get(2).contains(username);
            }
        }
        return false;
    }


    /**
     * Adds a member to a certain group
     * @param groupCode The group code
     * @param username The username to be added
     * @return A boolean representing whether a new member is successfully added to a certain group
     */
    public boolean addMember(String groupCode, String username) {
        ArrayList<String> updatedMembers = new ArrayList<>();
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(0).equals(groupCode) &&
                    !containsMember(groupCode, username)) {
                String groupName = line.get(1);
                String members = line.get(2);
                String[] str = members.split(",");
                List<String> membersList;
                membersList = Arrays.asList(str);
                updatedMembers.addAll(membersList);
                updatedMembers.add(username);
                removeGroup(groupCode);
                saveGroup(groupCode, groupName, updatedMembers);
                return true;
            }
        } return false;
    }


    /**
     * Removes a member from a certain group
     * @param groupCode The group code
     * @param username The username to be removed
     * @return A boolean representing whether a new member is successfully removed from a certain group
     */
    public boolean removeMember(String groupCode, String username) {
        ArrayList<String> updatedMembers = new ArrayList<>();
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(0).equals(groupCode) &&
                    containsMember(groupCode, username)) {
                String groupName = line.get(1);
                String members = line.get(2);
                String[] str = members.split(",");
                List<String> membersList;
                membersList = Arrays.asList(str);

                for (String member : membersList) {
                    if (!member.equals(username)) {
                        updatedMembers.add(member);
                    }
                }
                removeGroup(groupCode);
                saveGroup(groupCode, groupName, updatedMembers);
                return true;
            }
        } return false;
    }


    /**
     * Shows all the groups that a user has joined in.
     * @param username The username of a user .
     * @return the group name and the group code of the groups that a user has joined in.
     */
    public String getJoinedGroups(String username) {
        StringBuilder groups = new StringBuilder();
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(2).contains(username)) {
                String groupCode = line.get(0);
                String groupName = line.get(1);
                groups.append(groupName).append(" : ").append(groupCode).append("\n");
            }
        } return groups.toString();

    }


    public Group getGroup(String groupName, String username) {
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(1).equals(groupName) && line.get(2).contains(username)) {
                String groupCode = line.get(0);
                String groupMembers = line.get(2);
                ArrayList<String> members = new ArrayList<>(Arrays.asList(groupMembers.split(",")));
                return new Group(groupName, groupCode, members);
            }
        } return null;
    }
}


