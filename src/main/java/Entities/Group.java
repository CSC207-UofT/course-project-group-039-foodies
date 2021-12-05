package main.java.Entities;

import java.util.ArrayList;


public class Group {
    /** Creates a Group object */
    private final String groupName;
    private final String groupCode;
    private final ArrayList<String> groupMembers;
    private final GroupRecipeBook groupRecipeBook;


    /**
     * Creates a group with a name, group code, group members, and Recipe Book.
     * @param groupName - the name of a group
     */
    public Group(String groupName, String groupCode) {
        this.groupName = groupName;
        this.groupCode = groupCode;
        this.groupMembers = new ArrayList<>();
        this.groupRecipeBook = new GroupRecipeBook();
    }

    public Group(String groupName, String groupCode, ArrayList<String> groupMembers) {
        this.groupName = groupName;
        this.groupCode = groupCode;
        this.groupMembers = groupMembers;
        this.groupRecipeBook = new GroupRecipeBook();
    }


    /**
     * Returns the group's name.
     * @return - groupName
     */
    public String getGroupName() {return this.groupName;}


    /**
     * Returns the group's unique code.
     * @return - groupCode
     */
    public String getGroupCode() {return this.groupCode;}


    /**
     * Returns the list of the group members.
     * @return - groupMembers
     */
    public ArrayList<String> getGroupMembers() {return this.groupMembers;}


    /**
     * Returns the group's recipebook
     * @return - return the groupRecipeBook
     */
    public GroupRecipeBook getRecipeBook() { return this.groupRecipeBook; }

}