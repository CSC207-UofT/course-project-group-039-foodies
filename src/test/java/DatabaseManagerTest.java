package test.java;

import main.java.UseCases.DatabaseManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DatabaseManagerTest {

    @Test
    public void testDatabaseManagerAdd() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("a");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("b");
        ingre2.add("c");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("d");
        ingre3.add("e");
        ingre3.add("f");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe("Ice Cream", "Dessert", 1, ingre1, "Cold.");
        manager.addRecipe("Hamburger", "Lunch", 2, ingre2, "Build.");
        manager.addRecipe("Steak", "Dinner", 3, ingre3, "Grill.");

        assertTrue(manager.containsRecipe("Ice Cream"));
        assertTrue(manager.containsRecipe("Hamburger"));
        assertTrue(manager.containsRecipe("Steak"));
    }

    @Test
    public void testDatabaseManagerRemove() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("g");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("h");
        ingre2.add("i");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("j");
        ingre3.add("k");
        ingre3.add("l");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe("Ice Cream", "Dessert", 1, ingre1, "Cold.");
        manager.addRecipe("Hamburger", "Lunch", 2, ingre2, "Build.");
        manager.addRecipe("Steak", "Dinner", 3, ingre3, "Grill.");
        manager.removeRecipe("Hamburger");

        assertTrue(manager.containsRecipe("Ice Cream"));
        assertFalse(manager.containsRecipe("Hamburger"));
        assertTrue(manager.containsRecipe("Steak"));
    }

    @Test
    public void testDatabaseManagerHighest() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("m");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("n");
        ingre2.add("o");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("p");
        ingre3.add("q");
        ingre3.add("r");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe("Ice Cream", "Dessert", 1, ingre1, "Cold.");
        manager.addRecipe("Hamburger", "Lunch", 2, ingre2, "Build.");
        manager.addRecipe("Steak", "Dinner", 3, ingre3, "Grill.");
        manager.removeRecipe("Steak");

        Integer expected = 1;

        assertEquals(expected, manager.getHighest());
    }
}
