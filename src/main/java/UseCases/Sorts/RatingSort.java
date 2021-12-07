package main.java.UseCases.Sorts;

import main.java.Entities.Recipe;
import java.util.Arrays;

/**
 * Sort Recipes based on their ratings (from high to low).
 */
public class RatingSort implements Sort {

    /**
     * Return a new array of recipes that is sorted based on their ratings.
     * @return Array of Recipes that is completely sorted based on the ratings.
     */
    @Override
    public Recipe[] sort(Recipe[] recipes) {
        Recipe[] result = recipes.clone();
        Arrays.sort(result, new RatingComparator());
        return result;
    }
}

