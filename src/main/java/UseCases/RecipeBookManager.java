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
     *
     * @param user - the user whose RecipeBook for which the RecipeBookManager is being instantiated
     */
    public RecipeBookManager(User user) {
        this.overallRecipeBook = user.getRecipeBook();}

    /**
     * Instantiate an overall recipe book manager for a particular RecipeBook
     *
     * @param overallRecipeBook - the RecipeBook for which the RecipeBookManager is instantiated for.
     */
    public RecipeBookManager(RecipeBook overallRecipeBook) {
        this.overallRecipeBook = overallRecipeBook;
    }

    /**
     * Return whether a SubRecipeBook of a certain name which is contained in a user's overall recipe book.
     *
     * @param subRecipeBookName - the name of the SubRecipeBook we are looking for
     * @return true if and only if the SubRecipeBook is in the RecipeBook and false otherwise
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
     * Return whether a SubRecipeBook of a certain name is contained in a user's overall RecipeBook.
     *
     * @param subRecipeBookInterested - the SubRecipeBook we are looking for
     * @return true if and only if the user contains the SubRecipeBook
     */
    public boolean containsSubRecipeBook(SubRecipeBook subRecipeBookInterested) {
        for (SubRecipeBook subRecipeBook : overallRecipeBook.getSubRecipeBooks()) {
            if (subRecipeBook.getName().equals(subRecipeBookInterested.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the SubRecipeBook with name requested.
     *
     * @param subRecipeBookName - the name of the SubRecipeBook to return
     * @return the SubRecipeBook requested
     */
    public SubRecipeBook findSubRecipeBook(String subRecipeBookName) {
        return overallRecipeBook.showSubRecipeBook(subRecipeBookName);
    }

    /**
     * Return a list of SubRecipeBook for a user in the overall RecipeBook.
     *
     * @return a list of SubRecipeBooks for a user
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return overallRecipeBook.getSubRecipeBooks();
    }

    /**
     * Remove a SubRecipeBook of a certain name from a user's RecipeBook.
     *
     * @param subRecipeBookName - the name of the SubRecipeBook we are removing
     */
    public void removeSubRecipeBook(String subRecipeBookName) {
        SubRecipeBook subRecipeBookToRemove = overallRecipeBook.showSubRecipeBook(subRecipeBookName);
        overallRecipeBook.removeSubRecipeBook(subRecipeBookToRemove);
    }

    /**
     * Add a SubRecipeBook to the overall RecipeBook.
     *
     * @param subRecipeBookName - the name of the SubRecipeBook to be added
     * @param subRecipeBookDescription -  the description of the SubRecipeBook to be added
     */
    public void addSubRecipeBook(String subRecipeBookName, String subRecipeBookDescription) {
        overallRecipeBook.addSubRecipeBook(subRecipeBookName, subRecipeBookDescription);
    }

    /**
     * Return whether a Recipe with recipeName is contained in a user's recipe book.
     *
     * @param recipeName - the name of the Recipe which we are searching for
     * @return true iff the recipe is found in the user's recipe book and false otherwise
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
     * Return whether a Recipe object is contained in a user's recipe book.
     *
     * @param recipe - the recipe we are looking for
     * @return true if and only if the user's recipe book contains the recipe and false otherwise
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
     * Return a list of recipes in the user's recipe book.
     *
     * @return the list of recipes found in a user's recipe book
     */
    public Recipe[] getRecipes() {
        return overallRecipeBook.getAllRecipes();
    }

    /**
     * Remove a recipe of a certain name from a user's recipe book.
     *
     * @param recipeName - the name of the recipe we are removing
     * @param subRecipeBookName - the name of the SubRecipeBook to remove the recipe from
     */
    public void removeRecipe(String subRecipeBookName,String recipeName) {
        for (Recipe recipe : overallRecipeBook.getAllRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                overallRecipeBook.removeRecipe(subRecipeBookName, recipe.getRecipeCode());
            }
        }
    }

    /**
     * Remove a recipe from a user's recipe book.
     *
     * @param recipe - the Recipe object representing the recipe we are removing
     * @param subRecipeBookName - name of the SubRecipeBook
     */
    public void removeRecipe(String subRecipeBookName, Recipe recipe) {
        overallRecipeBook.removeRecipe(subRecipeBookName, recipe.getRecipeCode());
    }

    /**
     * Add a recipe to a user's recipe book.
     *
     * @param subRecipeBookName - the name of the subrecipebook to which recipe is added
     * @param recipe The Recipe object representing the recipe we are adding
     */
    public void addRecipe(String subRecipeBookName, Recipe recipe) {
        overallRecipeBook.addRecipe(subRecipeBookName, recipe);
    }


//    public void rateRecipe(User user, String recipeName, int rating) {}
}
