package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Entities.Recipe;
import main.java.Gateways.PreferenceBookCSVReader;
import main.java.Gateways.RecipeCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
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
        UI.buildPreferences(PreferenceBookCSVReader.getInstance().getPreferenceBook(UI.getUser().getUsername()));

        if (recipeBookManager.containsRecipe(recipeName) && !(UI.getPreferenceBook().contains("rating",
                recipeName))) {
            double rating = Double.parseDouble(UI.queryUser("Enter rating from 1-5"));
            Recipe recipe = UI.getRecipeCollection().findRecipe(recipeName); //getting recipe from RecipeCollection
            recipe.addRating(rating); //recipe object is updated
            RecipeCSVReader.getInstance().addRating(recipeName, recipe.rating, recipe.ratingCount); //csv is updated
            PreferenceBookCSVReader.getInstance().updateRatings(UI.getUser().getUsername(), "add",
                    recipeName, rating);
            UI.displayMessage("Recipe successfully rated");
        } else if (UI.getPreferenceBook().contains("rating",
                recipeName)) {
            UI.displayMessage("You have already rated this recipe");
        } else {
            UI.displayMessage("Recipe book does not contain " + recipeName);
        }
    }
}