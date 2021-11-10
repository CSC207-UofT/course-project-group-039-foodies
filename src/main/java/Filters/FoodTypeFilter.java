package main.java.Filters;

import main.java.Entities.Recipe;
import java.util.ArrayList;

/**
 * Filter Recipes based on the food type.
 */
public class FoodTypeFilter implements Filter{
    private final Recipe[] data;
    private final String foodType;

    /**
     * @param data Array of Recipes.
     * @param foodType Food type (e.g. "Breakfast" or "Dinner").
     */
    public FoodTypeFilter(Recipe[] data, String foodType) {
        this.data = data;
        this.foodType = foodType;
    }

    /**
     * @return Array of Recipes that is completely filtered based on the food type.
     */
    @Override
    public Recipe[] filter() {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : data) {
            if (recipe.getFoodType().equals(foodType)) {
                result.add(recipe);
            }
        }
        return result.toArray(new Recipe[0]);
    }
}