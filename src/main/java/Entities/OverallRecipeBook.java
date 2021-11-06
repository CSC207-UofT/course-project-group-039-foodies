package main.java.Entities;

import java.util.ArrayList;

/**
 *  A Recipe Book that stores a list of the sub-Recipe Books.
 *
 */
public class OverallRecipeBook {
    public final ArrayList<SubRecipeBook> usersubrecipebooks;

    /**
     * Instantiate the overall recipe book when a new user registers with the app and has an empty recipe book.
     */
    public OverallRecipeBook() {
        this.usersubrecipebooks = new ArrayList<>();
    }

    /**
     * Create a new sub-recipe book in OverallRecipeBook with name name and description description.
     * @param name - name of subrecipe book
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
        this.usersubrecipebooks.add(new SubRecipeBook(name , " "));
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
    public SubRecipeBook showSubRecipeBook(SubRecipeBook subrecipebook ) {
        int subrecipebookindex = this.usersubrecipebooks.indexOf(subrecipebook);
        return this.usersubrecipebooks.get(subrecipebookindex);
        }


    }

