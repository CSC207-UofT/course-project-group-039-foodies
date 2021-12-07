package main.java.UseCases.Sorts;

import main.java.Entities.Recipe;

/**
 * Interface for the sorting algorithms.
 */
public interface Sort {
    /**
     * Method that sort the array of recipes.
     * @param recipes ArrayList of recipes.
     * @return filtered ArrayList of recipes.
     */
    Recipe[] sort(Recipe[] recipes);
}

