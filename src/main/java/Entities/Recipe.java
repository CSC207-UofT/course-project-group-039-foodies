package main.java.Entities;

import java.util.ArrayList;

public class Recipe {
    /** Creates a Recipe object */

    private final String foodName;
    private final Integer recipeCode;
    private final String foodType;
    private final int servings;
    private final ArrayList<String> ingredients;
    private final String instructions;
    public double rating;
    public double ratingCount;

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

    /** Returns a formatted Recipe for the user to read
     * @return a formatted string
     */
    public String toString() { return this.foodName + "\n" + this.instructions; }

    /** Updates the cumulative rating for this recipe
     */
    public void addRating(double rating) {
        this.ratingCount ++;
        this.rating = (this.rating * (this.ratingCount - 1) + rating) / this.ratingCount;
    }

    public String getInstructions() { return this.instructions; }

    public double getRating() { return this.rating; }

    public String getFoodType() { return this.foodType; }

    public String getName() { return this.foodName; }

    public int getServings() { return this.servings; }

    public ArrayList<String> getIngredients() { return this.ingredients; }

    public Integer getRecipeCode() { return this.recipeCode; }
}
