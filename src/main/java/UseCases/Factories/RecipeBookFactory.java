package main.java.UseCases.Factories;

import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;

public class RecipeBookFactory {
    /**
     * Create a new, empty RecipeBook
     * @return A RecipeBook
     */
    public static RecipeBook createRecipeBook() {
        return new RecipeBook();
    }

    /**
     * Create a new, empty subRecipeBook
     * @param name The name of the subRecipeBook
     * @param description The description of the subRecipeBook
     * @return A SubRecipeBook
     */
    public static SubRecipeBook createSubRecipeBook(String name, String description) {
        return new SubRecipeBook(name, description);
    }
}
