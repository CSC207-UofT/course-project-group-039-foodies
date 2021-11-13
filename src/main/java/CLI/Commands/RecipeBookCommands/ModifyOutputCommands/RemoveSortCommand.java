package main.java.CLI.Commands.RecipeBookCommands.ModifyOutputCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;

public class RemoveSortCommand extends Command {

    public RemoveSortCommand() {
        super("remove sort", "Stops the recipe book from being filtered");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getRecipeCollection().removeSort();
    }
}
