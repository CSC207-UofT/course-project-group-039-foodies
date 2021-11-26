package main.java.UseCases.Factories;

import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;

public class RecipeBookFactory {
    public static RecipeBook createRecipeBook() {
        return new RecipeBook();
    }

    public static SubRecipeBook createSubRecipeBook(String name, String description) {
        return new SubRecipeBook(name, description);
    }
}
