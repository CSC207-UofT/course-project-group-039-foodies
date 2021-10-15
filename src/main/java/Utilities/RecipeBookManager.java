package main.java.Utilities;

import main.java.Entities.Recipe;
import main.java.Entities.User;

public class RecipeBookManager {
    /**
     * Return whether a recipe of a certain name is contained in a user's recipe book
     * @param user The user whose recipe book we are checking
     * @param recipeName The recipe name we are looking for
     * @return True if and only if the user contains the recipe
     */
    public static boolean containsRecipe(User user, String recipeName) {
        return containsRecipe(user, DatabaseManager.findRecipe(recipeName));
    }

    /**
     * Return whether a recipe object is contained in a user's recipe book
     * @param user The user whose recipe book we are checking
     * @param recipe The recipe name we are looking for
     * @return True if and only if the user contains the recipe
     */
    public static boolean containsRecipe(User user, Recipe recipe) {
        for (int code : user.getRecipeBook().getCodes()) {
            if (code == recipe.getRecipeCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of recipes in the user's recipe book
     * @param user The user whose recipe book we are checking
     * @return The array of recipes
     */
    public static Recipe[] getRecipes(User user) {
        return user.getRecipeBook().getRecipes();
    }

    /**
     * Convert a recipe object to its string representation
     * @param recipe The recipe object we are converting
     * @return The string representation
     */
    public static String recipeToString(Recipe recipe) {
        return recipe.toString();
    }

    /**
     * Remove a recipe of a certain name from a user's recipe book
     * @param user The user whose recipe book we are checking
     * @param recipeName The name of the recipe we are removing
     */
    public static void removeRecipe(User user, String recipeName) {
        Recipe recipe = DatabaseManager.findRecipe(recipeName);
        if (recipe != null) {
            removeRecipe(user, recipe);
        }
    }

    /**
     * Remove a recipe from a user's recipe book
     * @param user The user whose recipe book we are checking
     * @param recipe The recipe object representing the recipe we are removing
     */
    public static void removeRecipe(User user, Recipe recipe) {
        user.getRecipeBook().removeRecipe(recipe);
    }

    /**
     * Add a recipe to a user's recipe book
     * @param user The user whose recipe book we are adding to
     * @param recipe The recipe object representing the recipe we are adding
     */
    public static void addRecipe(User user, Recipe recipe) {
        user.getRecipeBook().addRecipe(recipe.getRecipeCode(), recipe);
    }

    public static void addRecipe(User user, String recipeName) {
        Recipe recipe = DatabaseManager.findRecipe(recipeName);
        if (recipe != null) {
            addRecipe(user, recipe);
        }
    }

    public static void rateRecipe(User user, String recipeName, int rating) {}
}