package main.java.Sorts;

import main.java.Entities.Recipe;
import java.util.Comparator;

public class RatingComparator implements Comparator<Recipe> {
    /**
     * Compares its two arguments for order.
     *
     * Returns -1, 0, or 1 as recipe1 is less than, equal to, or greater than recipe2 in terms of the rating.
     *
     * @param recipe1 the first Recipe to compare
     * @param recipe2 the second Recipe to compare
     * @return -1, 0, or 1 as recipe1 is less than, equal to, or greater than recipe2
     */
    @Override
    public int compare (Recipe recipe1, Recipe recipe2) {
        if (recipe1.getRating > recipe2.getRating) {
            return 1;
        } else if (recipe1.getRating == recipe2.getRating) {
            return 0;
        } else {
            return -1;
        }
    }
}