package main.java.Filters;

import main.java.Entities.Recipe;

import java.util.ArrayList;

/**
 * Filter out the recipes that contains ingredients which may cause allergy.
 */
public class AllergyFilter implements Filter{
    private final Recipe[] data;
    private final String ingredient;

    /**
     * @param data Array of Recipes
     * @param ingredient Ingredient that may cause allergy.
     */
    public AllergyFilter(Recipe[] data, String ingredient) {
        this.data = data;
        this.ingredient = ingredient;
    }

    /**
     * @return Array of Recipes that is completely filtered based on the ingredient.
     */
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
