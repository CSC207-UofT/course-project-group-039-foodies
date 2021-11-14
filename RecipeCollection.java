package main.java.Entities;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RecipeCollection extends AbstractCollection<Recipe> implements Iterable<Recipe> {
    private final HashMap<Integer, Recipe> dataMap = new HashMap<>();

    @Override
    public Iterator<Recipe> iterator() {
        return dataMap.values().iterator();
    }

    @Override
    public int size() {
        return dataMap.size();
    }

    /**
     * Adds a recipe to the collection
     * @param recipe The Recipe object to add
     */
    public void addRecipe(Recipe recipe) {
        dataMap.put(recipe.getRecipeCode(), recipe);
    }


    /**
     * Add a recipe to the collection
     * @param recipecode - the Recipecode corresponding to the Recipe object to add
     * @param recipe - the Recipe Object to add
     */
    public void addRecipe(Integer recipecode, Recipe recipe) {
        dataMap.put(recipecode, recipe);
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
     * Remove recipe with recipecode
     * @param recipecode - the recipecode for the recipe to be removed
     */
    public void removeRecipe(Integer recipecode) {
        dataMap.remove(recipecode);
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
     * Return the recipe with recipecode
     * @param recipecode - the code corresponding to the Recipe Object to be returned
     * @return a Recipe object
     */
    public Recipe findRecipe(Integer recipecode) {
        return this.dataMap.get(recipecode);
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
}
