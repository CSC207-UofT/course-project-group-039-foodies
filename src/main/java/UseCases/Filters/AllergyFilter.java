package main.java.UseCases.Filters;

import main.java.Entities.Recipe;

import java.util.ArrayList;

/**
 * Filter out the recipes that contains ingredients which may cause allergy.
 */
public class AllergyFilter implements Filter{
    private final String ingredient;

    /**
     * @param ingredient Ingredient that may cause allergy.
     */
    public AllergyFilter(String ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * @return Array of Recipes that is completely filtered based on the ingredient.
     */
    @Override
    public Recipe[] filter(Recipe[] recipes) {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (!recipe.getIngredients().contains(this.ingredient)) {
                result.add(recipe);
            }
        }
        return result.toArray(new Recipe[0]);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AllergyFilter) {
            return ((AllergyFilter) obj).ingredient.equals(ingredient);
        }
        return false;
    }
}
