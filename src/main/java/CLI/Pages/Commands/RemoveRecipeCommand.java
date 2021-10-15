package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.UseCases.RecipeBookManager;

/**
 * Allows the user to remove a recipe
 */
public class RemoveRecipeCommand extends Command {
    public RemoveRecipeCommand() {
        super("remove recipe", "Removes a recipe from the recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input the name of the recipe to remove");
        String recipe = CLI.getTextInput();
        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        if (recipeBookManager.containsRecipe(recipe)) {
            recipeBookManager.removeRecipe(recipe);
            CLI.displayMessage("Recipe successfully deleted");
        } else {
            CLI.displayMessage("Recipe not found in recipe book.");
        }
    }
}
