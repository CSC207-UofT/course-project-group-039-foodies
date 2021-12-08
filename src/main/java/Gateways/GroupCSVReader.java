package main.java.Gateways;

import main.java.Entities.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;


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
     * Adds a group to groups.csv given all the required information
     * @param groupCode The group code of a group
     * @param groupName The name of a group
     * @param members The list of group members
     */
    public void saveGroup(String groupCode, String groupName, ArrayList<String> members) {
        if (!isGroup(groupCode)) {
            ArrayList<String> groupData = new ArrayList<>();
            groupData.add(groupCode);
            groupData.add(groupName);

            StringJoiner groupMembers = new StringJoiner(",", "", ",");
            for (String member : members) {
                groupMembers.add(member);
            }
            groupData.add(groupMembers.toString());
            writeLine(groupData);
        }
    }


    /**
     * Checks if a group exists with a certain groupName
     * @param groupCode The group code to check
     */
    public boolean isGroup(String groupCode) {
        if (readFile().isEmpty()) {
            return false;
        }
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(0).equals(groupCode)) {
                return true;
            }
        } return false;
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


    /**groupData.add(String.join(",", members));
     * Adds a member to a certain group
     * @param groupCode The group code
     * @param username The username to be added
     */
    public void addMember(String groupCode, String username) {
        if (isGroup(groupCode) && !containsMember(groupCode, username)) {
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
                }
            }
        }
    }


    /**
     * Removes a member from a certain group
     * @param groupCode The group code
     * @param username The username to be removed
     */
    public void removeMember(String groupCode, String username) {
        if (isGroup(groupCode) && containsMember(groupCode, username)) {
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
                }
            }
        }
    }


    /**
     * Shows all the groups that a user has joined in.
     * @param username The username of a user .
     * @return the group name and the group code of the groups that a user has joined in.
     */
    public String getJoinedGroups(String username) {
        StringBuilder groups = new StringBuilder();
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && contains(line.get(2).split(","), username)) {
                String groupCode = line.get(0);
                String groupName = line.get(1);
                groups.append(groupName).append(" : ").append(groupCode).append("\n");
            }
        } return groups.toString();

    }

    /**
     * Return whether the username is in the list of names
     * @param names The list of username
     * @param find The username to find
     * @return Whether the username is in the list of names
     */
    private boolean contains(String[] names, String find) {
        for (String name : names) {
            if (name.equals(find)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the group containing the user username, with name groupName
     * @param groupName The name of the group
     * @param username The name of the user
     * @return The group if it exists and null if it doesn't exist
     */
    public Group getGroup(String groupName, String username) {
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(1).equals(groupName) && contains(line.get(2).split(","), username)) {
                String groupCode = line.get(0);
                String groupMembers = line.get(2);
                ArrayList<String> members = new ArrayList<>(Arrays.asList(groupMembers.split(",")));
                return new Group(groupName, groupCode, members);
            }
        } return null;
    }
}
