package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Command;
import main.java.Entities.Recipe;
import main.java.Gateways.RecipeGateway;
import main.java.Utilities.RecipeBookManager;

/**
 * Allows the user to view a new recipe to rate
 */
public class GetNewRecipeCommand extends Command {
    public GetNewRecipeCommand() {
        super("get new recipe", "Gets a new recipe to rate");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        RecipeGateway recipeGateway = new RecipeGateway(new Object[0][0]);
        Recipe newRecipe = recipeGateway.getNewRecipe();
        CLI.displayMessage(RecipeBookManager.recipeToString(newRecipe));
    }
}
