package main.java.UserInterface.Commands.RecipeViewerCommands;

import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UserInterface.UserInterface;

import java.util.Iterator;

/**
 * Allows the user to view a new group recipe to rate
 */
public class GetNewGroupRecipeCommand extends Command{
    private static Iterator<Recipe> groupRecipeIterator; // Uses the lazy loading design pattern to be instantiated
    private static boolean isIteratorSet = false;

    public GetNewGroupRecipeCommand() {
        super("get new group recipe", "Gets a new group recipe to rate");
    }

    @Override
    public void runAction(UserInterface UI) {
        // If the iterator hasn't been set yet, or we have already iterated over all elements
        if (!isIteratorSet || !groupRecipeIterator.hasNext()) {
            initializeIterator(UI);
        }

        if (groupRecipeIterator.hasNext()) {
            UI.displayMessage(groupRecipeIterator.next().toString());
        }
    }

    /**
     * Sets the iterator of Recipes to go through,
     * by taking the current RecipeCollection stored in the UI
     * @param UI The userInterface being used
     */
    public static void initializeIterator(UserInterface UI) {
        isIteratorSet = true;
        groupRecipeIterator = RecipeCollectionFacade.getIterator(UI.getRecipeCollection());
    }
}
