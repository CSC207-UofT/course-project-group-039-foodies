package main.java.Entities;

import java.util.HashMap;


/** A user's recipe book. Stores the user's saved recipes
 *
 */
public class RecipeBook {
    private final HashMap<Integer, Recipe> recipebook;

    /**
     * Instantiate an empty Recipe Book
     */
    public RecipeBook() {
        this.recipebook = new HashMap<>();
    }

    /**
     * Add a Recipe recipe with code recipe code to the Recipe Book
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @param recipe - the recipe
     */
    public void addRecipe(Integer recipecode, Recipe recipe) {
        this.recipebook.put(recipecode, recipe);
    }

    /**
     * Remove the recipe with recipecode from recipebook.
     *
     * @param recipecode - a unique String code identifier for Recipe
     */
    public void removeRecipe(Integer recipecode) {
        this.recipebook.remove(recipecode);
    }

    /**
     * Remove a recipe from recipebook
     *
     * @param recipe - the recipe to delete
     */
    public void removeRecipe(Recipe recipe) {
        removeRecipe(recipe.getRecipeCode());
    }

    /**
     * Return all recipes in the user's recipebook
     *
     * @return - return the recipes
     */
    public Recipe[] getRecipes() {
        return recipebook.values().toArray(new Recipe[0]);
    }

    /**
     * Return the codes of all codes in the user's recipebook
     *
     * @return - return the codes
     */
    public Integer[] getCodes() {
        return recipebook.keySet().toArray(new Integer[0]);
    }

    /**
     * Retrieve the recipe with recipecode
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @return - return the recipe with recipecode
     */
    public Recipe getRecipe(Integer recipecode) {
        return this.recipebook.get(recipecode);
    }

    public int size() {
        return this.recipebook.size();
    }


}