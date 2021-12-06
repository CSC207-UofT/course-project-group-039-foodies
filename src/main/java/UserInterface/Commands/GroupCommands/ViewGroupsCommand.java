package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupCSVReader;


public class ViewGroupsCommand extends Command {
    public ViewGroupsCommand()  {super("view my groups",
                "Displays all the groups that you've joined");}

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.getUser().getUsername();
        String joinedGroups = GroupCSVReader.getInstance().getJoinedGroups(username);
        UI.displayMessage(joinedGroups);
    }
}

