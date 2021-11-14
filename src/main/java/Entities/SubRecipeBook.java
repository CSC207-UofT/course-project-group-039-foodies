package main.java.Entities;

import java.util.ArrayList;
import java.util.HashMap;


/** A category/ sub recipe book found in user's overall recipe book. Stores the user's saved recipes for this category.
 */
public class SubRecipeBook {
    public final RecipeCollection recipes;
    public final String name;
    public final String description;

    /**
     * Instantiate an empty sub-recipe Book with no name or description provided.
     */
    public SubRecipeBook() {
        this.recipes = new RecipeCollection();
        this.name = "SubRecipe Book";
        this.description = " ";
    }

    /**
     * Instantiate an empty sub-recipe book with name name
     *
     * @param  name - user provided name for the Recipe Book
     */
    public SubRecipeBook(String name) {
        this.recipes = new RecipeCollection();
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
        this.recipes = new RecipeCollection();
        this.name = name;
        this.description = description;
    }

    /**
     * Return the name of the subrecipebook.
     * @return String representing the name of the subrecipebook.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add a Recipe recipe with code recipe code to the sub recipe book
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @param recipe - the recipe
     */
    public void addRecipe(Integer recipecode, Recipe recipe) {
        this.recipes.addRecipe(recipecode, recipe);
    }

    /**
     * Add a Recipe object to the subrecipebook
     *
     * @param recipe - the recipe object to be added
     */
    public void addRecipe(Recipe recipe) {
        this.recipes.addRecipe(recipe);
    }

    /**
     * Remove the recipe with recipecode from the sub recipe book.
     *
     * @param recipecode - a unique String code identifier for Recipe
     */
    public void removeRecipe(Integer recipecode) {
        this.recipes.removeRecipe(recipecode);
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
        return recipes.getRecipes();
    }

    /**
     * Return the codes of all recipes in the user's sub recipe book
     *
     * @return - return the codes
     */
    public Integer[] getCodes() {
        return recipes.getRecipeCodes();
    }

    /**
     * Retrieve the recipe with recipecode
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @return - return the recipe with recipecode
     */
    public Recipe getRecipe(Integer recipecode) {
        return this.recipes.findRecipe(recipecode);
    }

    /**
     * Retrieve the recipe with name name
     * @param recipename - the nanme of the recipe to return
     * @return a Recipe object with name name
     */
    public Recipe getRecipe(String recipename) {
        return this.recipes.findRecipe(recipename);
    }

    /**
     * Return the number of recipes in the subrecipebook.
     * @return an int indicating the number of recipes in the subrecipebook.
     */
    public int size() {
        return this.recipes.size();
    }

}