package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Entities.Group;
import main.java.UseCases.GroupFactory;
import main.java.Gateways.GroupCSVReader;


public class DeleteGroupCommand extends Command {
    public DeleteGroupCommand()  {
        super("delete group", "Deletes a group");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupName = UI.queryUser("Input the group name to be removed");

        String username = UI.getUser().getUsername();
        String groupCode =
                GroupCSVReader.getInstance().getGroup(groupName, username).getGroupCode();

        GroupCSVReader.getInstance().removeGroup(groupCode);
        UI.displayMessage("The group " + groupName + " has been removed");
    }
}
