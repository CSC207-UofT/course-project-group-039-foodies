package main.java.Filters;

import main.java.Entities.Recipe;
import java.util.ArrayList;

/**
 * Filter Recipes based on the food type.
 */
public class FoodTypeFilter implements Filter{
    private final String foodType;

    /**
     * @param foodType Food type (e.g. "Breakfast" or "Dinner").
     */
    public FoodTypeFilter(String foodType) {
        this.foodType = foodType;
    }

    /**
     * @return Array of Recipes that is completely filtered based on the food type.
     */
    @Override
    public Recipe[] filter(Recipe[] recipes) {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getFoodType().equals(foodType)) {
                result.add(recipe);
            }
        }
        return result.toArray(new Recipe[0]);
    }
}
