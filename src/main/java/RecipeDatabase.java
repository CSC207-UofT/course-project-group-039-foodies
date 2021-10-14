package main.java;

import java.util.ArrayList;

/**
 * This class stores instances of Recipe in ArrayList.
 */

public class RecipeDatabase {
    public ArrayList<Recipe> dataList = new ArrayList<Recipe>();

    /**
     * Constructs an ArrayList and add recipes
     * @param recipe recipe given recipe
     */
    public RecipeDatabase(Recipe recipe) {
        this.dataList.add(recipe);
    }
}
