package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Entities.Group;
import main.java.UseCases.GroupFactory;
import main.java.Gateways.GroupCSVReader;


public class CreateGroupCommand extends Command {
    public CreateGroupCommand()  {
        super("create group", "Creates a new group");
    }

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.getUser().getUsername();
        String groupName = UI.queryUser("Input your group name");
        Group createdGroup = GroupFactory.createNewGroup(groupName);

        if (!GroupCSVReader.getInstance().saveGroup(createdGroup)) {
            UI.displayMessage("The group cannot be created; the group already exists");
        } else {
            String groupCode = createdGroup.getGroupCode();
            GroupCSVReader.getInstance().addMember(groupCode, username);
            UI.displayMessage("The group has been created\nYour group code is " + groupCode);
        }
    }
}
