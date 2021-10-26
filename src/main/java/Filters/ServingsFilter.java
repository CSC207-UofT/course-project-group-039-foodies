package main.java.Filters;

import main.java.Entities.Recipe;

import java.util.ArrayList;

public class ServingsFilter implements Filter {
    private final Recipe[] data;
    private final int servings;

    public ServingsFilter(Recipe[] data, int servings) {
        this.data = data;
        this.servings = servings;
    }

    @Override
    public Recipe[] filter() {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : data) {
            if (recipe.getServings() == this.servings) {
                result.add(recipe);
            }
        }
        return result.toArray(new Recipe[0]);
    }
}