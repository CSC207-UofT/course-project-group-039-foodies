package main.java.UserInterface.Commands.GroupCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to enter manage group page.
 */
public class EnterManageGroupCommand extends Command {
    public EnterManageGroupCommand() {
        super("manage groups", "Manages your groups");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().manageGroup();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
