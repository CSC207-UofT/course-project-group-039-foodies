package main.java.UserInterface.Commands;

import main.java.UserInterface.UserInterface;

/**
 * The default command returned when a command is not found
 */
public class CommandNotFound extends Command {
    public CommandNotFound() {
        super("command not found", "This is the default command not found command");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.displayMessage("The inputted command is not found. Input \"help\" to see" +
                " a list of available commands");
    }
}

