package main.java.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import main.java.Entities.User;

public class Recipe {
    /** Creates a Recipe object */

    private final String foodName;
    private final Integer recipeCode;
    private final String foodType;
    private final int servings;
    private final ArrayList<String> ingredients;
    private final String instructions;
    public Integer rating;
    private final HashMap<User, Integer> ratingMap;

    public Recipe(int recipeCode, String foodName, String foodType, int servings,
                  ArrayList<String> ingredients, String instructions) {
        this.recipeCode = recipeCode;
        this.foodName = foodName;
        this.foodType = foodType;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.ratingMap = new HashMap<>();
    }

    /** Returns a formatted Recipe for the user to read
     * @return a formatted string
     */
    public String toString() { return this.foodName + "\n" + this.instructions; }

    /** Updates the cumulative rating for this recipe
     */
    public void addRating(User user, Integer rating) {
        this.ratingMap.put(user, rating);
        int counter = 0;
        for (User i : this.ratingMap.keySet()) {
            counter = counter + this.ratingMap.get(i);
        }
        this.rating = counter/this.ratingMap.size();
    }

    public Integer getRating() { return this.rating; }

    public String getFoodType() { return this.foodType; }

    public String getName() { return this.foodName; }

    public int getServings() { return this.servings; }

    public ArrayList<String> getIngredients() { return this.ingredients; }

    public Integer getRecipeCode() { return this.recipeCode; }
}
