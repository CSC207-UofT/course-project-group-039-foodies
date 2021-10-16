package main.java.CLI.Commands.RecipeViewerCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Gateways.RecipeGateway;

import java.util.ArrayList;

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
                CLI.getRecipeDatabase()
        );

        recipeGateway.BuildRecipe();

        CLI.displayMessage(CLI.getRecipeDatabase().getNextRecipe().toString());
    }
}
