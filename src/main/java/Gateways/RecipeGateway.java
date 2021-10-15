package main.java.Gateways;

import main.java.Entities.Recipe;
import main.java.UseCases.DatabaseManager;

import java.util.ArrayList;

public class RecipeGateway {
    /**
     * Builds a RecipeGateway to convert raw recipe files to Recipe object and store them in the recipe database.
     */
    Object[][] setOfRecipes;
    DatabaseManager databaseManager;

    public RecipeGateway(Object[][] setOfRecipes, DatabaseManager databaseManager) {
        this.setOfRecipes = setOfRecipes;
        this.databaseManager = databaseManager;
    }

    /**
     * Take data from setOfRecipes and create Recipe objects to be stored in the recipe database.
     */
    public void BuildRecipe() {
        for (Object[] setOfRecipe : setOfRecipes) {
            databaseManager.addRecipe((String) setOfRecipe[0], (String) setOfRecipe[1],
                    (int) setOfRecipe[2], (ArrayList<String>) setOfRecipe[3], (String) setOfRecipe[4]);
        }
    }

    /**
     * Adds a new recipe to the database and returns it
     * @return The recipe just added
     */
    public Recipe getNewRecipe() {
        return databaseManager.addRecipe("TemporaryRecipeName", "TemporaryRecipeType",
                1, new ArrayList<String>(), "TemporaryRecipe");
    }
}
