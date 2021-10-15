package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.Utilities.RecipeBookManager;

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
        if (RecipeBookManager.containsRecipe(CLI.getUser(), recipe)) {
            RecipeBookManager.removeRecipe(CLI.getUser(), recipe);
        } else {
            CLI.displayMessage("Recipe not found in recipe book.");
        }
    }
}
