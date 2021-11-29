package test.java.SortTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Sorts.ServingsSort;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Test class which tests ServingsSort class.
 */
public class ServingsSortTest {

    /**
     * Test ServingsSort with three recipes which have all different number of servings.
     */
    @Test
    public void testServingsSort() {
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
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.addRecipe(recipe3);

        ServingsSort servings = new ServingsSort();
        Recipe[] sorted = servings.sort(recipes.getRecipes());

        assertEquals("food2", sorted[0].getName());
        assertEquals("food3", sorted[1].getName());
        assertEquals("food1", sorted[2].getName());
    }
}
