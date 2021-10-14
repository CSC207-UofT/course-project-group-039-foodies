package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores instances of Recipe in Arraylist, adding Recipe to it, removing Recipe from it, and filtering the
 * Recipe.
 */
public class DatabaseManager {
    private HashMap<Integer, Recipe> dataList = new HashMap<>();
    private static Integer i;

    public void addRecipe(Recipe recipe) {
        dataList.put(i, recipe);
        i += 1;
    }

    public void removeRecipe(Recipe recipe) {
        if (dataList.containsValue(recipe)) {
            dataList.remove(getKey(this.dataList, recipe));
        }
    }

    // Helper function for removeRecipe.
    private Integer getKey(HashMap<Integer, Recipe> map, Recipe recipe) {
        for (Map.Entry<Integer, Recipe> entry : map.entrySet()) {
            if (entry.getValue() == recipe) {
                return entry.getKey();
            }
        }
        return null;
    }
}