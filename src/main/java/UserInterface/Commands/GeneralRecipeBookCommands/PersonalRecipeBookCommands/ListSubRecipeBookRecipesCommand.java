package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;


/**
 * List the recipes found in subrecipebook
 */
public class ListSubRecipeBookRecipesCommand extends Command {

    public ListSubRecipeBookRecipesCommand() {
        super("show recipes in subrecipebook", "Lists the recipes of the SubRecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Please confirm the recipe book you would like to see recipes for");
        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());
        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
                recipebookmanager.findsubrecipebook(subRecipeBookName));
            for (Recipe recipe : subRecipeBookManager.getRecipes()) {
                UI.displayMessage(recipe.toString());
            }
        } else {
            UI.displayMessage("The subrecipebook that you requested does not exist");
        }
    }
}
