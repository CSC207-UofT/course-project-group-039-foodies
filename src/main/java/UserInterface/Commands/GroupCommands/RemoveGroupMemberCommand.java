package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UseCases.Utilities.GroupManager;
import main.java.UserInterface.UserInterface;


public class RemoveGroupMemberCommand extends Command {
    public RemoveGroupMemberCommand()  {
        super("remove group member", "Removes a new group member");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupCode = UI.queryUser("Input your 7 digit Group Code");
        if (!GroupManager.containsGroup(groupCode)) {
            UI.displayMessage("The Group Code does not exist. Please try again.");
        } else {
            String username = UI.queryUser("Input the username of a new member to be removed");
            if (!GroupManager.removeMember(groupCode, username)) {
                UI.displayMessage("The username does not exist. Please try again.");
            } else {
                GroupManager.removeMember(groupCode, username);
                UI.displayMessage("The user has been removed from the group");
            }
        }
    }
}
