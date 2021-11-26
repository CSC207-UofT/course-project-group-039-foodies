package main.java.Gateways;

import main.java.Entities.Group;
import main.java.Entities.User;
import main.java.UseCases.Utilities.GroupManager;

import java.util.ArrayList;

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
        super(path, new String[]{"name", "code", "members"});
    }

    /**
     * Adds a group to the database given a group object
     * @param group The group to add
     */
    public void saveGroup(Group group) {
        saveGroup(group.getGroupName(), group.getGroupCode(), group.getGroupMembers());
    }

    /**
     * Adds a group to groups.csv given all the required information
     * @param name The name of the group
     * @param members The list of the group members
     */
    public void saveGroup(String name, String code, ArrayList<String> members) {
        ArrayList<String> groupData = new ArrayList<>();

        groupData.add(name);
        groupData.add(code);
        groupData.add(String.join(",", members));

        writeLine(groupData);
    }

    /**
     * Checks if a group exists with a certain groupName
     * @param groupName The group to check
     * @return A boolean representing whether there is a group with certain groupName
     */
    public boolean isGroup(String groupName) {
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(0).equals(groupName)) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * Removes a group from the database
     * @param name The name of the group to remove
     */
    public void removeGroup(String name) {
        removeLine(name, "name");
    }


    /**
     * Checks if a username exists in a certain group
     * @param groupCode The group code
     * @param username The username to check
     * @return A boolean representing whether there is a username in certain groupCode
     */
    public boolean containsMember(String groupCode, String username) {
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && line.get(1).equals(groupCode)) {
                return line.get(2).contains(username);
            }
        }
        return false;
    }
}


