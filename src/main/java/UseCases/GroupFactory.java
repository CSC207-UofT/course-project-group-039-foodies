package main.java.UseCases;

import main.java.Entities.Group;
import main.java.Entities.User;
import main.java.UseCases.Utilities.GroupManager;

import java.util.ArrayList;

public class GroupFactory{

    private static final ArrayList<String> usedCodes = new ArrayList<>();


    /**
     * Generates a unique 7 digit group code and assign the code to the group.
     */
    public static String generateGroupCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "1234567890"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder groupCode = new StringBuilder(7);
        for (int i = 0; i < groupCode.capacity(); i++) {
            int index = (int)(chars.length() * Math.random());
            groupCode.append(chars.charAt(index));
        }
        if (usedCodes.contains(groupCode.toString())) {
            return generateGroupCode();
        } else {
            usedCodes.add(groupCode.toString());
            // group.groupCode = groupCode.toString();
            return groupCode.toString();
        }
    }


    /**
     * @param groupName The name of the group.
     * @param creator The user who creates the group.
     * @return The created recipe
     */
    public static Group createNewGroup(String groupName, User creator) {
        String groupCode = generateGroupCode();
        Group newGroup = new Group(groupName, groupCode);
        GroupManager.addGroup(newGroup);
        GroupManager.addMember(newGroup, creator);
        return newGroup;
    }
}
