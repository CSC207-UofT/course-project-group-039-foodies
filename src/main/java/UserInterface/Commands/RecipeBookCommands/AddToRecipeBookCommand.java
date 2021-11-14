package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;

public class AddToRecipeBookCommand extends Command {

    public AddToRecipeBookCommand() {
        super("add to subrecipebook", "Adds a viewed recipe to your recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String recipeName = UI.queryUser("Enter the name of the recipe you want to add");

        Recipe recipe = UI.getRecipeCollection().findRecipe(recipeName);
        if (recipe == null) {
            UI.displayMessage("This recipe does not exist");
        } else {
            RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(UI.getUser());
            RecipeBookManager recipeBookManager = new RecipeBookManager(recipebook);
            String subRecipeBookName = UI.queryUser("Input the name of the subrecipe book you would like to add recipe to");
            if (recipeBookManager.containsSubRecipeBook(subRecipeBookName)) {
                SubRecipeBook subrecipebook = recipeBookManager.findsubrecipebook(subRecipeBookName);
                recipeBookManager.addRecipe(subRecipeBookName, recipe);
                RecipeBookCSVReader.getInstance().updateRecipeBookCSV(UI.getUser(), subrecipebook);
                UI.displayMessage("Recipe added successfully");
            }else {
                UI.displayMessage("The subrecipebook you requested does not exist");
            }
        }
    }
}

