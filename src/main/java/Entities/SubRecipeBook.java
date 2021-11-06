package main.java.Entities;

import java.util.HashMap;


/** A category/ sub recipe book found in user's overall recipe book. Stores the user's saved recipes for this category.
 *
 *
 */
public class SubRecipeBook {
    public final HashMap<Integer, Recipe> recipes;
    public final String name;
    public final String description;

    /**
     * Instantiate an empty sub-recipe Book
     */
    public SubRecipeBook() {
        this.recipes = new HashMap<>();
        this.name = "SubRecipe Book";
        this.description = " ";
    }

    /**
     * Instantiate an empty sub-recipe book with name name
     *
     * @param  name - user provided name for the Recipe Book
     */
    public SubRecipeBook(String name) {
        this.recipes = new HashMap<>();
        this.name = name;
        this.description = " ";
    }

    /**
     * Instantiate an empty sub-recipe book with name name and description descriptiion.
     *
     * @param name - user provided name of the Recipe Book
     * @param description - user provided description for the recipe book
     */
    public SubRecipeBook(String name, String description) {
        this.recipes = new HashMap<>();
        this.name = name;
        this.description = description;
    }

    /**
     * Add a Recipe recipe with code recipe code to the sub recipe book
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @param recipe - the recipe
     */
    public void addRecipe(Integer recipecode, Recipe recipe) {
        this.recipes.put(recipecode, recipe);
    }

    /**
     * Remove the recipe with recipecode from the sub recipe book.
     *
     * @param recipecode - a unique String code identifier for Recipe
     */
    public void removeRecipe(Integer recipecode) {
        this.recipes.remove(recipecode);
    }

    /**
     * Remove a recipe from the subrecipebook
     *
     * @param recipe - the recipe to delete
     */
    public void removeRecipe(Recipe recipe) {
        removeRecipe(recipe.getRecipeCode());
    }

    /**
     * Return all recipes in the user's sub recipe book
     *
     * @return - return the recipes
     */
    public Recipe[] getRecipes() {
        return recipes.values().toArray(new Recipe[0]);
    }

    /**
     * Return the codes of all recipes in the user's sub recipe book
     *
     * @return - return the codes
     */
    public Integer[] getCodes() {
        return recipes.keySet().toArray(new Integer[0]);
    }

    /**
     * Retrieve the recipe with recipecode
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @return - return the recipe with recipecode
     */
    public Recipe getRecipe(Integer recipecode) {
        return this.recipes.get(recipecode);
    }

    public int size() {
        return this.recipes.size();
    }




}