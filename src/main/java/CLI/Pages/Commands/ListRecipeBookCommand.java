package main.java.CLI.Pages.Commands;
import main.java.CLI.CommandLineInterface;
import main.java.Entities.Recipe;
import main.java.Utilities.RecipeBookManager;

/**
 * Allows the user to list all recipes in the recipe book
 */
public class ListRecipeBookCommand extends Command {
    public ListRecipeBookCommand() {
        super("list recipes", "Lists all recipes in the recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        for (Recipe recipe : RecipeBookManager.getRecipes(CLI.getUser())) {
            CLI.displayMessage(RecipeBookManager.recipeToString(recipe));
        }
    }
}
