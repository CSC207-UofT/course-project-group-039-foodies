package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;
import main.java.Entities.RecipeBook;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to list all recipes in the recipe book
 */
public class ListRecipeBookCommand extends Command {
    public ListRecipeBookCommand() {
        super("list all recipes", "Lists all recipes in the recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        RecipeBook recipebook = UI.getUser().getRecipeBook();
        RecipeBookManager recipeBookManager = new RecipeBookManager(recipebook);
        if (recipeBookManager.getRecipes().length == 0) {
            UI.displayMessage("Your recipe book is empty.");
        } else {
            for (Recipe recipe : recipeBookManager.getRecipes()) {
                UI.displayMessage(recipe.toString());
            }
        }
    }
}