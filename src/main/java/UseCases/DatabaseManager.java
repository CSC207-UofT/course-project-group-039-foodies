package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeDatabase;

import java.util.ArrayList;

/**
 * This class stores instances of Recipe in a HashMap, adding Recipe to it, removing Recipe from it, and filtering the
 * Recipe.
 */
public class DatabaseManager {
    private final RecipeDatabase recipeDatabase = new RecipeDatabase();

    /**
     * Adds a recipe to the database
     * @param recipe The Recipe object to add
     */
    public void addRecipe(Recipe recipe) {
        recipeDatabase.addRecipe(recipe);
    }

    /**
     * Creates a new recipe from the parameters to add to the database and returns it
     * @param name The name of the recipe
     * @param type The type of the recipe
     * @param servings The servings of the recipe
     * @param ingredients The ingredients of the recipe
     * @param instructions The instructions of the recipe
     * @return The recipe just created
     */
    public Recipe addRecipe(String name, String type, int servings,
                                 ArrayList<String> ingredients, String instructions) {
        return recipeDatabase.addRecipe(name, type, servings, ingredients, instructions);
    }

    /**
     * Removes Recipe from the database
     * @param recipe The Recipe object to remove
     */
    public void removeRecipe(Recipe recipe) {
        recipeDatabase.removeRecipe(recipe);
    }

    /**
     * Returns whether a recipe object is contained in dataList
     * @param recipe A Recipe object representing the recipe
     * @return Whether the recipe is contained in dataList
     */
    public boolean containsRecipe(Recipe recipe) {
        return containsRecipe(recipe.getRecipeCode());
    }

    /**
     * Returns whether a recipe id is contained in dataList
     */
    public boolean containsRecipe(int recipecode) {
        for (int code : recipeDatabase.getKeys()) {
            if (recipecode == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether there exists a recipe object with a certain name in dataList
     * @param name A String representing the name of the recipe
     * @return Whether the recipe is contained in dataList
     */
    public boolean containsRecipe(String name) {
        return findRecipe(name) != null;
    }

    /**
     * Returns a Recipe object with a certain name.
     * @param name A String representing the name of the recipe
     * @return A Recipe object if the recipe is included, and null otherwise
     */
    public Recipe findRecipe(String name) {
        for (Recipe recipe : recipeDatabase.getRecipes()) {
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }
    
    /**
     * Returns the largest recipe code in the database
     * @return An Integer object with the code
     */
    public Integer getHighest() {
        int highest = 0;
        for (Integer key : recipeDatabase.getKeys()) {
            if (highest < key) {
                highest = key;
            }
        }
        return highest;
    }
}
