package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Entities.User;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *A public class which manages the activities of the OverallRecipeBook.
 */
 public class RecipeBookManager {
    RecipeBook overallRecipeBook;

    /**
     * Instantiate an overall recipe book manager for a particular user.
     */
    public RecipeBookManager(User user) {
        this.overallRecipeBook = user.getRecipeBook();}

    public RecipeBookManager(RecipeBook overallrecipebook) {
        this.overallRecipeBook = overallrecipebook;
    }

    /**
     * Return whether a subrecipebook of a certain name is contained in a user's overall recipe book
     * @param subrecipebookname The subrecipebook name we are looking for
     * @return True if and only if the user contains the subrecipebook
     */
    public boolean containsSubRecipeBook(String subrecipebookname) {
        for (SubRecipeBook subrecipebook : overallRecipeBook.getSubRecipeBooks()) {
            if (subrecipebook.getName().equals(subrecipebookname)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a subrecipebook of a certain name is contained in a user's overall recipe book
     * @param subrecipebookinterested The subrecipebook name we are looking for
     * @return True if and only if the user contains the subrecipebook
     */
    public boolean containsSubRecipeBook(SubRecipeBook subrecipebookinterested) {
        for (SubRecipeBook subrecipebook : overallRecipeBook.getSubRecipeBooks()) {
            if (subrecipebook.getName().equals(subrecipebookinterested.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the subrecipebook requested.
     * @param subrecipebookname - the name of the subrecipebook to return
     * @return the subrecipebook
     */
    public SubRecipeBook findsubrecipebook(String subrecipebookname) {
        return overallRecipeBook.showSubRecipeBook(subrecipebookname);
    }

    /**
     * Return a list of the subrecipe books for a user in the overall recipe book.
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return overallRecipeBook.getSubRecipeBooks();
    }

    /**
     * Remove a subrecipebook of a certain name from a user's recipe book
     * @param subrecipebookname The name of the recipe we are removing
     */
    public void removeSubRecipeBook(String subrecipebookname) {
        SubRecipeBook subrecipebooktoremove = overallRecipeBook.showSubRecipeBook(subrecipebookname);
        overallRecipeBook.removeSubRecipeBook(subrecipebooktoremove);
    }

    /**
     * Add a SubRecipeBook to the overall recipebook.
     * @param subrecipebookname the name of the subrecipebook to be added
     * @param subrecipebookdescription the description of the subrecipebook to be added
     */
    public void addSubRecipeBook(String subrecipebookname, String subrecipebookdescription) {
        overallRecipeBook.addSubRecipeBook(subrecipebookname, subrecipebookdescription);
    }


    public boolean containsRecipe(String recipeName) {
        for (Recipe recipe : overallRecipeBook.getAllRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a recipe object is contained in a user's recipe book
     * @param recipe The recipe name we are looking for
     * @return True if and only if the user contains the recipe
     */
    public boolean containsRecipe(Recipe recipe) {
        for (int code : overallRecipeBook.getCodes()) {
            if (code == recipe.getRecipeCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of recipes in the user's recipe book
     * @return The array of recipes
     */
    public Recipe[] getRecipes() {
        return overallRecipeBook.getAllRecipes();
    }

    /**
     * Remove a recipe of a certain name from a user's recipe book
     * @param recipeName The name of the recipe we are removing
     */
    public void removeRecipe(SubRecipeBook subrecipebook,String recipeName) {
        for (Recipe recipe : overallRecipeBook.getAllRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                overallRecipeBook.removeRecipe(subrecipebook, recipe.getRecipeCode());
            }
        }
    }

    /**
     * Remove a recipe from a user's recipe book
     * @param recipe The recipe object representing the recipe we are removing
     */
    public void removeRecipe(SubRecipeBook subrecipebook, Recipe recipe) {
        overallRecipeBook.removeRecipe(subrecipebook, recipe.getRecipeCode());
    }

    /**
     * Add a recipe to a user's recipe book
     * @param recipe The recipe object representing the recipe we are adding
     */
    public void addRecipe(SubRecipeBook subrecipebook, Recipe recipe) {
        overallRecipeBook.addRecipe(subrecipebook, recipe);
    }


    public void rateRecipe(User user, String recipeName, int rating) {}
}
