package test.java.FilterTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.Filters.FoodTypeFilter;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class FoodTypeFilterTest {

    @Test
    public void testFoodTypeFilter() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("a");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("b");
        ingre2.add("c");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("d");
        ingre3.add("e");
        ingre3.add("f");

        RecipeCollection recipes = new RecipeCollection();
        Recipe recipe0 = RecipeFactory.createRecipe
                ("Ice Cream", "Dessert", 1, ingre1, "Cold.");
        Recipe recipe1 = RecipeFactory.createRecipe
                ("Hamburger", "Lunch", 2, ingre2, "Build.");
        Recipe recipe2 = RecipeFactory.createRecipe
                ("Steak", "Dinner", 3, ingre3, "Grill.");
        recipes.addRecipe(recipe0);
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);

        FoodTypeFilter foodType = new FoodTypeFilter(recipes.getRecipes(), "Dinner");
        Recipe[] filtered = foodType.filter();

        assertEquals(1, filtered.length);
        assertEquals("Steak", filtered[0].getName());
    }
}
