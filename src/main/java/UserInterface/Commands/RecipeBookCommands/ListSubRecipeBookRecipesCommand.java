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
 * List the recipes found in subrecipebook
 */
public class ListSubRecipeBookRecipesCommand extends Command {

    public ListSubRecipeBookRecipesCommand() {
        super("show recipes in subrecipebook", "Lists the recipes of the SubRecipeBook");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Please confirm the recipe book you would like to see recipes for");
        String subrecipebookname = CLI.getTextInput();
        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(CLI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        if (recipebookmanager.containsSubRecipeBook(subrecipebookname)) {
            SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
                recipebookmanager.findsubrecipebook(subrecipebookname));
            for (Recipe recipe : subRecipeBookManager.getRecipes()) {
                CLI.displayMessage(recipe.toString());
            }
        } else {
            CLI.displayMessage("The subrecipebook that you requested does not exist");
        }
    }
}
