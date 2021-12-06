package main.java.Entities;

import java.util.ArrayList;

/**
 *  A Group Recipe Book that stores a list of the Group sub-Recipe Books and a default subrecipe book
 *  to which all recipes are added.
 *
 */
public class GroupRecipeBook {
    public final ArrayList<GroupSubRecipeBook> groupSubRecipeBooks;


    /**
     * Instantiate the overall group recipe book when a new user registers with the app and
     * has an empty group recipe book.
     */
    public GroupRecipeBook() {
        this.groupSubRecipeBooks = new ArrayList<>();
        this.groupSubRecipeBooks.add(new GroupSubRecipeBook("allrecipes",
                "a recipebook with all the group recipes ever added"));
    }

    /**
     * Create a new group sub-recipe book in OverallRecipeBook with name and description description.
     * @param name        - name of subrecipe book
     * @param description - description of subrecipe book
     */
    public void addGroupSubRecipeBook(String name, String description) {
    }

    public void addGroupSubRecipeBook(String name) {
        this.groupSubRecipeBooks.add(new GroupSubRecipeBook(name,
                " "));
    }


    public void addSubRecipeBook(GroupSubRecipeBook groupSubRecipeBook) {
        groupSubRecipeBooks.add(groupSubRecipeBook);
    }


    public void removeGroupSubRecipeBook(GroupSubRecipeBook groupSubRecipeBook) {
        groupSubRecipeBooks.remove(groupSubRecipeBook);
    }


    public GroupSubRecipeBook showGroupSubRecipeBook(GroupSubRecipeBook groupSubRecipeBook) {
        int groupSubRecipeBookIndex = this.groupSubRecipeBooks.indexOf(groupSubRecipeBook);
        return this.groupSubRecipeBooks.get(groupSubRecipeBookIndex);
    }


    public GroupSubRecipeBook showGroupSubRecipeBook(String groupSubRecipeBookName) {
        for (GroupSubRecipeBook groupSubrecipebook : groupSubRecipeBooks) {
            if (groupSubrecipebook.getName().equals(groupSubRecipeBookName)) {
                return groupSubrecipebook;
            }
        }
        return null;
    }


    public ArrayList<GroupSubRecipeBook> getGroupSubRecipeBooks() {
        return groupSubRecipeBooks;
    }


    public Recipe[] getAllRecipes() {
        return this.showGroupSubRecipeBook(
                "allrecipes").getRecipes();
    }


    public void addRecipe(String subRecipeBookName, Recipe recipe) {
        showGroupSubRecipeBook(subRecipeBookName).addRecipe(recipe);
        this.showGroupSubRecipeBook("allrecipes").addRecipe(recipe);
    }


    public void removeRecipe(String subRecipeBookName , Recipe recipe) {
        showGroupSubRecipeBook(subRecipeBookName).removeRecipe(recipe);
        this.showGroupSubRecipeBook("allrecipes").removeRecipe(recipe);
    }


    public void removeRecipe(String subRecipeBookName, Integer recipecode) {
        showGroupSubRecipeBook(subRecipeBookName).removeRecipe(recipecode);
        this.showGroupSubRecipeBook("allrecipes").removeRecipe(recipecode);
    }


    public Integer[] getCodes() {
        return this.showGroupSubRecipeBook("allrecipes").getCodes();
    }


    public int size() {
        return this.showGroupSubRecipeBook("allrecipes").size();
    }

}

