package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Entities.Group;
import main.java.UseCases.GroupFactory;
import main.java.Gateways.GroupCSVReader;

import java.util.ArrayList;


public class CreateGroupCommand extends Command {
    public CreateGroupCommand()  {
        super("create group", "Creates a new group");
    }

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.getUser().getUsername();
        String groupName = UI.queryUser("Input your group name");
        ArrayList<String> groupMembers = new ArrayList<>();

        Group createdGroup = GroupFactory.createNewGroup(groupName);
        String groupCode = createdGroup.getGroupCode();

        GroupCSVReader.getInstance().saveGroup(groupCode, groupName, groupMembers);
        GroupCSVReader.getInstance().addMember(groupCode, username);
        UI.displayMessage("The group has been created\nYour group code is " + groupCode);
    }
}
