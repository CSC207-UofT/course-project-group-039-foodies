package main.java.Entities;
import main.java.Entities.User;

import java.util.ArrayList;
import java.util.Scanner;

/** Group (Entity)
 *  Responsibilities: - Store users in a group (completed in GroupManager)
 *                    - Store family preferences
 *                    - Add/invite users to a group (completed in GroupManager)
 *                    - Delete a user from a group (completed in GroupManager)
 *                    - Store a RecipeBook
 *  Collaborators: - User
 *                 - RecipeBook
 *
 *
 *  Questions: - Should we create a unique ID for each group? (generateGroupCode() is implemented)
 *             - Can a user join multiple groups?
 *             -
 *
 */
public class Group {
    /** Creates a Group object */
    private final String groupName;
    private String groupCode;
    private final ArrayList<String> groupMembers;
    private final ArrayList<String> usedCodes;
    private final RecipeBook recipeBook;

    /**
     * Creates a group with a group name
     *
     * @param
     */
    public Group(String groupName) {
        this.groupName = groupName;
        this.groupCode = "";
        this.groupMembers = new ArrayList<>();
        this.usedCodes = new ArrayList<>();
        this.recipeBook = new RecipeBook();
    }

    public String generateGroupCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "1234567890"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder groupCode = new StringBuilder(7);
        for (int i = 0; i < groupCode.capacity(); i++) {
            int index = (int)(chars.length() * Math.random());
            groupCode.append(chars.charAt(index));
        }
        if (this.usedCodes.contains(groupCode.toString())) {
            return generateGroupCode();
        } else {
            this.usedCodes.add(groupCode.toString());
            return groupCode.toString();
        }
    }

    public String getGroupName() {return this.groupName;}

    public String getGroupCode() {return this.groupCode;}

    public ArrayList<String> getGroupMembers() {return this.groupMembers;}

    public RecipeBook getRecipeBook() { return this.recipeBook; }


    public static void main(String[] args) {
//        This provides an example usage of generateGroupCode():
//        ArrayList<String> members = new ArrayList<>();
//        members.add("abc");
//        Group newGroup = new Group("abc", "abc", members);
//        System.out.println(newGroup.generateGroupCode());

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the group name: ");
        String groupName = keyboard.nextLine();
        Group group = new Group(groupName);
        String groupCode = group.generateGroupCode();
        System.out.print("Your group code is " + groupCode);
        group.groupCode = groupCode;
    }
}
