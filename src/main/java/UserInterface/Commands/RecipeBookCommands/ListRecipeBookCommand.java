package main.java.UserInterface.Commands.RecipeBookCommands;
import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to list all recipes in the recipe book
 */
public class ListRecipeBookCommand extends Command {
    public ListRecipeBookCommand() {
        super("list recipes", "Lists all recipes in the recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
        for (Recipe recipe : recipeBookManager.getRecipes()) {
            UI.displayMessage(recipe.toString());
        }
    }
}
