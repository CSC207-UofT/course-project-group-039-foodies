package main.java.UseCases.Filters;

import main.java.Entities.Recipe;
import java.util.ArrayList;

/**
 * Filter Recipes based on the food types.
 */
public class FoodTypeFilter implements Filter{
    private final String foodType;

    /**
     * Initialize the FoodTypeFilter.
     * @param foodType Food type (e.g. "Breakfast" or "Dinner").
     */
    public FoodTypeFilter(String foodType) {
        this.foodType = foodType;
    }

    /**
     * Loop through the Array of recipes and filter only recipes with certain food type.
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

    /**
     * Check whether two FoodTypeFilter classes are the same (i.e. filter the same food type).
     * @param obj an instance of a filter class that implements Filter interface.
     * @return true if obj is another FoodTypeFilter, and it is filtering same food type with itself.
     * false if obj is not an FoodTypeFilter, or it is not filtering same food type with itself.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FoodTypeFilter) {
            return ((FoodTypeFilter) obj).foodType.equals(foodType);
        }

        return false;
    }
}

