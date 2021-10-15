package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Command;

/**
 * Allows the user to view a new recipe
 */
public class GetNewRecipeCommand extends Command {
    public GetNewRecipeCommand() {
        super("get new recipe", "Gets a new recipe to rate");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {

    }
}
