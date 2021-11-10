package main.java.CLI.Commands.GroupCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.CLI.Commands.HelpCommand;

public class EnterManageGroupCommand extends Command {
    public EnterManageGroupCommand() {
        super("manage groups", "Manage your groups");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().manageGroup();
        Command help = new HelpCommand();
        help.runAction(CLI);
    }
}
