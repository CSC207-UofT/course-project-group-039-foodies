package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;

public class AddToRecipeBookCommand extends Command {

    public AddToRecipeBookCommand() {
        super("Add to recipe book", "Adds a viewed recipe to your recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the recipe you want to add");
        String recipeName = CLI.getTextInput();

        Recipe recipe = CLI.getRecipeCollection().findRecipe(recipeName);
        if (recipe == null) {
            CLI.displayMessage("This recipe does not exist");
        } else {
            RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
//            recipeBookManager.addRecipe(recipe);
            CLI.displayMessage("Input the name of the subrecipe book you would like to add recipe to");
            String subrecipebookname = CLI.getTextInput();
            SubRecipeBook subrecipebook = recipeBookManager.findsubrecipebook(subrecipebookname);
            recipeBookManager.addRecipe(subrecipebook, recipe);
//            SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
//                    recipeBookManager.findsubrecipebook(subrecipebookname));
//            subRecipeBookManager.addRecipe(recipe);
            CLI.displayMessage("Recipe added successfully");
        }
    }
}
