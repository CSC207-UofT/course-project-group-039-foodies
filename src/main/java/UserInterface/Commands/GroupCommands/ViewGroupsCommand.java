package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UseCases.Utilities.GroupManager;
import main.java.UserInterface.UserInterface;


public class ViewGroupsCommand extends Command {
    public ViewGroupsCommand()  {super("view joined groups",
                "Displays all the groups that you've joined");}

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.queryUser("Input your username");
        String joinedGroups = GroupManager.getJoinedGroups(username);
        UI.displayMessage(joinedGroups);
    }
}
