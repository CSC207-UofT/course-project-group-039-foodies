package main.java.Filters;

import main.java.Entities.Recipe;

import java.util.ArrayList;

public class AllergyFilter implements Filter{
    private final Recipe[] data;
    private final String ingredient;

    public AllergyFilter(Recipe[] data, String ingredient) {
        this.data = data;
        this.ingredient = ingredient;
    }

    @Override
    public Recipe[] filter() {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : data) {
            if (!recipe.getIngredients().contains(this.ingredient)) {
                result.add(recipe);
            }
        }
        return result.toArray(new Recipe[0]);
    }
}
