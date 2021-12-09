package main.java.Entities;

import java.util.ArrayList;

/**
 * A Group object which contains name, code, ArrayList of members, and group recipe book.
 */
public class Group {
    private final String groupName;
    private final String groupCode;
    private final ArrayList<String> groupMembers;
    private final GroupRecipeBook groupRecipeBook;

    /**
     * Create a group with name and code.
     * @param groupName name of the group.
     * @param groupCode code of the group.
     */
    public Group(String groupName, String groupCode) {
        this.groupName = groupName;
        this.groupCode = groupCode;
        this.groupMembers = new ArrayList<>();
        this.groupRecipeBook = new GroupRecipeBook();
    }

    /**
     * Create a group with name, code, and ArrayList of members.
     * @param groupName name of the group.
     * @param groupCode code of the group.
     * @param groupMembers ArrayList of members.
     */
    public Group(String groupName, String groupCode, ArrayList<String> groupMembers) {
        this.groupName = groupName;
        this.groupCode = groupCode;
        this.groupMembers = groupMembers;
        this.groupRecipeBook = new GroupRecipeBook();
    }

    /**
     * Gets the group's name.
     * @return name of the group.
     */
    public String getGroupName() {return this.groupName;}

    /**
     * Gets the group's unique code.
     * @return code of the group.
     */
    public String getGroupCode() {return this.groupCode;}

    /**
     * Gets the list of the group members.
     * @return ArrayList of members.
     */
    public ArrayList<String> getGroupMembers() { return this.groupMembers; }

    /**
     * Gets the group's recipe book.
     * @return group recipe book of the group.
     */
    public GroupRecipeBook getRecipeBook() { return this.groupRecipeBook; }

}
