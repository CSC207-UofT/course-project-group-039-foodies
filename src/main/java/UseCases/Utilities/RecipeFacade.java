package main.java.UseCases.Utilities;

import main.java.Entities.Recipe;

/**
 * A Facade for the methods in Recipe to maintain clean architecture
 */
public class RecipeFacade {
    /**
     * Adds a rating to a Recipe
     * @param recipe The Recipe
     * @param rating The rating to add
     */
    public static void addRating(Recipe recipe, double rating) {
        recipe.addRating(rating);
    }

    /**
     * A getter for a Recipe's name
     * @param recipe The Recipe
     * @return The name of the Recipe
     */
    public static String getName(Recipe recipe) {
        return recipe.getName();
    }
}
