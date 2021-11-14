package main.java.Sorts;

import main.java.Entities.Recipe;
import java.util.Arrays;

/**
 * Sort Recipes based on the number of servings (from small to big).
 */
public class ServingsSort implements Sort{

    /**
     * @return Array of Recipes that is completely sorted based on the number of servings (from small to big).
     */
    @Override
    public Recipe[] sort(Recipe[] recipes) {
        Recipe[] result = recipes.clone();
        Arrays.sort(result, new ServingsComparator());
        return result;
    }
}
