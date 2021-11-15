package main.java.UserInterface.Commands.RecipeViewerCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UserInterface.UserInterface;

import java.util.Iterator;

/**
 * Allows the user to view a new recipe to rate
 */
public class GetNewRecipeCommand extends Command {
    private static Iterator<Recipe> recipeIterator; // Uses the lazy loading design pattern to be instantiated
    private static boolean isIteratorSet = false;

    public GetNewRecipeCommand() {
        super("get new recipe", "Gets a new recipe to rate");
    }

    @Override
    public void runAction(UserInterface UI) {
        // If the iterator hasn't been set yet, or we have already iterated over all elements
        if (!isIteratorSet || !recipeIterator.hasNext()) {
            isIteratorSet = true;
            recipeIterator = UI.getRecipeCollection().iterator();
        }

        if (recipeIterator.hasNext()) {
            UI.displayMessage(recipeIterator.next().toString());
        }
    }
}
