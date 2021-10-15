package main.java.Gateways;

import main.java.Entities.Recipe;
import main.java.Utilities.DatabaseManager;

import java.util.ArrayList;

public class RecipeGateway {
    /**
     * Builds a RecipeGateway to convert raw recipe files to Recipe object and store them in the recipe database.
     */
    Object[][] setOfRecipes;

    public RecipeGateway(Object[][] setOfRecipes) {
        this.setOfRecipes = setOfRecipes;
    }

    /**
     * Take data from setOfRecipes and create Recipe objects to be stored in the recipe database.
     */
    public void BuildRecipe() {
        for (Object[] setOfRecipe : setOfRecipes) {
            DatabaseManager.addRecipe((String) setOfRecipe[0], (String) setOfRecipe[1],
                    (int) setOfRecipe[2], (ArrayList<String>) setOfRecipe[3], (String) setOfRecipe[4]);
        }
    }

    /**
     * Adds a new recipe to the database and returns it
     * @return The recipe just added
     */
    public Recipe getNewRecipe() {
        return DatabaseManager.addRecipe("TemporaryRecipeName", "TemporaryRecipeType",
                1, new ArrayList<String>(), "TemporaryRecipe");
    }
}
