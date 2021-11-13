package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Gateways.RecipeCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to rate a recipe
 */
public class RateRecipeCommand extends Command {
    public RateRecipeCommand() {
        super("rate recipe", "Rates a recipe");
    }
    @Override
    public void runAction(UserInterface UI) {
        String recipeName = UI.queryUser("Enter the name of the recipe to rate");
        RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());

        if (recipeBookManager.containsRecipe(recipeName)) {
            int rating = Integer.parseInt(UI.queryUser("Enter rating from 1-5"));
            Recipe recipe = UI.getRecipeCollection().findRecipe(recipeName); // getting recipe from RecipeCollection
            recipe.addRating(rating); // recipe object is updated
            RecipeCSVReader.getInstance().addRating(recipeName, recipe.rating, recipe.ratingCount); // csv is updated
            UI.displayMessage("Recipe successfully rated");
        } else {
            UI.displayMessage("Recipe not in recipe book");
        }
    }
}
