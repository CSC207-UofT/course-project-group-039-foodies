package main.java.Gateways;

import main.java.Entities.Group;
import main.java.UseCases.GroupFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupCSVReader extends CSVReader {
  public class GroupCSVReader extends CSVReader {
    private final static GroupCSVReader instance = new GroupCSVReader(
            System.getProperty("user.dir") + "\\src\\main\\java\\Gateways\\databases\\groups.csv"
    ); // a singleton

    private final static GroupCSVReader testInstance = new GroupCSVReader(
            System.getProperty("user.dir") + "\\src\\test\\java\\GatewaysTests\\groupsTest.csv"
    ); // a singleton for testing safely

    public static GroupCSVReader getInstance() {
        return instance;
    }

    public static GroupCSVReader getTestInstance() {
        return testInstance;
    }

    private GroupCSVReader(String path) {
        super(path, new String[]{"name", "members"});
    }

    /**
     * Adds a group to groups.csv
     * @param group The group to add
     */
    public void saveGroup(Group group) {
        saveGroup(
                group.getGroupName(),
                group.getGroupMembers()
        );
    }

    /**
     * Adds a group to groups.csv given all the required information
     * @param name The name of the group
     * @param members The list of the group members
     */
    public void saveGroup(String name, ArrayList<String> members) {
        ArrayList<String> groupData = new ArrayList<>();
        groupData.add(name);
        groupData.add(String.join(",", members));

        writeLine(groupData);
    }


    /**
     * Removes a group from the database
     * @param name The name of the group to remove
     */
    public void removeGroup(String name) {
        removeLine(name, "name");
    }

}
