package main.java.Entities;
import main.java.Entities.User;

import java.util.ArrayList;
import java.util.Scanner;


public class Group {
    /** Creates a Group object */
    private final String groupName;
    private String groupCode;
    private final ArrayList<String> groupMembers;
    private final ArrayList<String> usedCodes;
    private final RecipeBook recipeBook;


    /**
     * Creates a group with a name, group code, group members, and Recipe Book.
     * @param groupName - the name of the group
     */
    public Group(String groupName) {
        this.groupName = groupName;
        this.groupCode = "";
        this.groupMembers = new ArrayList<>();
        this.recipeBook = new RecipeBook();
        this.usedCodes = new ArrayList<>();
    }


    /**
     * Generates a unique 7 digit group code and assign the code to the group.
     * @param group - the name of the group
     */
    public String generateGroupCode(Group group) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "1234567890"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder groupCode = new StringBuilder(7);
        for (int i = 0; i < groupCode.capacity(); i++) {
            int index = (int)(chars.length() * Math.random());
            groupCode.append(chars.charAt(index));
        }
        if (this.usedCodes.contains(groupCode.toString())) {
            return generateGroupCode(group);
        } else {
            this.usedCodes.add(groupCode.toString());
            group.groupCode = groupCode.toString();
            return groupCode.toString();
        }
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
     * @return - return the recipeBook
     */
    public RecipeBook getRecipeBook() { return this.recipeBook; }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the group name: ");
        String groupName = keyboard.nextLine();
        Group group = new Group(groupName);
        group.generateGroupCode(group);
        String groupCode = group.getGroupCode();
        System.out.print("Your group code is " + groupCode);
    }
}
