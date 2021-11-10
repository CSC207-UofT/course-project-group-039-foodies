package main.java.CLI.Commands.GroupCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Group;
import main.java.UseCases.Utilities.GroupManager;
import main.java.UseCases.GroupFactory;
import main.java.UseCases.Utilities.UserManager;


public class CreateGroupCommand extends Command {
    public CreateGroupCommand()  {
        super("create group", "Creates a new group");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {

        CLI.displayMessage("Input your username");
        String username = CLI.getTextInput();

        if (!UserManager.containsUser(username)) {
            CLI.displayMessage("The username does not exist. Please create a new account first.");
        } else {
            CLI.displayMessage("Input your Group Name");
            String groupName = CLI.getTextInput();
            Group createdGroup = GroupFactory.createNewGroup(groupName);
            if (!GroupManager.addGroup(createdGroup)) {
                CLI.displayMessage("The group cannot be created; the group already exists");
            } else {
                GroupManager.addMember(createdGroup.getGroupCode(), username);
                String groupCode = createdGroup.getGroupCode();
                CLI.displayMessage("The group has been created\nYour group code is " + groupCode);
            }
        }
    }
}
