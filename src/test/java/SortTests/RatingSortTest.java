package test.java.SortTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.Sorts.RatingSort;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class RatingSortTest {

    @Test
    public void testRatingSort() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("a");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("b");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("c");

        RecipeCollection recipes = new RecipeCollection();
        Recipe recipe1 = RecipeFactory.createRecipe
                ("food1", "Dessert", 3, ingre1, "Just.");
        Recipe recipe2 = RecipeFactory.createRecipe
                ("food2", "Lunch", 1, ingre2, "Do.");
        Recipe recipe3 = RecipeFactory.createRecipe
                ("food3", "Dinner", 2, ingre3, "It.");

        recipe1.addRating(1);
        recipe2.addRating(5);
        recipe3.addRating(3);

        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.addRecipe(recipe3);

        RatingSort ratings = new RatingSort();
        Recipe[] sorted = ratings.sort(recipes.getRecipes());

        assertEquals("food2", sorted[0].getName());
        assertEquals("food3", sorted[1].getName());
        assertEquals("food1", sorted[2].getName());
    }
}
