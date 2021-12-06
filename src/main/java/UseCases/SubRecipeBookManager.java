package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.SubRecipeBook;

public class SubRecipeBookManager {
    SubRecipeBook subRecipeBook;

    /**
     * Create a manager for SubRecipeBook.
     * @param subRecipeBook - the subRecipeBook
     */
    public SubRecipeBookManager(SubRecipeBook subRecipeBook) {
        this.subRecipeBook = subRecipeBook;
    }

    /**
     * Return whether a Recipe of a certain name is contained in a User's SubRecipeBook.
     * @param recipeName - the recipe name we are looking for
     * @return true if and only if the user contains the recipe and false otherwise.
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
     * Return a list of Recipes in the User's RecipeBook
     * @return The array of Recipes
     */
    public Recipe[] getRecipes() {
        return subRecipeBook.getRecipes();
    }

    /**
     * Remove a Recipe of a certain name from a User's RecipeBook.
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
     * Remove a Recipe from a User's Recipe Book.
     * @param recipe The recipe object representing the recipe we are removing
     */
    public void removeRecipe(Recipe recipe) {
        subRecipeBook.removeRecipe(recipe);
    }

}
