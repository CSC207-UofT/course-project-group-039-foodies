package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.SubRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;


/**
 * Allows the user to remove a recipe
 */
public class RemoveRecipeCommand extends Command {
    public RemoveRecipeCommand() {
        super("remove recipe", "Removes a recipe from the sub recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String recipeName = UI.queryUser("Input the name of the recipe to remove");
        String subRecipeBookName = UI.queryUser("Please confirm the name of SubRecipeBook to remove the recipe from");

        RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
        SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
                recipeBookManager.findsubrecipebook(subRecipeBookName));
        if (subRecipeBookManager.containsRecipe(recipeName)) {
            recipeBookManager.removeRecipe(subRecipeBookName,recipeName);
            RecipeBookCSVReader.getInstance().updateRecipeBookCSV(UI.getUser(),
                    recipeBookManager.findsubrecipebook(subRecipeBookName));
            UI.displayMessage("Recipe successfully deleted");
        } else {
            UI.displayMessage("Recipe not found in recipe book.");
        }
    }
}

