package main.java.UseCases;

import main.java.Entities.Recipe;

import java.util.ArrayList;

public class RecipeFactory {
    private static int nextRecipeCode;

    /**
     * @param name The name of the recipe
     * @param type The type of the recipe
     * @param servings The number of people the recipe serves
     * @param ingredients The ingredients in the recipe
     * @param instructions The instructions for creating the recipe
     * @return The created recipe
     */
    public static Recipe createRecipe(String name, String type, int servings,
                               ArrayList<String> ingredients, String instructions) {
        Recipe newRecipe = new Recipe(nextRecipeCode, name, type, servings, ingredients, instructions);
        nextRecipeCode ++;
        return newRecipe;
    }
}
