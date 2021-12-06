package main.java.Entities;

import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Sorts.Sort;

import java.util.*;

/**
 *  A Recipe Book that stores a list of the sub recipe books for a user.
 *
 */
public class RecipeBook {
    public final ArrayList<SubRecipeBook> userSubRecipeBooks;

    /**
     * Instantiate the overall RecipeBook when a new User registers with the app and has an empty RecipeBook.
     *
     */
    public RecipeBook() {
        this.userSubRecipeBooks = new ArrayList<>();
        this.userSubRecipeBooks.add(new SubRecipeBook("AllRecipes",
                "a Recipe Book with all the recipes added by user"));
    }

    /**
     * Create a new SubRecipeBook in the overall RecipeBook with name - name and description - description.
     *
     * @param name        - name of sub-recipe book
     * @param description - description of sub-recipe book
     */
    public void addSubRecipeBook(String name, String description) {
        this.userSubRecipeBooks.add(new SubRecipeBook(name, description));
    }

    /**
     * Add a SubRecipeBook to the overall RecipeBook by providing a name.
     *
     * @param name - name of sub-recipe book
     */
    public void addSubRecipeBook(String name) {
        this.userSubRecipeBooks.add(new SubRecipeBook(name, " "));
    }

    /**
     * Add a SubRecipeBook to the user's overall RecipeBook.
     *
     * @param subRecipeBook - a sub- recipe book to be added
     */
    public void addSubRecipeBook(SubRecipeBook subRecipeBook) {
        userSubRecipeBooks.add(subRecipeBook);
    }


    /**
     * Remove a SubRecipeBook from the overall RecipeBook.
     *
     * @param subRecipeBook - the sub-recipe book to be deleted
     */
    public void removeSubRecipeBook(SubRecipeBook subRecipeBook) {
        userSubRecipeBooks.remove(subRecipeBook);
    }

    /**
     * Return a SubRecipeBook from the overall RecipeBook.
     *
     * @param subRecipeBook - the sub-recipe book to return
     * @return a SubRecipeBook
     */
    public SubRecipeBook showSubRecipeBook(SubRecipeBook subRecipeBook) {
        int subRecipeBookIndex = this.userSubRecipeBooks.indexOf(subRecipeBook);
        return this.userSubRecipeBooks.get(subRecipeBookIndex);
    }

    /**
     * Return a SubRecipeBook from the overall RecipeBook.
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
     * Return a list of all the SubRecipeBook.
     *
     * @return a list of the user's SubRecipeBooks in their overall RecipeBook
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return userSubRecipeBooks;
    }

    /**
     * Return all the Recipes the User has saved as a list.
     *
     * @return a list of the Recipes that a user has saved
     */
    public Recipe[] getAllRecipes() {
        return this.showSubRecipeBook("AllRecipes").getRecipes();
    }

    /**
     * Add a Recipe to SubRecipeBook requested and the sub-recipe book AllRecipes.
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

    /**
     * Remove the Recipe with recipeCode from the SubRecipeBook.
     *
     * @param subRecipeBookName - the sub-recipe book to remove the recipe from
     * @param recipeCode - a unique Integer code identifier for Recipe
     */
    public void removeRecipe(String subRecipeBookName, Integer recipeCode) {
        showSubRecipeBook(subRecipeBookName).removeRecipe(recipeCode);
        this.showSubRecipeBook("AllRecipes").removeRecipe(recipeCode);
    }

    /**
     * Return the codes of all Recipes in the User's SubRecipeBooks.
     *
     * @return - return the codes for recipes found in the user's recipe book.
     */
    public Integer[] getCodes() {
        return this.showSubRecipeBook("AllRecipes").getCodes();
    }

    /**
     * Retrieve the Recipe with recipeCode.
     *
     * @param recipeCode - a unique Integer code identifier for Recipe
     * @return - return the recipe with recipeCode
     */
    public Recipe getRecipe(Integer recipeCode) {
        return this.showSubRecipeBook("AllRecipes").getRecipe(recipeCode);
    }

    /**
     * Retrieve the Recipe with name - recipeName.
     *
     * @param recipeName - the name of the recipe to return
     * @return a Recipe object with name- recipeName
     */
    public Recipe getRecipe(String recipeName) {
        return this.showSubRecipeBook("AllRecipes").getRecipe(recipeName);
    }

    /**
     * Return the number of Recipes in the RecipeBook.
     *
     * @return an int indicating the number of recipes overall that the user has saved in their recipe book.
     */
    public int size() {
        return this.showSubRecipeBook("AllRecipes").size();
    }

    /**
     * Adds filter to a SubRecipeBook in the RecipeBook.
     * @param subRecipeBook name of the sub-recipe book.
     * @param filter instance of a filter that needs to be added.
     */
    public void addFilter(String subRecipeBook, Filter filter) {
        showSubRecipeBook(subRecipeBook).addFilter(filter);
    }

    /**
     * Remove filter from a SubRecipeBook in the RecipeBook.
     * @param subRecipeBook name of the sub-recipe book.
     * @param filter instance of a filter that needs to be removed.
     */
    public void removeFilter(String subRecipeBook, Filter filter) {
        showSubRecipeBook(subRecipeBook).removeFilter(filter);
    }

    /**
     * Sets sort to a SubRecipeBook in the RecipeBook.
     * @param subRecipeBook name of the sub-recipe book.
     * @param sort instance of a sort that needs to be set.
     */
    public void setSort(String subRecipeBook, Sort sort) {
        showSubRecipeBook(subRecipeBook).setSort(sort);
    }

    /**
     * Removes sort from a SubRecipeBook in the RecipeBook.
     * @param subRecipeBook name of the sub-recipe book.
     */
    public void removeSort(String subRecipeBook) {
        showSubRecipeBook(subRecipeBook).removeSort();
    }
  
  /**
     * Return all the ingredients in a user's RecipeBook and their frequencies.
     * @return a hashmap of ingredients and their frequencies.
     */
    public HashMap<String, Integer> getAllIngredients() {
        HashMap<String, Integer> ingredients = new HashMap<>();
        for (Recipe recipe : this.getAllRecipes()) {
            for (String ingredient : recipe.getIngredients()) {
                ingredients.put(ingredient, ingredients.get(ingredient) + 1);
            }
        }
        return ingredients;
    }

    /**
     * Return the top 10 ingredients in a user's RecipeBook.
     *
     * @return a list of the 10 most frequent ingredients in the SubRecipeBook.
     */

    public ArrayList<String> getTopIngredients() {
        ArrayList<Integer> values = new ArrayList<>(this.getAllIngredients().values());
        values.sort(Collections.reverseOrder());
        HashMap<String, Integer> top10Map = new HashMap<>();
        int limit = 0;
            for (Integer value : values) {
                if (limit < 11) {
                    limit ++;
                    for (String ingredient : this.getAllIngredients().keySet()) {
                    if (this.getAllIngredients().get(ingredient).equals(value)) {
                        top10Map.put(ingredient, value);
                        values.remove(value);
                        this.getAllIngredients().keySet().remove(ingredient);
                    }
                }
            }
                }
        return new ArrayList<>(top10Map.keySet());
    }
}
