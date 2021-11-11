package main.java.CLI.Commands.UserPreferencesCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;

/**
 * Allows the user to update their groups
 */
public class UpdatePreferencesCommand extends Command {
    public UpdatePreferencesCommand() {
        super("update groups", "Starts a questionnaire to update user groups");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {

    }
}

