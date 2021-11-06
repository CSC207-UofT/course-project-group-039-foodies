package test.java.SortTests;

import main.java.Entities.Recipe;
import main.java.Sorts.ServingsSort;
import main.java.UseCases.DatabaseManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ServingsSortTest {

    @Test
    public void testServingsSortTest() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("a");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("b");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("c");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe("food1", "Dessert", 5, ingre1, "Just.");
        manager.addRecipe("food2", "Lunch", 2, ingre2, "Do.");
        manager.addRecipe("food3", "Dinner", 7, ingre3, "It.");

        ServingsSort serv = new ServingsSort(manager.getRecipes());
        Recipe[] filtered = serv.sort();

        assertEquals(3, filtered.length);
        assertEquals("food2", filtered[0].getName());
        assertEquals("food1", filtered[1].getName());
        assertEquals("food3", filtered[2].getName());
    }
}
