package main.java.UseCases;

import main.java.Entities.Recipe;

import java.util.ArrayList;

public class RecipeFactory {
    private static int nextRecipeCode;

    public static Recipe createRecipe(String name, String type, int servings,
                               ArrayList<String> ingredients, String instructions) {
        Recipe newRecipe = new Recipe(nextRecipeCode, name, type, servings, ingredients, instructions);
        nextRecipeCode ++;
        return newRecipe;
    }
}
