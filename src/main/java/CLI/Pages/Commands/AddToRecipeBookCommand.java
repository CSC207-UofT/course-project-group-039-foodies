package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;

public class AddToRecipeBookCommand extends Command {

    public AddToRecipeBookCommand() {
        super("add to recipe book", "Adds a viewed recipe to your recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the recipe you want to add");
        String recipeName = CLI.getTextInput();

        Recipe recipe = CLI.getRecipeDatabase().findRecipe(recipeName);
        if (recipe == null) {
            CLI.displayMessage("This recipe does not exist");
        } else {
            RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
            recipeBookManager.addRecipe(recipe);
            CLI.displayMessage("Recipe added successfully");
        }
    }
}
