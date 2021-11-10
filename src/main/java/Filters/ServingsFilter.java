package main.java.Filters;

import main.java.Entities.Recipe;

import java.util.ArrayList;

/**
 * Filter Recipes based on the number of servings.
 */
public class ServingsFilter implements Filter {
    private final Recipe[] data;
    private final int servings;

    /**
     * @param data Array of Recipes.
     * @param servings Number of servings.
     */
    public ServingsFilter(Recipe[] data, int servings) {
        this.data = data;
        this.servings = servings;
    }

    /**
     * @return Array of Recipes that is completely filtered based on the number of servings.
     */
    @Override
    public Recipe[] filter() {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : data) {
            if (recipe.getServings() == this.servings) {
                result.add(recipe);
            }
        }
        return result.toArray(new Recipe[0]);
    }
}