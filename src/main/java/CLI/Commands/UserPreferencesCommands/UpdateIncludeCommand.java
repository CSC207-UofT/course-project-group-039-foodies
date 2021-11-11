package main.java.CLI.Commands.UserPreferencesCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.PreferenceBook;
// possible usecase import

/**
 * allows user to update the list of ingredients they want to include in their recommended recipes.
 */
public class UpdateIncludeCommand extends Command {
    public UpdateIncludeCommand() {
        super("update omitted ingredients", "Removes or adds ingredients to omit list");
    }
    @Override
    public void runAction(CommandLineInterface CLI) {

    }
}