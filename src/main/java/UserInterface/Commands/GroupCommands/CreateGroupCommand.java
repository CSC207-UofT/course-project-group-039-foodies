package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Group;
import main.java.UseCases.Utilities.GroupManager;
import main.java.UseCases.GroupFactory;
import main.java.Gateways.UserCSVReader;
import main.java.UserInterface.UserInterface;


public class CreateGroupCommand extends Command {
    public CreateGroupCommand()  {
        super("create group", "Creates a new group");
    }

    @Override
    public void runAction(UserInterface UI) {

        String username = UI.getUser().getUsername();

        String groupName = UI.queryUser("Input your Group Name");
        Group createdGroup = GroupFactory.createNewGroup(groupName);
        if (!GroupManager.addGroup(createdGroup)) {
            UI.displayMessage("The group cannot be created; the group already exists");
        } else {
            GroupManager.addMember(createdGroup.getGroupCode(), username);
            String groupCode = createdGroup.getGroupCode();
            UI.displayMessage("The group has been created\nYour group code is " + groupCode);
        }
    }
}
