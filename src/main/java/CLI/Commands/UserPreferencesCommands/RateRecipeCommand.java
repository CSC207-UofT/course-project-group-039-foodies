package main.java.CLI.Commands.UserPreferencesCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Gateways.PreferenceBookCSVReader;
import main.java.Gateways.RecipeCSVReader;
import main.java.UseCases.RecipeBookManager;

/**
 * Allows the user to rate a recipe
 */
public class RateRecipeCommand extends Command {
    public RateRecipeCommand() {
        super("rate recipe", "Rates a recipe");
    }
    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the recipe to rate");
        String recipeName = CLI.getTextInput();
        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        CLI.buildPreferences(PreferenceBookCSVReader.getInstance().getPreferenceBook(CLI.getUser().getUsername()));

        if (recipeBookManager.containsRecipe(recipeName) && !(CLI.getPreferenceBook().contains("rating",
                recipeName))) {
            CLI.displayMessage("Enter rating from 1-5");
            double rating = Double.parseDouble(CLI.getTextInput());
            Recipe recipe = CLI.getRecipeCollection().findRecipe(recipeName); //getting recipe from RecipeCollection
            recipe.addRating(rating); //recipe object is updated
            RecipeCSVReader.getInstance().addRating(recipeName, recipe.rating, recipe.ratingCount); //csv is updated
            PreferenceBookCSVReader.getInstance().updateRatings(CLI.getUser().getUsername(), "add",
                    recipeName, rating);
            CLI.displayMessage("Recipe successfully rated");
        } else if (CLI.getPreferenceBook().contains("rating",
                recipeName)) {
            CLI.displayMessage("You have already rated this recipe");
        } else {
            CLI.displayMessage("Recipe book does not contain " + recipeName);
        }
    }
}
