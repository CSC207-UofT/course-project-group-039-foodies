package main.java.CLI.Commands.GroupCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.UseCases.Utilities.GroupManager;

public class ViewGroupsCommand extends Command {
    public ViewGroupsCommand() {super("enter group viewer",
            "Enters the group viewer"); }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input your username");
        String username = CLI.getTextInput();
        CLI.displayMessage(GroupManager.getJoinedGroups(username));
    }
}
