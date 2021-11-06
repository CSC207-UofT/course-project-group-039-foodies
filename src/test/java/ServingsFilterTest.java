package test.java;

import main.java.Entities.Recipe;
import main.java.Filters.ServingsFilter;
import main.java.UseCases.DatabaseManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ServingsFilterTest {

    @Test
    public void testFoodTypeFilter() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("a");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("b");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("c");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe("food1", "Dessert", 1, ingre1, "Just.");
        manager.addRecipe("food2", "Lunch", 2, ingre2, "Do.");
        manager.addRecipe("food3", "Dinner", 3, ingre3, "It.");

        ServingsFilter servings = new ServingsFilter(manager.getRecipes(), 2);
        Recipe[] filtered = servings.filter();

        assertEquals(1, filtered.length);
        assertEquals("food2", filtered[0].getName());
    }
}
