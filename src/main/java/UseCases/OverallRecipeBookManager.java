package main.java.UseCases;

import main.java.Entities.Recipe;
import main.java.Entities.OverallRecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Entities.User;

import java.util.ArrayList;

/**
 *A public class which manages the activities of the OverallRecipeBook.
 */
 public class OverallRecipeBookManager {
    OverallRecipeBook overallRecipeBook;

    /**
     * Instantiate an overall recipe book manager for a particular user.
     */
    public OverallRecipeBookManager(User user) {
        this.overallRecipeBook = user.getRecipeBook();}

    public OverallRecipeBookManager(OverallRecipeBook overallrecipebook) {
        this.overallRecipeBook = overallrecipebook;
    }

    /**
     * Return whether a subrecipebook of a certain name is contained in a user's overall recipe book
     * @param subrecipebookname The subrecipebook name we are looking for
     * @return True if and only if the user contains the subrecipebook
     */
    public boolean containsSubRecipeBook(String subrecipebookname) {
        for (SubRecipeBook subrecipebook : overallRecipeBook.getSubRecipeBooks()) {
            if (subrecipebook.getName().equals(subrecipebookname)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether a subrecipebook of a certain name is contained in a user's overall recipe book
     * @param subrecipebookinterested The subrecipebook name we are looking for
     * @return True if and only if the user contains the subrecipebook
     */
    public boolean containsSubRecipeBook(SubRecipeBook subrecipebookinterested) {
        for (SubRecipeBook subrecipebook : overallRecipeBook.getSubRecipeBooks()) {
            if (subrecipebook.getName().equals(subrecipebookinterested.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of the subrecipe books for a user in the overall recipe book.
     */
    public ArrayList<SubRecipeBook> getSubRecipeBooks() {
        return overallRecipeBook.getSubRecipeBooks();
    }

    /**
     * Remove a subrecipebook of a certain name from a user's recipe book
     * @param subrecipebookname The name of the recipe we are removing
     */
    public void removeSubRecipeBook(String subrecipebookname) {
        for (SubRecipeBook subrecipebook: overallRecipeBook.getSubRecipeBooks()) {
            if (subrecipebook.getName().equals(subrecipebookname)) {
                overallRecipeBook.removeSubRecipeBook(subrecipebook);
            }
        }
    }

    /**
     * Add a SubRecipeBook to the overall recipebook.
     * @param subrecipebookname the name of the subrecipebook to be added
     * @param subrecipebookdescription the description of the subrecipebook to be added
     */
    public void addSubRecipeBook(String subrecipebookname, String subrecipebookdescription) {
        overallRecipeBook.addSubRecipeBook(subrecipebookname, subrecipebookdescription);
    }

}
