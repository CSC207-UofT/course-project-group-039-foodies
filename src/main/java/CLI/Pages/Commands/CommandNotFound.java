package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Command;

/**
 * The default command returned when a command is not found
 */
public class CommandNotFound extends Command {
    public CommandNotFound() {
        super("command not found", "This is the default command not found command");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("The inputted command is not found. Input \"help\" to see" +
                " a list of available commands");
    }
}

