package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Entities.Recipe;
import main.java.Gateways.PreferenceBookCSVReader;
import main.java.Gateways.RecipeCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
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

        if (recipeBookManager.containsRecipe(recipeName)
                && !(UI.getPreferenceBook().contains("rating", recipeName))) {
            rateRecipe(
                    UI,
                    recipeName,
                    Double.parseDouble(UI.queryUser("Enter rating from 1-5"))
            );

            UI.displayMessage("Recipe successfully rated");
        } else if (UI.getPreferenceBook().contains("rating", recipeName)) {
            UI.displayMessage("You have already rated this recipe");
        } else {
            UI.displayMessage("Recipe book does not contain " + recipeName);
        }
    }

    private void rateRecipe(UserInterface UI, String recipeName, double rating) {
        //getting recipe from RecipeCollection
        Recipe recipe = RecipeCollectionFacade.findRecipe(UI.getRecipeCollection(), recipeName);

        //recipe object is updated
        recipe.addRating(rating);

        //csv is updated
        RecipeCSVReader.getInstance().addRating(recipeName, recipe.rating, recipe.ratingCount);

        PreferenceBookCSVReader.getInstance().updateRatings(
                UI.getUser().getUsername(),
                true,
                recipeName,
                rating
        );
    }
}