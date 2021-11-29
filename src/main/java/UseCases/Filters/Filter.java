package main.java.UseCases.Filters;

import main.java.Entities.Recipe;

/**
 * Interface for filtering algorithms.
 */
public interface Filter {
    /**
     * @param recipes ArrayList of recipes.
     * @return filtered ArrayList of recipes.
     */
    Recipe[] filter(Recipe[] recipes);
}

