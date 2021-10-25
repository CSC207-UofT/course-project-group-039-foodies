package main.java.Entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores a hashmap of recipes
 */
public class RecipeDatabase {
    private final HashMap<Integer, Recipe> dataMap = new HashMap<>();
    private Integer i = 0;

    /**
     * Adds a recipe to the database
     * @param recipe The Recipe object to add
     */
    public void addRecipe(Recipe recipe) {
        dataMap.put(i, recipe);
        i += 1;
    }

    /**
     * Removes Recipe from the database
     * @param recipe The Recipe object to remove
     */
    public void removeRecipe(Recipe recipe) {
        if (dataMap.containsValue(recipe)) {
            dataMap.remove(recipe.getRecipeCode());
        }
    }

    /**
     * Returns all the codes in recipeDatabase
     * @return An array of recipecodes in recipeDatabase
     */
    public Integer[] getKeys() {
        return dataMap.keySet().toArray(new Integer[0]);
    }

    /**
     * Returns all recipes in recipeDatabase
     * @return An array of Recipes in recipeDatabase
     */
    public Recipe[] getRecipes() {
        return dataMap.values().toArray(new Recipe[0]);
    }

}
