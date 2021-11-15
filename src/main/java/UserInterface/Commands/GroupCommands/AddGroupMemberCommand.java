package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UseCases.Utilities.GroupManager;
import main.java.Gateways.UserCSVReader;
import main.java.UserInterface.UserInterface;


public class AddGroupMemberCommand extends Command {
    public AddGroupMemberCommand()  {
        super("add group member", "Adds a new group member");
    }

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.queryUser("Input the username of a new member to be added");

        if (!UserCSVReader.getInstance().isUser(username)) {
            UI.displayMessage("The username does not exist.");
        } else {
            String groupCode = UI.queryUser("Input your 7 digit Group Code");
            if (!GroupManager.containsGroup(groupCode)) {
                UI.displayMessage("The Group Code does not exist. Please try again.");
            } else {
                GroupManager.addMember(groupCode, username);
                UI.displayMessage("The user has been added to the group");
            }
        }
    }
}
