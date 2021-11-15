package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;

/**
 * Allows the user to remove a recipe
 */
public class RemoveRecipeCommand extends Command {
    public RemoveRecipeCommand() {
        super("remove recipe", "Removes a recipe from the sub recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input the name of the recipe to remove");
        String recipename = CLI.getTextInput();
        CLI.displayMessage("Please confirm the name of SubRecipeBook to remove the recipe from");
        String subrecipebookname = CLI.getTextInput();

        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(CLI.getUser());
        RecipeBookManager recipeBookManager = new RecipeBookManager(recipebook);
        SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
                recipeBookManager.findsubrecipebook(subrecipebookname));
        if (subRecipeBookManager.containsRecipe(recipename)) {
            recipeBookManager.removeRecipe(subrecipebookname,recipename);
            RecipeBookCSVReader.getInstance().updateRecipeBookCSV(CLI.getUser(),
                    recipeBookManager.findsubrecipebook(subrecipebookname));
            CLI.displayMessage("Recipe successfully deleted");
        } else {
            CLI.displayMessage("Recipe not found in recipe book.");
        }
    }
}
