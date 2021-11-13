package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to update their preferences
 */
public class UpdatePreferencesCommand extends Command {
    public UpdatePreferencesCommand() {
        super("update preferences", "Starts a questionnaire to update user preferences");
    }

    @Override
    public void runAction(UserInterface UI) {

    }
}

