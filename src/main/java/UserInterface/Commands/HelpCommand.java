package main.java.UserInterface.Commands;

import main.java.UserInterface.UserInterface;

/**
 * Allows the user to find which commands can be called
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "Displays the list of available commands");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.displayMessage("The following commands can be called:");
        for (Command command : UI.getPageManager().getAvailableCommands()) {
            UI.displayMessage(String.format("\"%s\" - %s%n", command.getName(), command.getDescription()));
        }
    }
}
