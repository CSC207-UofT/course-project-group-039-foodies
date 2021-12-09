package main.java.Entities;

import java.util.ArrayList;


/**
 *  A Group Recipe Book that stores a list of the Group sub-Recipe Books and a default subrecipe book
 *  to which all recipes are added.
 */
public class GroupRecipeBook {
    public final ArrayList<GroupSubRecipeBook> groupSubRecipeBooks;


    /**
     * Instantiate the overall group recipe book when a new user registers with the app and
     * has an empty group recipe book.
     */
    public GroupRecipeBook() {
        this.groupSubRecipeBooks = new ArrayList<>();
        this.groupSubRecipeBooks.add(new GroupSubRecipeBook("AllRecipes",
                "a recipebook with all the group recipes ever added"));
    }


    /**
     * Create a new group sub-recipe book in OverallRecipeBook with name and description description.
     * @param name        - name of subrecipe book
     * @param description - description of subrecipe book
     */
    public void addGroupSubRecipeBook(String name, String description) {
        this.groupSubRecipeBooks.add(new GroupSubRecipeBook(name, description));
    }


    /**
     * Adds a new GroupSubRecipeBook
     * @param name The name of the new GroupSubRecipeBook
     */
    public void addGroupSubRecipeBook(String name) {
        this.groupSubRecipeBooks.add(new GroupSubRecipeBook(name,
                " "));
    }

    /**
     * Adds a new GroupSubRecipeBook
     * @param groupSubRecipeBook The GroupSubRecipeBook object
     */
    public void addGroupSubRecipeBook(GroupSubRecipeBook groupSubRecipeBook) {
        groupSubRecipeBooks.add(groupSubRecipeBook);
    }


    /**
     * Removes a GroupSubRecipeBook
     * @param groupSubRecipeBook The GroupSubRecipeBook object
     */
    public void removeGroupSubRecipeBook(GroupSubRecipeBook groupSubRecipeBook) {
        groupSubRecipeBooks.remove(groupSubRecipeBook);
    }


    /**
     * A getter for a GroupSubRecipeBook
     * @param groupSubRecipeBookName The name of the GroupSubRecipeBook
     * @return The GroupSubRecipeBook with the name groupSubRecipeBookName
     */
    public GroupSubRecipeBook showGroupSubRecipeBook(String groupSubRecipeBookName) {
        for (GroupSubRecipeBook groupSubrecipebook : groupSubRecipeBooks) {
            if (groupSubrecipebook.getName().equals(groupSubRecipeBookName)) {
                return groupSubrecipebook;
            }
        }
        return null;
    }


    /**
     * Returns all the GroupSubRecipeBooks
     * @return An arraylist of all GroupSubRecipeBooks
     */
    public ArrayList<GroupSubRecipeBook> getGroupSubRecipeBooks() {
        return groupSubRecipeBooks;
    }


    /**
     * Returns all recipes in the AllRecipes GroupSubRecipeBook
     * @return An array of all recipes
     */
    public Recipe[] getAllRecipes() {
        return this.showGroupSubRecipeBook(
                "AllRecipes").getRecipes();
    }


    /**
     * Adds a Recipe to a GroupSubRecipeBook
     * @param groupSubRecipeBookName The name of the GroupSubRecipeBook
     * @param recipe The recipe to add
     */
    public void addRecipe(String groupSubRecipeBookName, Recipe recipe) {
        showGroupSubRecipeBook(groupSubRecipeBookName).addRecipe(recipe);
        this.showGroupSubRecipeBook("AllRecipes").addRecipe(recipe);
    }


    /**
     * Removes a Recipe from a GroupSubRecipeBook
     * @param groupSubRecipeBookName The name of the GroupSubRecipeBook
     * @param recipe The recipe to remove
     */
    public void removeRecipe(String groupSubRecipeBookName, Recipe recipe) {
        showGroupSubRecipeBook(groupSubRecipeBookName).removeRecipe(recipe);
        this.showGroupSubRecipeBook("AllRecipes").removeRecipe(recipe);
    }


    /**
     * Removes a Recipe from a GroupSubRecipeBook
     * @param groupSubRecipeBookName The name of the GroupSubRecipeBook
     * @param recipeCode The code of the Recipe to remove
     */
    public void removeRecipe(String groupSubRecipeBookName, Integer recipeCode) {
        showGroupSubRecipeBook(groupSubRecipeBookName).removeRecipe(recipeCode);
        this.showGroupSubRecipeBook("AllRecipes").removeRecipe(recipeCode);
    }


    /**
     * Returns the recipe codes of all Recipes in all the GroupSubRecipeBooks
     * @return An array of codes
     */
    public Integer[] getCodes() {
        return this.showGroupSubRecipeBook("AllRecipes").getCodes();
    }


    /**
     * Returns the number of recipes stored
     * @return The size
     */
    public int size() {
        return this.showGroupSubRecipeBook("AllRecipes").size();
    }
}
