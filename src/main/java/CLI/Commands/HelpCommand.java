package main.java.CLI.Commands;

import main.java.CLI.CommandLineInterface;

/**
 * Allows the user to find which commands can be called
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "Displays the list of available commands");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("The following commands can be called:");
        for (Command command : CLI.getPageManager().getAvailableCommands()) {
            CLI.displayMessage(String.format("\"%s\" - %s%n", command.getName(), command.getDescription()));
        }
    }
}
