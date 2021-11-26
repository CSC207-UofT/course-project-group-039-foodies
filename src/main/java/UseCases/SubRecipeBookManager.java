package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.SubRecipeBook;
import main.java.Entities.User;

/**
 * A public class SubRecipeBookManager which manages the SubRecipeBook.
 */
public class SubRecipeBookManager {
    SubRecipeBook subRecipeBook;

    /**
     * Instantiate a SubRecipeBookManager for a SubRecipeBook.
     *
     * @param subRecipeBook - the subRecipeBook for which the SubRecipeBookManager is being instantiated
     */
    public SubRecipeBookManager(SubRecipeBook subRecipeBook) {
        this.subRecipeBook = subRecipeBook;
    }

    /**
     * Return whether a Recipe of a certain name is contained in a user's SubRecipeBook.
     *
     * @param recipeName The name of the recipe we are looking for
     * @return true iff the recipe is contained in the SubRecipeBook
     */
    public boolean containsRecipe(String recipeName) {
        for (Recipe recipe : subRecipeBook.getRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a Recipe object is contained in a user's SubRecipeBook.
     *
     * @param recipe - the recipe we are looking for
     * @return true if and only if the user's SubRecipeBook contains the recipe and false otherwise
     */
    public boolean containsRecipe(Recipe recipe) {
        for (int code : subRecipeBook.getCodes()) {
            if (code == recipe.getRecipeCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of recipes in the user's SubRecipeBook.
     *
     * @return the recipes in the user's SubRecipeBook
     */
    public Recipe[] getRecipes() {
        return subRecipeBook.getRecipes();
    }

    /**
     * Remove a recipe of a certain name from a user's SubRecipeBook.
     *
     * @param recipeName The name of the recipe we are removing
     */
    public void removeRecipe(String recipeName) {
        for (Recipe recipe : subRecipeBook.getRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                subRecipeBook.removeRecipe(recipe);
            }
        }
    }

    /**
     * Remove a recipe from a user's SubRecipeBook
     * @param recipe The Recipe object representing the recipe we are removing
     */
    public void removeRecipe(Recipe recipe) {
        subRecipeBook.removeRecipe(recipe);
    }

//    public void rateRecipe(User user, String recipeName, int rating) {}
}
