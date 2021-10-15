package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;

/**
 * Allows the user to quit the program
 */
public class QuitCommand extends Command {
    public QuitCommand() {
        super("quit", "Quits the program");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.isRunning = false;
    }
}
