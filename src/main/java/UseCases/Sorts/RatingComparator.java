package main.java.UseCases.Sorts;

import main.java.Entities.Recipe;
import java.util.Comparator;

public class RatingComparator implements Comparator<Recipe> {
    /**
     * Compares its two arguments for order.
     *
     * Returns a negative integer, zero, or a positive integer
     * as recipe1 is less than, equal to, or greater than recipe2 in terms
     * of the rating.
     *
     * @param recipe1 the first Recipe to compare
     * @param recipe2 the second Recipe to compare
     * @return a negative integer, zero, or a positive integer
     *      as recipe1 is less than, equal to, or greater than recipe2
     */
    @Override
    public int compare (Recipe recipe1, Recipe recipe2) {
        return (int)(recipe2.getRating() - recipe1.getRating());
    }
}