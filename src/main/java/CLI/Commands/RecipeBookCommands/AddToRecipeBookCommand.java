package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;

public class AddToRecipeBookCommand extends Command {

    public AddToRecipeBookCommand() {
        super("add to subrecipebook", "Adds a viewed recipe to your recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the recipe you want to add");
        String recipeName = CLI.getTextInput();

        Recipe recipe = CLI.getRecipeCollection().findRecipe(recipeName);
        if (recipe == null) {
            CLI.displayMessage("This recipe does not exist");
        } else {
            RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(CLI.getUser());
            RecipeBookManager recipeBookManager = new RecipeBookManager(recipebook);
//            recipeBookManager.addRecipe(recipe);
            CLI.displayMessage("Input the name of the subrecipe book you would like to add recipe to");
            String subrecipebookname = CLI.getTextInput();
            if (recipeBookManager.containsSubRecipeBook(subrecipebookname)) {
                SubRecipeBook subrecipebook = recipeBookManager.findsubrecipebook(subrecipebookname);
                recipeBookManager.addRecipe(subrecipebookname, recipe);
                RecipeBookCSVReader.getInstance().updateRecipeBookCSV(CLI.getUser(), subrecipebook);
                CLI.displayMessage("Recipe added successfully");
            }else {
                CLI.displayMessage("The subrecipebook you requested does not exist");
            }
        }
    }
}


//            SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(
//                    recipeBookManager.findsubrecipebook(subrecipebookname));
//            subRecipeBookManager.addRecipe(recipe);