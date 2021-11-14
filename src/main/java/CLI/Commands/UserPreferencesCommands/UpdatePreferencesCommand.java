package main.java.CLI.Commands.UserPreferencesCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.CLI.Commands.HelpCommand;

/**
 * Allows the user to update their preferences
 */
public class UpdatePreferencesCommand extends Command {
    public UpdatePreferencesCommand() {
        super("update preferences", "Starts a questionnaire to update user preferences");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().setUpdatePreferences();
        Command help = new HelpCommand();
        help.runAction(CLI);
    }
}

