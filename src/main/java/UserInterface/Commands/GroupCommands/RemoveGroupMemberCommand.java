package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.Gateways.GroupCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;


public class RemoveGroupMemberCommand extends Command {
    public RemoveGroupMemberCommand()  {
        super("remove group member", "Removes a new group member");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupCode = UI.queryUser("Input your 7 digit Group Code");
        if (!GroupCSVReader.getInstance().isGroup(groupCode)) {
            UI.displayMessage("The Group Code does not exist. Please try again.");
        } else {
            String username = UI.queryUser("Input the username of a new member to be removed");
            if (!GroupCSVReader.getInstance().containsMember(groupCode, username)) {
                UI.displayMessage("The username does not exist. Please try again.");
            } else {
                GroupCSVReader.getInstance().removeMember(groupCode, username);
                UI.displayMessage("The user has been removed from the group");
            }
        }
    }
}