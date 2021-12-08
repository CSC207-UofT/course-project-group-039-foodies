package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupCSVReader;

public class RemoveGroupMemberCommand extends Command {
    public RemoveGroupMemberCommand()  {
        super("remove group member", "Removes a group member");
    }

    @Override
    public void runAction(UserInterface UI) {
        String user = UI.getUser().getUsername();
        String joinedGroups = GroupCSVReader.getInstance().getJoinedGroups(user);

        String groupCode = UI.queryUser("Your groups are :\n" + joinedGroups
                + "Input your 7 digit Group Code");
        if (!GroupCSVReader.getInstance().isGroup(groupCode)) {
            UI.displayMessage("The Group Code does not exist. Please try again.");
        } else {
            String username = UI.queryUser("Input the username of a member to be removed");
            if (!GroupCSVReader.getInstance().containsMember(groupCode, username)) {
                UI.displayMessage("The username does not exist. Please try again.");
            } else {
                GroupCSVReader.getInstance().removeMember(groupCode, username);
                UI.displayMessage("The user has been removed from the group");
            }
        }
    }
}
