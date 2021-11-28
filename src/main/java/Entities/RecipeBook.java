package main.java.Entities;

import java.util.ArrayList;

/**
 *  A Recipe Book that stores a list of the sub recipe books for a user.
 *
 */
public class RecipeBook {
    public final ArrayList<SubRecipeBook> userSubRecipeBooks;

    /**
     * Instantiate the overall recipe book when a new user registers with the app and has an empty recipe book.
     *
     */
    public RecipeBook() {
        this.userSubRecipeBooks = new ArrayList<>();
        this.userSubRecipeBooks.add(new SubRecipeBook("AllRecipes",
                "a Recipe Book with all the recipes added by user"));
    }

    /**
     * Create a new sub-recipe book in the overall recipe book with name - name and description - description.
     *
     * @param name        - name of sub-recipe book
     * @param description - description of sub-recipe book
     */
    public void addSubRecipeBook(String name, String description) {
        this.userSubRecipeBooks.add(new SubRecipeBook(name, description));
    }

    /**
     * Add a sub-recipe book to the overall recipe book by providing a name.
     *
     * @param name - name of sub-recipe book
     */
    public void addSubRecipeBook(String name) {
        this.userSubRecipeBooks.add(new SubRecipeBook(name, " "));
    }

    /**
     * Add a sub-recipe book to the user's overall recipe book.
     *
     * @param subRecipeBook - a sub- recipe book to be added
     */
    public void addSubRecipeBook(SubRecipeBook subRecipeBook) {
        userSubRecipeBooks.add(subRecipeBook);
    }


    /**
     * Remove a sub-recipe book from the overall recipe book.
     *
     * @param subRecipeBook - the sub-recipe book to be deleted
     */
    public void removeSubRecipeBook(SubRecipeBook subRecipeBook) {
        userSubRecipeBooks.remove(subRecipeBook);
    }

    /**
     * Return a sub-recipe book from the overall recipe book.
     *
     * @param subRecipeBook - the sub-recipe book to return
     * @return a SubRecipeBook
     */
    public SubRecipeBook showSubRecipeBook(SubRecipeBook subRecipeBook) {
        int subRecipeBookIndex = this.userSubRecipeBooks.indexOf(subRecipeBook);
        return this.userSubRecipeBooks.get(subRecipeBookIndex);
    }

    /**
     * Return a sub-recipe book from the overall recipe book.
     *
     * @param subRecipeBookName - the name of the sub-recipe book to return
     * @return a SubRecipeBook
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
     * Return a list of all the sub-recipe books.
     *
     * @return a list of the user's SubRecipeBooks in their overall recipe book
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return userSubRecipeBooks;
    }

    /**
     * Return all the recipes the user has saved as a list.
     *
     * @return a list of the Recipes that a user has saved
     */
    public Recipe[] getAllRecipes() {
        return this.showSubRecipeBook("AllRecipes").getRecipes();
    }

    /**
     * Add a recipe to sub-recipe book requested and the sub-recipe book AllRecipes.
     *
     * @param subRecipeBookName - the sub-recipe book to add the recipe to
     * @param recipe - the Recipe to be added
     */
    public void addRecipe(String subRecipeBookName, Recipe recipe) {
        showSubRecipeBook(subRecipeBookName).addRecipe(recipe);
        this.showSubRecipeBook("AllRecipes").addRecipe(recipe);
    }

    /**
     * Remove Recipe - recipe from a SubRecipeBook with name subRecipeBookName.
     *
     * @param subRecipeBookName - sub-recipe book from which the recipe is removed
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
     * Remove the recipe with recipeCode from the sub-recipe book.
     *
     * @param subRecipeBookName - the sub-recipe book to remove the recipe from
     * @param recipeCode - a unique Integer code identifier for Recipe
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
     * Return the codes of all recipes in the user's sub-recipe book.
     *
     * @return - return the codes for recipes found in the user's recipe book.
     */
    public Integer[] getCodes() {
        return this.showSubRecipeBook("AllRecipes").getCodes();
    }

    /**
     * Retrieve the recipe with recipeCode.
     *
     * @param recipeCode - a unique Integer code identifier for Recipe
     * @return - return the recipe with recipeCode
     */
    public Recipe getRecipe(Integer recipeCode) {
        return this.showSubRecipeBook("AllRecipes").getRecipe(recipeCode);
    }

    /**
     * Retrieve the recipe with name - recipeName.
     *
     * @param recipeName - the name of the recipe to return
     * @return a Recipe object with name- recipeName
     */
    public Recipe getRecipe(String recipeName) {
        return this.showSubRecipeBook("AllRecipes").getRecipe(recipeName);
    }

    /**
     * Return the number of recipes in the recipe book.
     *
     * @return an int indicating the number of recipes overall that the user has saved in their recipe book.
     */
    public int size() {
        return this.showSubRecipeBook("AllRecipes").size();
    }


}

