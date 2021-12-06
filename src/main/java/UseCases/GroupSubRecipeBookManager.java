package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.GroupSubRecipeBook;


public class GroupSubRecipeBookManager {
    GroupSubRecipeBook groupSubRecipeBook;
    public GroupSubRecipeBookManager(GroupSubRecipeBook groupRecipeBook) {
        this.groupSubRecipeBook = groupRecipeBook;
    }

    /**
     * Return whether a recipe of a certain name is contained in a group's sub recipe book
     * @param recipeName The recipe name we are looking for
     * @return True if and only if the group contains the recipe
     */
    public boolean containsRecipe(String recipeName) {
        for (Recipe recipe : groupSubRecipeBook.getRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a recipe object is contained in a group's sub recipe book
     * @param recipe The recipe name we are looking for
     * @return True if and only if the group contains the recipe
     */
    public boolean containsRecipe(Recipe recipe) {
        for (int code : groupSubRecipeBook.getCodes()) {
            if (code == recipe.getRecipeCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of recipes in the group's recipe book
     * @return The array of recipes
     */
    public Recipe[] getRecipes() {
        return groupSubRecipeBook.getRecipes();
    }

    /**
     * Remove a recipe of a certain name from a group's recipe book
     * @param recipeName The name of the recipe we are removing
     */
    public void removeRecipe(String recipeName) {
        for (Recipe recipe : groupSubRecipeBook.getRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                groupSubRecipeBook.removeRecipe(recipe);
            }
        }
    }

    /**
     * Remove a recipe from a group's recipe book
     * @param recipe The recipe object representing the recipe we are removing
     */
    public void removeRecipe(Recipe recipe) {
        groupSubRecipeBook.removeRecipe(recipe);
    }
}

