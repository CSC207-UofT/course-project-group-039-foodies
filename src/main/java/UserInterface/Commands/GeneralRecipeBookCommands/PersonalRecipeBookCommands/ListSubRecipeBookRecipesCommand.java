package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * List the recipes found in subrecipebook
 */
public class ListSubRecipeBookRecipesCommand extends Command {

    public ListSubRecipeBookRecipesCommand() {
        super("show recipes", "Lists the recipes of the SubRecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Please confirm the recipe book you would like to see recipes for");
        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());
        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
                recipebookmanager.findSubRecipeBook(subRecipeBookName));
            if (subRecipeBookManager.getRecipes().length == 0) {
                UI.displayMessage("There are no recipes in the recipe book requested");
            }
            for (Recipe recipe : subRecipeBookManager.getRecipes()) {
                UI.displayMessage(recipe.toString());
            }
        } else {
            UI.displayMessage("The sub recipe book that you requested does not exist");
        }
    }
}
