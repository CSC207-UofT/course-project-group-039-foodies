package main.java.Filters;

import main.java.Entities.Recipe;

import java.util.ArrayList;

public class FoodTypeFilter implements Filter{
    private final Recipe[] data;
    private final String foodType;

    public FoodTypeFilter(Recipe[] data, String foodType) {
        this.data = data;
        this.foodType = foodType;
    }

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