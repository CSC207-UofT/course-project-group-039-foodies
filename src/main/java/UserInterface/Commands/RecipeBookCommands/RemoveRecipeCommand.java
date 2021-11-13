package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to remove a recipe
 */
public class RemoveRecipeCommand extends Command {
    public RemoveRecipeCommand() {
        super("remove recipe", "Removes a recipe from the recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String recipe = UI.queryUser("Input the name of the recipe to remove");
        RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
        if (recipeBookManager.containsRecipe(recipe)) {
            recipeBookManager.removeRecipe(recipe);
            UI.displayMessage("Recipe successfully deleted");
        } else {
            UI.displayMessage("Recipe not found in recipe book.");
        }
    }
}
