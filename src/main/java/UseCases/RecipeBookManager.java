package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;
import main.java.Entities.User;

public class RecipeBookManager {
    RecipeBook recipeBook;
    public RecipeBookManager(User user) {
       this(user.getRecipeBook());
    }
    public RecipeBookManager(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    /**
     * Return whether a recipe of a certain name is contained in a user's recipe book
     * @param recipeName The recipe name we are looking for
     * @return True if and only if the user contains the recipe
     */
    public boolean containsRecipe(String recipeName) {
        for (Recipe recipe : recipeBook.getRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a recipe object is contained in a user's recipe book
     * @param recipe The recipe name we are looking for
     * @return True if and only if the user contains the recipe
     */
    public boolean containsRecipe(Recipe recipe) {
        for (int code : recipeBook.getCodes()) {
            if (code == recipe.getRecipeCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of recipes in the user's recipe book
     * @return The array of recipes
     */
    public Recipe[] getRecipes() {
        return recipeBook.getRecipes();
    }

    /**
     * Remove a recipe of a certain name from a user's recipe book
     * @param recipeName The name of the recipe we are removing
     */
    public void removeRecipe(String recipeName) {
        for (Recipe recipe : recipeBook.getRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                recipeBook.removeRecipe(recipe);
            }
        }
    }

    /**
     * Remove a recipe from a user's recipe book
     * @param recipe The recipe object representing the recipe we are removing
     */
    public void removeRecipe(Recipe recipe) {
        recipeBook.removeRecipe(recipe);
    }

    /**
     * Add a recipe to a user's recipe book
     * @param recipe The recipe object representing the recipe we are adding
     */
    public void addRecipe(Recipe recipe) {
        recipeBook.addRecipe(recipe.getRecipeCode(), recipe);
    }

    public Recipe findRecipe(String name) {
        for (Recipe recipe : recipeBook.getRecipes()) {
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }

}