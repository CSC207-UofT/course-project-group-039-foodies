package main.java.UseCases;
import java.util.ArrayList;

public class GroupFactory{
  
  private static ArrayList<String> usedCodes;
  
  /**
   * Generates a unique 7 digit group code and assign the code to the group.
   * @param group - the name of the group
   */
  public static String generateGroupCode(Group group) {
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
}
