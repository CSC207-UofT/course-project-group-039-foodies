package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;

/** Allows the user to find the highest rated recipe
 */
public class ViewHighestRatedRecipesCommand extends Command {
    public ViewHighestRatedRecipesCommand() {
        super("view highest rated recipes", "Displays a list of the most popular recipes");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {

    }
}
