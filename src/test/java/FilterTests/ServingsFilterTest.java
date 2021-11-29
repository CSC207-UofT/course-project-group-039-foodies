package test.java.FilterTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.ServingsFilter;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Test class which tests ServingsFilter class.
 */
public class ServingsFilterTest {

    /**
     * Test ServingsFilter with three recipes which have all different number of servings.
     */
    @Test
    public void testServingsFilter() {
        ArrayList<String> ingredient1 = new ArrayList<>();
        ingredient1.add("a");
        ArrayList<String> ingredient2 = new ArrayList<>();
        ingredient2.add("b");
        ArrayList<String> ingredient3 = new ArrayList<>();
        ingredient3.add("c");

        RecipeCollection recipes = new RecipeCollection();
        Recipe recipe1 = RecipeFactory.createRecipe
                ("food1", "Dinner", 1, ingredient1, "Just.");
        Recipe recipe2 = RecipeFactory.createRecipe
                ("food2", "Lunch", 2, ingredient2, "Do.");
        Recipe recipe3 = RecipeFactory.createRecipe
                ("food3", "Breakfast", 3, ingredient3, "It.");
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.addRecipe(recipe3);

        ServingsFilter servings = new ServingsFilter(2);
        Recipe[] filtered = servings.filter(recipes.getRecipes());

        assertEquals(1, filtered.length);
        assertEquals("food2", filtered[0].getName());
    }
}
