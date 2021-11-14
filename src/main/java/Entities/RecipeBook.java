package main.java.Entities;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  A Recipe Book that stores a list of the sub-Recipe Books and an default subrecipe book
 *  to which all recipes are added.
 *
 */
public class RecipeBook {
    public final ArrayList<SubRecipeBook> usersubrecipebooks;
//    public final SubRecipeBook allrecipes;

    /**
     * Instantiate the overall recipe book when a new user registers with the app and has an empty recipe book.
     */
    public RecipeBook() {
        this.usersubrecipebooks = new ArrayList<>();
        this.usersubrecipebooks.add(new SubRecipeBook("allrecipes",
                "a recipebook with all the recipes ever added"));
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
     * Return a subrecipebook from the overall recipe book
     * @param subrecipebookname - the name of the subrecipebook to return.
     */
    public SubRecipeBook showSubRecipeBook(String subrecipebookname) {
        for (SubRecipeBook subrecipebook : usersubrecipebooks) {
            if (subrecipebook.getName().equals(subrecipebookname)) {
                return subrecipebook;
            }
        }
        return null;
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
        return this.showSubRecipeBook("allrecipes").getRecipes();
    }

    /**
     * Add a Recipe to subrecipebook requested and the subrecipebook allrecipes
     * @param subrecipebookname - the subrecipebook to add the recipe to
     * @param recipe - the Recipe to be added
     */
    public void addRecipe(String subrecipebookname, Recipe recipe) {
        showSubRecipeBook(subrecipebookname).addRecipe(recipe);
        this.showSubRecipeBook("allrecipes").addRecipe(recipe);
    }

    /**
     * Remove Recipe from allrecipes list.
     * @param subrecipebookname - subrecipebook from which the recipe is removed
     * @param recipe - the Recipe to be removed
     */
    public void removeRecipe(String subrecipebookname , Recipe recipe) {
        showSubRecipeBook(subrecipebookname).removeRecipe(recipe);
        this.showSubRecipeBook("allrecipes").removeRecipe(recipe);
    }

//    public void addRecipe(Integer recipecode, Recipe recipe) {
//        this.allrecipes.addRecipe(recipecode, recipe);
//    }


    /**
     * Remove the recipe with recipecode from the sub recipe book.
     * @param subrecipebookname - the subrecipebook to remove the recipe from
     * @param recipecode - a unique String code identifier for Recipe
     */
    public void removeRecipe(String subrecipebookname, Integer recipecode) {
        showSubRecipeBook(subrecipebookname).removeRecipe(recipecode);
        this.showSubRecipeBook("allrecipes").removeRecipe(recipecode);
    }

//    /**
//     * Return all recipes in the user's sub recipe book
//     *
//     * @return - return the recipes
//     */
//    public Recipe[] getRecipes() {
//        return allrecipes.getRecipes();
//    }

    /**
     * Return the codes of all recipes in the user's sub recipe book
     *
     * @return - return the codes
     */
    public Integer[] getCodes() {
        return this.showSubRecipeBook("allrecipes").getCodes();
    }

    /**
     * Retrieve the recipe with recipecode
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @return - return the recipe with recipecode
     */
    public Recipe getRecipe(Integer recipecode) {
        return this.showSubRecipeBook("allrecipes").getRecipe(recipecode);
    }

    /**
     * Retrieve the recipe with name name
     * @param recipename - the nanme of the recipe to return
     * @return a Recipe object with name name
     */
    public Recipe getRecipe(String recipename) {
        return this.showSubRecipeBook("allrecipes").getRecipe(recipename);
    }

    /**
     * Return the number of recipes in the recipebook.
     * @return an int indicating the number of recipes in the subrecipebook.
     */
    public int size() {
        return this.showSubRecipeBook("allrecipes").size();
    }


}

