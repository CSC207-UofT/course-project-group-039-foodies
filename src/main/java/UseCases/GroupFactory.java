package main.java.UseCases;

import main.java.Entities.Group;
import java.util.ArrayList;


public class GroupFactory{

    private static final ArrayList<String> usedCodes = new ArrayList<>();


    /**
     * Generates a unique 7 digit group code.
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
            return groupCode.toString();
        }
    }


    /**
     * Creates a new group.
     * @param groupName The name of the group.
     * @return The created group with the 7 digit group code assigned to the group.
     */
    public static Group createNewGroup(String groupName) {
        String groupCode = generateGroupCode();
        return new Group(groupName, groupCode);
    }
}
