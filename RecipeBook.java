package main.java.Entities;

import java.util.ArrayList;

/**
 *  A Recipe Book that stores a list of the sub-Recipe Books.
 *
 */
public class RecipeBook {
    public final ArrayList<SubRecipeBook> usersubrecipebooks;
    public final SubRecipeBook allrecipes;

    /**
     * Instantiate the overall recipe book when a new user registers with the app and has an empty recipe book.
     */
    public RecipeBook() {
        this.usersubrecipebooks = new ArrayList<>();
        this.allrecipes = new SubRecipeBook();
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
     * Adds a subrecipebook to the user's list of subrecipebooks
     * @param subrecipebook - a subrecipe book to be added
     */
    public void addSubRecipeBook(SubRecipeBook subrecipebook) {
        usersubrecipebooks.add(subrecipebook);
    }

    /**
     * Remove a sub-recipe book from the overall recipe book.
     * @param subrecipebook - the sub-recipe book to be deleted.
     */
    public void removeSubRecipeBook(SubRecipeBook subrecipebook) {
        usersubrecipebooks.remove(subrecipebook);
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
    public Recipe[] getAllRecipes() {
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
    public void removeRecipefromAllRecipes(Recipe recipe) {
        allrecipes.removeRecipe(recipe);
    }

    public void addRecipe(Integer recipecode, Recipe recipe) {
        this.allrecipes.addRecipe(recipecode, recipe);
    }

    /**
     * Add a Recipe object to the subrecipebook
     *
     * @param recipe - the recipe object to be added
     */
    public void addRecipe(Recipe recipe) {
        this.allrecipes.addRecipe(recipe);
    }

    /**
     * Remove the recipe with recipecode from the sub recipe book.
     *
     * @param recipecode - a unique String code identifier for Recipe
     */
    public void removeRecipe(Integer recipecode) {
        this.allrecipes.removeRecipe(recipecode);
    }

    /**
     * Remove a recipe from the subrecipebook
     *
     * @param recipe - the recipe to delete
     */
    public void removeRecipe(Recipe recipe) {
        removeRecipe(recipe.getRecipeCode());
    }

    /**
     * Return all recipes in the user's sub recipe book
     *
     * @return - return the recipes
     */
    public Recipe[] getRecipes() {
        return allrecipes.getRecipes();
    }

    /**
     * Return the codes of all recipes in the user's sub recipe book
     *
     * @return - return the codes
     */
    public Integer[] getCodes() {
        return allrecipes.getCodes();
    }

    /**
     * Retrieve the recipe with recipecode
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @return - return the recipe with recipecode
     */
    public Recipe getRecipe(Integer recipecode) {
        return this.allrecipes.getRecipe(recipecode);
    }

    /**
     * Retrieve the recipe with name name
     * @param recipename - the nanme of the recipe to return
     * @return a Recipe object with name name
     */
    public Recipe getRecipe(String recipename) {
        return this.allrecipes.getRecipe(recipename);
    }

    /**
     * Return the number of recipes in the subrecipebook.
     * @return an int indicating the number of recipes in the subrecipebook.
     */
    public int size() {
        return this.allrecipes.size();
    }


}

