package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupCSVReader;
import main.java.Gateways.UserCSVReader;

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
            if (!GroupCSVReader.getInstance().isGroup(groupCode)) {
                UI.displayMessage("The Group Code does not exist. Please try again.");
            } else {
                GroupCSVReader.getInstance().addMember(groupCode, username);
                UI.displayMessage("The user has been added to the group");
            }
        }
    }
}
