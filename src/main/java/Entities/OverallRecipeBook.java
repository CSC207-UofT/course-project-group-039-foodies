package main.java.Entities;

import java.util.ArrayList;

/**
 *  A Recipe Book that stores a list of the sub-Recipe Books.
 *
 */
public class OverallRecipeBook {
    public final ArrayList<SubRecipeBook> usersubrecipebooks;
    public final RecipeCollection allrecipes;

    /**
     * Instantiate the overall recipe book when a new user registers with the app and has an empty recipe book.
     */
    public OverallRecipeBook() {
        this.usersubrecipebooks = new ArrayList<>();
        this.allrecipes = new RecipeCollection();
    }

    /**
     * Create a new sub-recipe book in OverallRecipeBook with name name and description description.
     * @param name        - name of subrecipe book
     * @param description - description of subrecipe book
     */
    public void addSubRecipeBook(String name, String description) {
        this.usersubrecipebooks.add(new SubRecipeBook(name, description));
    }

    /**
     * Add a sub-recipe book to the overall recipe book by providing a name.
     * @param name - name of subrecipe book
     */
    public void addSubRecipeBook(String name) {
        this.usersubrecipebooks.add(new SubRecipeBook(name, " "));
    }

    /**
     * Remove a sub-recipe book from the overall recipe book.
     * @param subrecipebook - the sub-recipe book to be deleted.
     */
    public void removeSubRecipeBook(SubRecipeBook subrecipebook) {
        this.usersubrecipebooks.remove(subrecipebook);
    }

    /**
     * Return a sub-recipe book from the overall recipe book.
     * @param subrecipebook - the sub-recipe book to return
     */
    public SubRecipeBook showSubRecipeBook(SubRecipeBook subrecipebook) {
        int subrecipebookindex = this.usersubrecipebooks.indexOf(subrecipebook);
        return this.usersubrecipebooks.get(subrecipebookindex);
    }

    /**
     * Return a list of all the SubRecipeBooks
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return usersubrecipebooks;
    }

    /**
     * Return all the recipes the user has saved as a list.
     */
    public Recipe[] getallRecipes() {
        return this.allrecipes.getRecipes();
    }

    /**
     * Add a Recipe to allrecipes list
     * @param recipe - the Recipe to be added
     */
    public void addRecipetoallrecipes(Recipe recipe) {
        allrecipes.addRecipe(recipe);
    }

    /**
     * Remove Recipe from allrecipes list.
     * @param recipe - the Recipe to be removed
     */
    public void removeRecipefromallrecipes(Recipe recipe) {
        allrecipes.removeRecipe(recipe);
    }
}

