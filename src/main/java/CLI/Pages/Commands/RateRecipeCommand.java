package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Command;
import main.java.RecipeManager;

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
        if (RecipeManager.isRecipe(recipeName)) {
            CLI.displayMessage("Enter rating from 1-5");
            int rating = Integer.parseInt(CLI.getTextInput());
            RecipeManager.rateRecipe(CLI.getUser(), recipeName, rating);
        } else {
            CLI.displayMessage("Recipe not found");
        }
    }
}
