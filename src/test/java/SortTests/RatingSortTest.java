package test.java.SortTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Sorts.RatingSort;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Test class which tests RatingSort class.
 */
public class RatingSortTest {

    /**
     * Test RatingSort with three recipes which have all different ratings.
     */
    @Test
    public void testRatingSort() {
        ArrayList<String> ingredient1 = new ArrayList<>();
        ingredient1.add("a");
        ArrayList<String> ingredient2 = new ArrayList<>();
        ingredient2.add("b");
        ArrayList<String> ingredient3 = new ArrayList<>();
        ingredient3.add("c");

        RecipeCollection recipes = new RecipeCollection();
        Recipe recipe1 = RecipeFactory.createRecipe
                ("food1", "Dessert", 3, ingredient1, "Just.");
        Recipe recipe2 = RecipeFactory.createRecipe
                ("food2", "Lunch", 1, ingredient2, "Do.");
        Recipe recipe3 = RecipeFactory.createRecipe
                ("food3", "Dinner", 2, ingredient3, "It.");

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
