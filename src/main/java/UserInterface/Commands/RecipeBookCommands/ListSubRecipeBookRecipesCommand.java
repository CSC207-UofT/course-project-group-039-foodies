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
        super("show recipes in subrecipebook", "Lists the recipes of the SubRecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Please confirm the recipe book you would like to see recipes for");
//        RecipeBook recipebook = UI.getUser().getRecipeBook();
        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(UI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
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