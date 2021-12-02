package main.java.UseCases.Utilities;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Sorts.Sort;

import java.util.Iterator;

/**
 * A facade for the recipe collection to preserve clean architecture
 */
public class RecipeCollectionFacade {
    /**
     * Finds the Recipe in RecipeCollection given its name.
     * @param recipeCollection The RecipeCollection
     * @param recipeName The name of the Recipe
     * @return The corresponding Recipe
     */
    public static Recipe findRecipe(RecipeCollection recipeCollection, String recipeName) {
        return recipeCollection.findRecipe(recipeName);
    }

    /**
     * Adds a filter to the RecipeCollection
     * @param recipeCollection The RecipeCollection
     * @param filter The Filter
     */
    public static void addFilter(RecipeCollection recipeCollection, Filter filter) {
        recipeCollection.addFilter(filter);
    }

    /**
     * Removes a filter from the RecipeCollection
     * @param recipeCollection The RecipeCollection
     * @param filter The Filter
     */
    public static void removeFilter(RecipeCollection recipeCollection, Filter filter) {
        recipeCollection.removeFilter(filter);
    }

    /**
     * Adds a Sort to the RecipeCollection
     * @param recipeCollection The RecipeCollection
     * @param sort The Sort object
     */
    public static void setSort(RecipeCollection recipeCollection, Sort sort) {
        recipeCollection.setSort(sort);
    }

    /**
     * Remove a Recipe from the RecipeCollection
     * @param recipeCollection The RecipeCollection
     */
    public static void removeSort(RecipeCollection recipeCollection) {
        recipeCollection.removeSort();
    }

    /**
     * Add a Recipe to the RecipeCollection
     * @param recipeCollection The RecipeCollection
     * @param recipe The recipe to add
     */
    public static void addRecipe(RecipeCollection recipeCollection, Recipe recipe) {
        recipeCollection.addRecipe(recipe);
    }

    /**
     * A getter for a RecipeCollection's iterator
     * @param recipeCollection The RecipeCollection
     * @return An iterator corresponding to the RecipeCollection
     */
    public static Iterator<Recipe> getIterator(RecipeCollection recipeCollection) {
        return recipeCollection.iterator();
    }
}
