package main.java.CLI.Commands.GroupCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.UseCases.Utilities.GroupManager;
import main.java.UseCases.Utilities.UserManager;

public class RemoveGroupMemberCommand extends Command {
    public RemoveGroupMemberCommand()  {
        super("remove group member", "Removes a new group member");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input the username of a new member to be removed");
        String username = CLI.getTextInput();

        if (!UserManager.containsUser(username)) {
            CLI.displayMessage("The username does not exist.");
        } else {
            CLI.displayMessage("Input your 7 digit Group Code");
            String groupCode = CLI.getTextInput();
            if (!GroupManager.containsGroup(groupCode)) {
                CLI.displayMessage("The Group Code does not exist. Please try again.");
            } else {
                GroupManager.addMember(groupCode, username);
                CLI.displayMessage("The user has been removed from the group");
            }
        }
    }
}
