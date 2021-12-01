package main.java.UseCases.Filters;

import main.java.Entities.Recipe;

import java.util.ArrayList;

/**
 * Filter Recipes based on the numbers of servings.
 */
public class ServingsFilter implements Filter {
    private final int servings;

    /**
     * @param servings Number of servings.
     */
    public ServingsFilter(int servings) {
        this.servings = servings;
    }

    /**
     * @return Array of Recipes that is completely filtered based on the number of servings.
     */
    @Override
    public Recipe[] filter(Recipe[] recipes) {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getServings() == this.servings) {
                result.add(recipe);
            }
        }
        return result.toArray(new Recipe[0]);
    }

    /**
     * @param obj an instance of a filter class that implements Filter interface.
     * @return true if obj is another ServingsFilter, and it is filtering same number of servings with itself.
     * false if obj is not an ServingsFilter, or it is not filtering same number of servings with itself.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ServingsFilter) {
            return ((ServingsFilter) obj).servings == servings;
        }
        return false;
    }
}

