package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;

public class AddToRecipeBookCommand extends Command {

    public AddToRecipeBookCommand() {
        super("add to recipe book", "Adds a viewed recipe to your recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String recipeName = UI.queryUser("Enter the name of the recipe you want to add");

        Recipe recipe = UI.getRecipeCollection().findRecipe(recipeName);
        if (recipe == null) {
            UI.displayMessage("This recipe does not exist");
        } else {
            RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
            recipeBookManager.addRecipe(recipe);
            UI.displayMessage("Recipe added successfully");
        }
    }
}
