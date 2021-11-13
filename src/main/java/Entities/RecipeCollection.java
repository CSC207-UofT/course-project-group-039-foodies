package main.java.Entities;

import main.java.Modifiers.Filters.Filter;
import main.java.Modifiers.Sorts.Sort;

import java.util.*;

public class RecipeCollection extends AbstractCollection<Recipe> implements Iterable<Recipe> {
    final HashMap<Integer, Recipe> dataMap = new HashMap<>();
    Sort sortAlgorithm = null;
    HashSet<Filter> filters = new HashSet<>();
    boolean usesSort = false;

    @Override
    public Iterator<Recipe> iterator() {
        Recipe[] recipes = dataMap.values().toArray(new Recipe[0]);

        if (usesSort) {
            recipes = sortAlgorithm.sort(recipes);
        }
        for (Filter filter : filters) {
            recipes = filter.filter(recipes);
        }

        return Arrays.stream(recipes).iterator();
    }

    @Override
    public int size() {
        return dataMap.size();
    }

    /**
     * Adds a recipe from the collection
     * @param recipe The Recipe object to add
     */
    public void addRecipe(Recipe recipe) {
        dataMap.put(recipe.getRecipeCode(), recipe);
    }

    /**
     * Removes Recipe from the collection
     * @param name The name of the recipe to remove
     */
    public void removeRecipe(String name) {
        Recipe recipe = findRecipe(name);
        if (recipe != null) {
            removeRecipe(recipe);
        }
    }

    /**
     * Removes Recipe from the collection
     * @param recipe The Recipe object to remove
     */
    public void removeRecipe(Recipe recipe) {
        if (dataMap.containsValue(recipe)) {
            dataMap.remove(recipe.getRecipeCode());
        }
    }

    /**
     * Returns a Recipe object with a certain name.
     * @param name A String representing the name of the recipe
     * @return A Recipe object if the recipe is included, and null otherwise
     */
    public Recipe findRecipe(String name) {
        for (Recipe recipe : this) { // Uses the iterator
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }

    /**
     * Returns whether a recipe is contained
     * @param recipe The recipe being searched for
     * @return Whether the recipe is contained
     */
    public boolean containsRecipe(Recipe recipe) {
        return containsRecipe(recipe.getName());
    }


    /**
     * Returns whether a recipecode is contained
     * @param recipecode The recipecode being searched for
     * @return Whether a recipecode is contained
     */
    public boolean containsRecipe(int recipecode) {
        for (int code : dataMap.keySet()) {
            if (recipecode == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether there exists a recipe object with a certain name in dataList
     * @param name A String representing the name of the recipe
     * @return Whether the recipe is contained in dataList
     */
    public boolean containsRecipe(String name) {
        return findRecipe(name) != null;
    }

    /**
     * Returns all the recipecodes
     * @return An array of recipecodes of each recipe
     */
    public Integer[] getRecipeCodes() {
        return dataMap.keySet().toArray(new Integer[0]);
    }

    /**
     * Returns all recipes stored
     * @return An array of Recipes stored
     */
    public Recipe[] getRecipes() {
        return dataMap.values().toArray(new Recipe[0]);
    }

    /**
     * Sets the sort interface that the recipeCollection should apply
     * @param sort The sort interface to use
     */
    public void setSort(Sort sort) {
        usesSort = true;
        sortAlgorithm = sort;
    }

    /**
     * Stops the recipeCollection from using a sort interface
     */
    public void removeSort() {
        usesSort = false;
    }

    /**
     * Sets a filter interface that the recipeCollection should apply
     * @param filter The filter interface to use
     */
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    /**
     * Removes a filter interface from the filters that the recipeCollection should apply
     * @param filterToRemove The filter interface to remove
     */
    public void removeFilter(Filter filterToRemove) {
        for (Filter filter : filters) {
            if (filter.equals(filterToRemove)) {
                filters.remove(filter);
                return;
            }
        }
    }
}
