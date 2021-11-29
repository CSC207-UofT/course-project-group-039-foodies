package test.java.FilterTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.FoodTypeFilter;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * A test class which tests FoodTypeFilter class.
 */
public class FoodTypeFilterTest {

    /**
     * Test FoodTypeFilter with three recipes which have all different food types.
     */
    @Test
    public void testFoodTypeFilter() {
        ArrayList<String> ingredient1 = new ArrayList<>();
        ingredient1.add("a");
        ArrayList<String> ingredient2 = new ArrayList<>();
        ingredient2.add("b");
        ingredient2.add("c");
        ArrayList<String> ingredient3 = new ArrayList<>();
        ingredient3.add("d");
        ingredient3.add("e");
        ingredient3.add("f");

        RecipeCollection recipes = new RecipeCollection();
        Recipe recipe0 = RecipeFactory.createRecipe
                ("Ice Cream", "Dessert", 1, ingredient1, "Cold.");
        Recipe recipe1 = RecipeFactory.createRecipe
                ("Hamburger", "Lunch", 2, ingredient2, "Build.");
        Recipe recipe2 = RecipeFactory.createRecipe
                ("Steak", "Dinner", 3, ingredient3, "Grill.");
        recipes.addRecipe(recipe0);
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);

        FoodTypeFilter foodType = new FoodTypeFilter("Dinner");
        Recipe[] filtered = foodType.filter(recipes.getRecipes());

        assertEquals(1, filtered.length);
        assertEquals("Steak", filtered[0].getName());
    }
}
