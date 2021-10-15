package main.java;

import java.util.Arrays;

public class RecipeGateway {
    /**
     * Builds a RecipeGateway to convert raw recipe files to Recipe object and store them in the recipe database.
     * */

    DatabaseManager workingDatabase;
    Object[][] setOfRecipes;

    public RecipeGateway(DatabaseManager workingDatabase, Object[][] setOfRecipes) {
        this.workingDatabase = workingDatabase;
        this.setOfRecipes = setOfRecipes
    }

    public void BuildRecipe() {
        /** Take data from setOfRecipes and create Recipe objects to be stored in the recipe database. */

        for(int i = 0; i < setOfRecipes.length; i++) {
            Integer recipeCode = workingDatabase.getHighestKey();
            Recipe newRecipe = new Recipe(recipeCode, setOfRecipes[i][0], setOfRecipes[i][1], setOfRecipes[i][2], setOfRecipes[i][3], setOfRecipes[i][4]);
            workingDatabase.addRecipe(newRecipe);
        }
    }




}
