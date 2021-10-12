package main.java;

import java.util.ArrayList;

/**
 * This class stores instances of Recipe in ArrayList.
 */

public class RecipeDatabase {
    private ArrayList<Recipe> dataList;

    /**
     * Constructs an ArrayList and add recipes
     * @param recipe
     */
    public RecipeDatabase(Recipe recipe) {
        this.dataList.add(recipe);
        }
    }
}
