package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to view all their saved recipes
 */
public class ViewAllGroupRecipesCommand extends Command {

    public ViewAllGroupRecipesCommand() {
        super("show all recipes", "Lists the recipes of the SubRecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());
        for (Recipe recipe: recipebookmanager.getRecipes()) {
            UI.displayMessage(recipe.toString());
        }
    }
}