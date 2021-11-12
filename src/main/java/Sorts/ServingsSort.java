package main.java.Sorts;

import main.java.Entities.Recipe;
import java.util.Arrays;

/**
 * Sort Recipes based on the number of servings (from small to big).
 */
public class ServingsSort implements Sort{
    private final Recipe[] data;

    /**
     * @param data Array of Recipes.
     */
    public ServingsSort(Recipe[] data) {
        this.data = data;
    }

    /**
     * @return Array of Recipes that is completely sorted based on the number of servings (from small to big).
     */
    @Override
    public Recipe[] sort() {
        Recipe[] result = this.data.clone();
        Arrays.sort(result, new ServingsComparator());
        return result;
    }
}