package main.java.UserInterface.Commands;

import main.java.UserInterface.UserInterface;

/**
 * Allows the user to quit the program
 */
public class QuitCommand extends Command {
    public QuitCommand() {
        super("quit", "Quits the program");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.isRunning = false;
    }
}
