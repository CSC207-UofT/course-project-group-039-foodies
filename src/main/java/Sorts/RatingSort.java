package main.java.Sorts;

import main.java.Entities.Recipe;
import java.util.Arrays;

/**
 * Sort Recipes based on the ratings of the recipe (from high to low).
 */
public class RatingSort implements Sort {

    /**
     * @return Array of Recipes that is completely sorted based on the ratings.
     */
    @Override
    public Recipe[] sort(Recipe[] recipes) {
        Recipe[] result = recipes.clone();
        Arrays.sort(result, new RatingComparator());
        return result;
    }
}
