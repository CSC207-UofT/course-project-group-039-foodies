package main.java.CLI.Pages.Commands;


import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Command;

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
        for (Command command : CLI.getCurrentCommands()) {
            CLI.displayMessage(String.format("\"%s\" - %s%n", command.getName(), command.getDescription()));
        }
    }
}
