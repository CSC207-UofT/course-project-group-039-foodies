package main.java.CLI.Commands.RecipeBookCommands;
import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;

/**
 * Allows the user to list all recipes in the recipe book
 */
public class ListRecipeBookCommand extends Command {
    public ListRecipeBookCommand() {
        super("list recipes", "Lists all recipes in the recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        for (Recipe recipe : recipeBookManager.getRecipes()) {
            CLI.displayMessage(recipe.toString());
        }
    }
}
