package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Entities.User;

import java.util.ArrayList;

/**
 *A public class which manages the activities of the overall RecipeBook.
 */
 public class RecipeBookManager {
    RecipeBook overallRecipeBook;

    /**
     * Instantiate an overall recipe book manager for a particular User.
     */
    public RecipeBookManager(User user) {
        this.overallRecipeBook = user.getRecipeBook();
    }

    public RecipeBookManager(RecipeBook overallRecipeBook) {
        this.overallRecipeBook = overallRecipeBook;
    }

    /**
     * Return whether a SubRecipeBook of a certain name is contained in a User's overall RecipeBook.
     *
     * @param subRecipeBookName The name of the SubRecipeBook we are looking for
     * @return True if and only if the user contains the SubRecipeBook
     */
    public boolean containsSubRecipeBook(String subRecipeBookName) {
        for (SubRecipeBook subRecipeBook : overallRecipeBook.getSubRecipeBooks()) {
            if (subRecipeBook.getName().equals(subRecipeBookName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the SubRecipeBook requested.
     *
     * @param subRecipeBookName - the name of the SubRecipeBook to return
     * @return a SubRecipeBook
     */
    public SubRecipeBook findSubRecipeBook(String subRecipeBookName) {
        return overallRecipeBook.showSubRecipeBook(subRecipeBookName);
    }

    /**
     * Return a list of the SubRecipeBooks for a user in the overall RecipeBook.
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return overallRecipeBook.getSubRecipeBooks();
    }

    /**
     * Remove a SubRecipeBook of a certain name from a User's RecipeBook.
     *
     * @param subRecipeBookName The name of the sub-recipe book we are removing
     */
    public void removeSubRecipeBook(String subRecipeBookName) {
        SubRecipeBook subRecipeBookToRemove = overallRecipeBook.showSubRecipeBook(subRecipeBookName);
        overallRecipeBook.removeSubRecipeBook(subRecipeBookToRemove);
    }

    /**
     * Add a SubRecipeBook to the overall RecipeBook.
     *
     * @param subRecipeBookName        the name of the SubRecipeBook to be added
     * @param subRecipeBookDescription the description of the SubRecipeBook to be added
     */
    public void addSubRecipeBook(String subRecipeBookName, String subRecipeBookDescription) {
        overallRecipeBook.addSubRecipeBook(subRecipeBookName, subRecipeBookDescription);
    }

    /**
     * Check if a Recipe is found in the user's RecipeBook
     *
     * @param recipeName the name of the recipe
     * @return true iff the Recipe with name recipeName is found in the RecipeBook and false otherwise.
     */
    public boolean containsRecipe(String recipeName) {
        for (Recipe recipe : overallRecipeBook.getAllRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of Recipes in the user's RecipeBook.
     *
     * @return an Array of Recipes
     */
    public Recipe[] getRecipes() {
        return overallRecipeBook.getAllRecipes();
    }

    /**
     * Remove a Recipe of a certain name from a User's RecipeBook
     *
     * @param recipeName        The name of the recipe we are removing
     * @param subRecipeBookName - The name of the sub-recipe book
     */
    public void removeRecipe(String subRecipeBookName, String recipeName) {
        for (Recipe recipe : overallRecipeBook.getAllRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                overallRecipeBook.removeRecipe(subRecipeBookName, recipe.getRecipeCode());
            }
        }
    }

    /**
     * Remove a Recipe from a User's Recipe Book
     *
     * @param recipe            The recipe object representing the recipe we are removing
     * @param subRecipeBookName - name of the sub-recipe book
     */
    public void removeRecipe(String subRecipeBookName, Recipe recipe) {
        overallRecipeBook.removeRecipe(subRecipeBookName, recipe.getRecipeCode());
    }

    /**
     * Add a Recipe to a User's RecipeBook
     *
     * @param subRecipeBookName The name of the SubRecipeBook to which recipe is added
     * @param recipe            The recipe object representing the recipe we are adding
     */
    public void addRecipe(String subRecipeBookName, Recipe recipe) {
        overallRecipeBook.addRecipe(subRecipeBookName, recipe);
    }

}
