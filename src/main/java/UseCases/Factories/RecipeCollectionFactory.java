package main.java.UseCases.Factories;

import main.java.Entities.RecipeCollection;

public class RecipeCollectionFactory {
    /**
     * Creates an empty recipeCollection.
     * Necessary to avoid violations to clean architecture.
     * @return A recipeCollection
     */
    public static RecipeCollection createRecipeCollection() {
        return new RecipeCollection();
    }
}
