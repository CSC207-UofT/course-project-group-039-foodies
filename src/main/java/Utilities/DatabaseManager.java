package main.java.Utilities;

import main.java.Entities.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores instances of Recipe in Arraylist, adding Recipe to it,
 * removing Recipe from it, and filtering the Recipe.
 */
public class DatabaseManager {
    private static final HashMap<Integer, Recipe> dataList = new HashMap<>();
    private static Integer i = 0;

    /**
     * Adds a recipe to the database
     * @param recipe The Recipe object to add
     */
    public static void addRecipe(Recipe recipe) {
        dataList.put(i, recipe);
        i += 1;
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
    public static Recipe addRecipe(String name, String type, int servings,
                                 ArrayList<String> ingredients, String instructions) {
        Recipe newRecipe = new Recipe(i, name, type, servings, ingredients, instructions);
        dataList.put(i, newRecipe);
        i += 1;
        return newRecipe;
    }

    /**
     * Removes Recipe from the database
     * @param recipe The Recipe object to remove
     */
    public static void removeRecipe(Recipe recipe) {
        if (dataList.containsValue(recipe)) {
            dataList.remove(recipe.getRecipeCode());
        }
    }

    /**
     * Returns whether a recipe object is contained in dataList
     * @param recipe A Recipe object representing the recipe
     * @return Whether the recipe is contained in dataList
     */
    public static boolean containsRecipe(Recipe recipe) {
        return dataList.containsKey(recipe.getRecipeCode());
    }

    /**
     * Returns whether there exists a recipe object with a certain name in dataList
     * @param name A String representing the name of the recipe
     * @return Whether the recipe is contained in dataList
     */
    public static boolean containsRecipe(String name) {
        return findRecipe(name) != null;
    }

    /**
     * Returns a Recipe object with a certain name.
     * @param name A String representing the name of the recipe
     * @return A Recipe object if the recipe is included, and null otherwise
     */
    public static Recipe findRecipe(String name) {
        for (Map.Entry<Integer, Recipe> entry : DatabaseManager.dataList.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    /**
     * Returns a new code for a recipe
     * @return An Integer object with the code
     */
    public Integer getHighest() {
        Integer highest = 0;
        for (Integer key : this.dataMap.keySet()) {
            if (highest < key) {
                highest = key;
            }
        }
        return highest;
    }
}
