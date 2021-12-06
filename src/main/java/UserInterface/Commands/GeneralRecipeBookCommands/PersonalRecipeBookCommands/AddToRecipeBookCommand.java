package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;

public class AddToRecipeBookCommand extends Command {

    public AddToRecipeBookCommand() {
        super("add to sub recipe book", "Adds a viewed recipe to your recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String recipeName = UI.queryUser("Enter the name of the recipe you want to add");

        Recipe recipe = RecipeCollectionFacade.findRecipe(UI.getRecipeCollection(), recipeName);
        if (recipe == null) {
            UI.displayMessage("This recipe does not exist");
        } else {
            RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
            String subRecipeBookName = UI.queryUser("Input the name of the sub-recipe book you would like to add recipe to");
            if (recipeBookManager.containsSubRecipeBook(subRecipeBookName)) {
                SubRecipeBook subrecipebook = recipeBookManager.findSubRecipeBook(subRecipeBookName);
                recipeBookManager.addRecipe(subRecipeBookName, recipe);
                RecipeBookCSVReader.getInstance().updateRecipeBookCSV(UI.getUser(), subrecipebook);
                UI.displayMessage("Recipe added successfully");
            }else {
                UI.displayMessage("The sub-recipe book you requested does not exist");
            }
        }
    }
}

