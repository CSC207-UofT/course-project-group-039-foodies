package main.java.CLI.Commands.UserPreferencesCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.UseCases.RecipeBookManager;

/**
 * Allows the user to rate a recipe
 */
public class RateRecipeCommand extends Command {
    public RateRecipeCommand() {
        super("rate recipe", "Rates a recipe");
    }
    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the recipe to rate");
        String recipeName = CLI.getTextInput();
        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());

        if (CLI.getRecipeDatabase().containsRecipe(recipeName)) {
            CLI.displayMessage("Enter rating from 1-5");
            int rating = Integer.parseInt(CLI.getTextInput());
            recipeBookManager.rateRecipe(CLI.getUser(), recipeName, rating);
        } else {
            CLI.displayMessage("Recipe not found");
        }
    }
}