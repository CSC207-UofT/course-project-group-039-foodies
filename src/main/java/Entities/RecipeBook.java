package main.java.Entities;

import java.util.ArrayList;

/**
 *  A RecipeBook that stores a list of the SubRecipeBooks for a User
 */
public class RecipeBook {
    public final ArrayList<SubRecipeBook> userSubRecipeBooks;
//    public final SubRecipeBook allrecipes;

    /**
     * Instantiate the overall RecipeBook when a new user registers with the app and has an empty recipe book.
     */
    public RecipeBook() {
        this.userSubRecipeBooks = new ArrayList<>();
        this.userSubRecipeBooks.add(new SubRecipeBook("AllRecipes",
                "a RecipeBook with all the recipes ever added"));
    }

    /**
     * Create a new SubRecipeBook in OverallRecipeBook with name and description.
     * @param name        - name of SubRecipeBook
     * @param description - description of SubRecipeBook
     */
    public void addSubRecipeBook(String name, String description) {
        this.userSubRecipeBooks.add(new SubRecipeBook(name, description));
    }

    /**
     * Add a SubRecipeBook to the overall RecipeBook by providing a name.
     * @param name - name of SubRecipeBook
     */
    public void addSubRecipeBook(String name) {
        this.userSubRecipeBooks.add(new SubRecipeBook(name, " "));
    }

    /**
     * Add a SubRecipeBook to the user's list of SubRecipeBooks.
     * @param subRecipeBook - a SubRecipeBook to be added
     */
    public void addSubRecipeBook(SubRecipeBook subRecipeBook) {
        userSubRecipeBooks.add(subRecipeBook);
    }

    /**
     * Remove a SubRecipeBook from the overall RecipeBook.
     * @param subRecipeBook - the SubRecipeBook to be deleted
     */
    public void removeSubRecipeBook(SubRecipeBook subRecipeBook) {
        userSubRecipeBooks.remove(subRecipeBook);
    }

    /**
     * Return a SubRecipeBook from the overall RecipeBook.
     * @param subRecipeBook - the SubRecipeBook to return
     * @return the SubRecipeBook that was requested
     */
    public SubRecipeBook showSubRecipeBook(SubRecipeBook subRecipeBook) {
        int subRecipeBookIndex = this.userSubRecipeBooks.indexOf(subRecipeBook);
        return this.userSubRecipeBooks.get(subRecipeBookIndex);
    }

    /**
     * Return a SubRecipeBook from the overall RecipeBook.
     * @param subRecipeBookName - the name of the SubRecipeBook to return.
     * @return the SubRecipeBook that was requested
     */
    public SubRecipeBook showSubRecipeBook(String subRecipeBookName) {
        for (SubRecipeBook subRecipeBook : userSubRecipeBooks) {
            if (subRecipeBook.getName().equals(subRecipeBookName)) {
                return subRecipeBook;
            }
        }
        return null;
    }

    /**
     * Return a list of all the SubRecipeBooks for a user.
     * @return a list of the SubRecipeBooks for a user
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return userSubRecipeBooks;
    }

    /**
     * Return all the recipes the user has saved.
     * @return all the user's saved Recipes
     */
    public Recipe[] getAllRecipes() {
        return this.showSubRecipeBook("AllRecipes").getRecipes();
    }

    /**
     * Add a Recipe to the SubRecipeBook requested and the SubRecipeBook AllRecipes
     * @param subRecipeBookName - the SubRecipeBook to add the Recipe to
     * @param recipe - the Recipe to be added
     */
    public void addRecipe(String subRecipeBookName, Recipe recipe) {
        showSubRecipeBook(subRecipeBookName).addRecipe(recipe);
        this.showSubRecipeBook("AllRecipes").addRecipe(recipe);
    }

    /**
     * Remove a Recipe from the AllRecipes list.
     * @param subRecipeBookName - SubRecipeBook from which the recipe is removed
     * @param recipe - the Recipe to be removed
     */
    public void removeRecipe(String subRecipeBookName , Recipe recipe) {
        showSubRecipeBook(subRecipeBookName).removeRecipe(recipe);
        this.showSubRecipeBook("AllRecipes").removeRecipe(recipe);
    }

//    public void addRecipe(Integer recipecode, Recipe recipe) {
//        this.allrecipes.addRecipe(recipecode, recipe);
//    }


    /**
     * Remove the Recipe with recipeCode from the SubRecipeBook and AllRecipes SubRecipeBook.
     * @param subRecipeBookName - the SubRecipeBook to remove the Recipe from
     * @param recipeCode - a unique String code identifier for Recipe
     */
    public void removeRecipe(String subRecipeBookName, Integer recipeCode) {
        showSubRecipeBook(subRecipeBookName).removeRecipe(recipeCode);
        this.showSubRecipeBook("AllRecipes").removeRecipe(recipeCode);
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
     * Return the codes of all Recipes in the user's SubRecipeBook
     *
     * @return - return the codes for Recipes in a user's SubRecipeBook
     */
    public Integer[] getCodes() {
        return this.showSubRecipeBook("AllRecipes").getCodes();
    }

    /**
     * Retrieve the Recipe with recipeCode
     *
     * @param recipeCode - a unique String code identifier for Recipe
     * @return - return the recipe with recipecode
     */
    public Recipe getRecipe(Integer recipeCode) {
        return this.showSubRecipeBook("AllRecipes").getRecipe(recipeCode);
    }

    /**
     * Retrieve the recipe with the name - name
     * @param recipeName - the name of the recipe to return
     * @return a Recipe object with the name - name
     */
    public Recipe getRecipe(String recipeName) {
        return this.showSubRecipeBook("AllRecipes").getRecipe(recipeName);
    }

    /**
     * Return the number of recipes in the RecipeBook.
     * @return the number of recipes stored.
     */
    public int size() {
        return this.showSubRecipeBook("AllRecipes").size();
    }

}

