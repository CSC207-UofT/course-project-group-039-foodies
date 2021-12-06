package main.java.UseCases.Filters;

import main.java.Entities.Recipe;

/**
 * Interface for the filtering algorithms.
 */
public interface Filter {
    /**
     * Method that filter the Array of recipes.
     * @param recipes Array of recipes.
     * @return filtered Array of recipes.
     */
    Recipe[] filter(Recipe[] recipes);
}

