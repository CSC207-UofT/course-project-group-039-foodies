package main.java.UseCases.Utilities;

import main.java.Entities.Recipe;

import java.util.ArrayList;

/**
 * A Facade for the methods in Recipe to maintain clean architecture
 */
public class RecipeFacade {
    public static String toString(Recipe recipe) {
        return recipe.toString();
    }

    public static void addRating(Recipe recipe, double rating) {
        recipe.addRating(rating);
    }

    public static String getInstructions(Recipe recipe) {
        return recipe.getInstructions();
    }

    public static double getRating(Recipe recipe) {
        return recipe.getRating();
    }

    public static String getFoodType(Recipe recipe) {
        return recipe.getFoodType();
    }

    public static String getName(Recipe recipe) {
        return recipe.getName();
    }

    public static int getServings(Recipe recipe) {
        return recipe.getServings();
    }

    public static ArrayList<String> getIngredients(Recipe recipe) {
        return recipe.getIngredients();
    }

    public static Integer getRecipeCode(Recipe recipe) {
        return recipe.getRecipeCode();
    }
}
