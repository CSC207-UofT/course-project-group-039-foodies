package main.java.CLI.Commands.RecipeBookCommands;
import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;

/**
 * List the recipes found in subrecipebook
 */
public class ListSubRecipeBookRecipesCommand extends Command {

    public ListSubRecipeBookRecipesCommand() {
        super("Show Recipes in SubRecipeBook", "Lists the recipes of the SubRecipeBook");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        RecipeBookManager recipebookmanager = new RecipeBookManager(CLI.getUser());
        CLI.displayMessage("Please confirm the recipe book you would like to see recipes for");
        String subrecipebookname = CLI.getTextInput();
        SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
                recipebookmanager.findsubrecipebook(subrecipebookname));
        for (Recipe recipe : subRecipeBookManager.getRecipes()) {
            CLI.displayMessage(recipe.toString());
        }
    }
}
