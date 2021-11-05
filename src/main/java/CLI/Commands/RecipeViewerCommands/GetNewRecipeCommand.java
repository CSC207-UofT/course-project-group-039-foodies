package main.java.CLI.Commands.RecipeViewerCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;

import java.util.Iterator;

/**
 * Allows the user to view a new recipe to rate
 */
public class GetNewRecipeCommand extends Command {
    private Iterator<Recipe> recipeIterator; // Uses the lazy loading design pattern to be instantiated
    private boolean isIteratorSet = false;

    public GetNewRecipeCommand() {
        super("get new recipe", "Gets a new recipe to rate");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        // If the iterator hasn't been set yet, or we have already iterated over all elements
        if (!isIteratorSet || !recipeIterator.hasNext()) {
            isIteratorSet = true;
            recipeIterator = CLI.getRecipeCollection().iterator();
        }

        if (recipeIterator.hasNext()) {
            CLI.displayMessage(recipeIterator.next().toString());
        }
    }
}
