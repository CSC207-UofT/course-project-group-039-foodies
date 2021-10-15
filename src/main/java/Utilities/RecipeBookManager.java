package main.java.Utilities;

import main.java.Entities.Recipe;
import main.java.Entities.User;

public class RecipeBookManager {

    public static boolean containsRecipe(User user, String recipe) {
        return containsRecipe(user, DatabaseManager.findRecipe(recipe));
    }

    public static boolean containsRecipe(User user, Recipe recipe) {
        for (int code : user.getRecipeBook().getCodes()) {
            if (code == recipe.getRecipeCode()) {
                return true;
            }
        }
        return false;
    }

    public static Recipe[] getRecipes(User user) {
        return user.getRecipeBook().getRecipes();
    }

    public static String recipeToString(Recipe recipe) {
        return recipe.toString();
    }

    public static void removeRecipe(User user, String recipeName) {
        Recipe recipe = DatabaseManager.findRecipe(recipeName);
        if (recipe != null) {
            removeRecipe(user, recipe);
        }
    }

    public static void removeRecipe(User user, Recipe recipe) {
        user.getRecipeBook().removeRecipe(recipe);
    }

    public static void rateRecipe(User user, String recipeName, int rating) {
    }
}