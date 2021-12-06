package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.GroupRecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Entities.GroupSubRecipeBook;
import main.java.Entities.User;
import main.java.Entities.Group;

import java.util.ArrayList;

/**
 *A public class which manages the group activities of the OverallRecipeBook.
 */
public class GroupRecipeBookManager {
    GroupRecipeBook overallGroupRecipeBook;

    /**
     * Instantiate an overall recipe book manager for a particular group.
     */
    public GroupRecipeBookManager(Group group) {
        this.overallGroupRecipeBook = group.getRecipeBook();}

    public GroupRecipeBookManager(GroupRecipeBook overallGroupRecipeBook) {
        this.overallGroupRecipeBook = overallGroupRecipeBook;
    }

    /**
     * Return whether a groupSubRecipeBook of a certain name is contained in a group's overall recipe book
     * @param SubRecipeBookName The groupSubRecipeBook name we are looking for
     * @return True if and only if the group contains the GroupSubRecipeBook
     */
    public boolean containsSubRecipeBook(String SubRecipeBookName) {
        for (GroupSubRecipeBook groupSubRecipeBook : overallGroupRecipeBook.getGroupSubRecipeBooks()) {
            if (groupSubRecipeBook.getName().equals(SubRecipeBookName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a groupSubRecipeBook of a certain name is contained in a group's overall recipe book
     * @param subRecipeBookInterested The groupSubRecipeBook name we are looking for
     * @return True if and only if the group contains the groupSubRecipeBook
     */
    public boolean containsSubRecipeBook(SubRecipeBook subRecipeBookInterested) {
        for (GroupSubRecipeBook groupSubRecipeBook : overallGroupRecipeBook.getGroupSubRecipeBooks()) {
            if (groupSubRecipeBook.getName().equals(subRecipeBookInterested.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the groupSubRecipeBook requested.
     * @param subRecipeBookName - the name of the subrecipebook to return
     * @return the GroupSubRecipeBook
     */
    public GroupSubRecipeBook findSubRecipeBook(String subRecipeBookName) {
        return overallGroupRecipeBook.showGroupSubRecipeBook(subRecipeBookName);
    }

    /**
     * Return a list of the subrecipe books for a user in the overall recipe book.
     */
    public ArrayList<GroupSubRecipeBook> getSubRecipeBooks() {
        return overallGroupRecipeBook.getGroupSubRecipeBooks();
    }

    /**
     * Remove a groupSubRecipeBook of a certain name from a group's recipe book
     * @param subRecipeBookName The name of the recipe we are removing
     */
    public void removeSubRecipeBook(String subRecipeBookName) {
        GroupSubRecipeBook subRecipeBook = overallGroupRecipeBook.showGroupSubRecipeBook(subRecipeBookName);
        overallGroupRecipeBook.removeGroupSubRecipeBook(subRecipeBook);
    }

    /**
     * Add a GroupSubRecipeBook to the overallGroupRecipeBook.
     * @param subRecipeBookName the name of the subRecipeBook to be added
     * @param subRecipeBookDescription the description of the subRecipeBook to be added
     */
    public void addSubRecipeBook(String subRecipeBookName, String subRecipeBookDescription) {
        overallGroupRecipeBook.addGroupSubRecipeBook(subRecipeBookName, subRecipeBookDescription);
    }


    public boolean containsRecipe(String recipeName) {
        for (Recipe recipe : overallGroupRecipeBook.getAllRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a recipe object is contained in a group's recipe book
     * @param recipe The recipe name we are looking for
     * @return True if and only if the group contains the recipe
     */
    public boolean containsRecipe(Recipe recipe) {
        for (int code : overallGroupRecipeBook.getCodes()) {
            if (code == recipe.getRecipeCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of recipes in the group's recipe book
     * @return The array of recipes
     */
    public Recipe[] getRecipes() {
        return overallGroupRecipeBook.getAllRecipes();
    }

    /**
     * Remove a recipe of a certain name from a group's recipe book
     * @param recipeName The name of the recipe we are removing
     * @param subRecipeBookName - The name of the subRecipeBook
     */
    public void removeRecipe(String subRecipeBookName,String recipeName) {
        for (Recipe recipe : overallGroupRecipeBook.getAllRecipes()) {
            if (recipe.getName().equals(recipeName)) {
                overallGroupRecipeBook.removeRecipe(subRecipeBookName, recipe.getRecipeCode());
            }
        }
    }

    /**
     * Remove a recipe from a group's recipe book
     * @param recipe The recipe object representing the recipe we are removing
     * @param subRecipeBookName - name of the subRecipeBook
     */
    public void removeRecipe(String subRecipeBookName, Recipe recipe) {
        overallGroupRecipeBook.removeRecipe(subRecipeBookName, recipe.getRecipeCode());
    }

    /**
     * Add a recipe to a group's recipe book
     * @param subRecipeBookName The name of the GroupSubRecipeBook to which recipe is added
     * @param recipe The recipe object representing the recipe we are adding
     */
    public void addRecipe(String subRecipeBookName, Recipe recipe) {
        overallGroupRecipeBook.addRecipe(subRecipeBookName, recipe);
    }


    public void rateRecipe(User user, String recipeName, int rating) {}
}
