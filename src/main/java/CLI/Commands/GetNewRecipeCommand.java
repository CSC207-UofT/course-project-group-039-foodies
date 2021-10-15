package main.java.CLI.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.Entities.Recipe;
import main.java.Gateways.RecipeGateway;

/**
 * Allows the user to view a new recipe to rate
 */
public class GetNewRecipeCommand extends Command {
    public GetNewRecipeCommand() {
        super("get new recipe", "Gets a new recipe to rate");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        RecipeGateway recipeGateway = new RecipeGateway(
                new Object[0][0],
                CLI.getRecipeDatabase()
        );
        Recipe newRecipe = recipeGateway.getNewRecipe();
        CLI.displayMessage(newRecipe.toString());
    }
}
