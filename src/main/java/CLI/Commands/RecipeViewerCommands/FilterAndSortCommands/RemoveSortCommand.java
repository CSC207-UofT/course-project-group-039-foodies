package main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;

public class RemoveSortCommand extends Command {

    public RemoveSortCommand() {
        super("remove sort", "Stops the recipe book from being sorted");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getRecipeCollection().removeSort();
    }
}
