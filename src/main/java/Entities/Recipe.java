package main.java.Entities;

import java.util.ArrayList;

/**
 * A recipe which contains name, code, food type, number of servings, list of ingredients, and rating.
 */
public class Recipe {

    private final String foodName;
    private final Integer recipeCode;
    private final String foodType;
    private final int servings;
    private final ArrayList<String> ingredients;
    private final String instructions;
    public double rating;
    public double ratingCount;

    /**
     * Create a recipe.
     * @param recipeCode code of the recipe.
     * @param foodName name of the recipe.
     * @param foodType food type of the recipe (e.g. dinner).
     * @param servings number of servings of the recipe.
     * @param ingredients ArrayList of ingredients of the recipe.
     * @param instructions instruction of the recipe.
     */
    public Recipe(int recipeCode, String foodName, String foodType, int servings,
                  ArrayList<String> ingredients, String instructions) {
        this.recipeCode = recipeCode;
        this.foodName = foodName;
        this.foodType = foodType;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.rating = 0;
        this.ratingCount = 0;
    }

    /**
     * Returns a formatted Recipe for the user to read.
     * @return a formatted string
     */
    public String toString() { return this.foodName + "\n" + this.instructions; }


    /**
     * Add rating to the recipe.
     * @param rating rating of the recipe, which is a double.
     */
    public void addRating(double rating) {
        this.ratingCount ++;
        this.rating = (this.rating * (this.ratingCount - 1) + rating) / this.ratingCount;
    }

    /**
     * Get instructions of the recipe.
     * @return Returns instruction of the recipe in string.
     */
    public String getInstructions() { return this.instructions; }

    /**
     * Get rating of the recipe.
     * @return Returns rating of the recipe in double.
     */
    public double getRating() { return this.rating; }

    /**
     * Get food type of the recipe.
     * @return Returns food type of the recipe in string.
     */
    public String getFoodType() { return this.foodType; }

    /**
     * Get name of the recipe.
     * @return Returns name of the food in string.
     */
    public String getName() { return this.foodName; }

    /**
     * Get number of servings of the recipe.
     * @return Returns the number of servings in int.
     */
    public int getServings() { return this.servings; }

    /**
     * Get ingredients of the recipe.
     * @return Returns ArrayList of the ingredients in string.
     */
    public ArrayList<String> getIngredients() { return this.ingredients; }

    /**
     * Get code of the recipe.
     * @return Return code of the recipe in integer.
     */
    public Integer getRecipeCode() { return this.recipeCode; }
}
