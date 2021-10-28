package test;

import main.java.DatabaseManager;
import main.java.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

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

        Recipe recipe1 = new Recipe(1, "Ice Cream", "Dessert", 1, ingre1, "Cold.");
        Recipe recipe2 = new Recipe(2, "Hamburger", "Lunch", 2, ingre2, "Build.");
        Recipe recipe3 = new Recipe(3, "Steak", "Dinner", 3, ingre3, "Grill.");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        manager.addRecipe(recipe3);

        HashMap<Integer, Recipe> expected = new HashMap<>();
        expected.put(0, recipe1);
        expected.put(1, recipe2);
        expected.put(2, recipe3);

        assertEquals(expected, manager.dataMap);
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

        Recipe recipe1 = new Recipe(1, "Ice Cream", "Dessert", 1, ingre1, "Cold.");
        Recipe recipe2 = new Recipe(2, "Hamburger", "Lunch", 2, ingre2, "Build.");
        Recipe recipe3 = new Recipe(3, "Steak", "Dinner", 3, ingre3, "Grill.");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        manager.addRecipe(recipe3);
        manager.removeRecipe(recipe2);

        HashMap<Integer, Recipe> expected = new HashMap<>();
        expected.put(0, recipe1);
        expected.put(2, recipe3);

        assertEquals(expected, manager.dataMap);
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

        Recipe recipe1 = new Recipe(1, "Ice Cream", "Dessert", 1, ingre1, "Cold.");
        Recipe recipe2 = new Recipe(2, "Hamburger", "Lunch", 2, ingre2, "Build.");
        Recipe recipe3 = new Recipe(3, "Steak", "Dinner", 3, ingre3, "Grill.");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        manager.addRecipe(recipe3);
        manager.removeRecipe(recipe3);

        Integer expected = 1;

        assertEquals(expected, manager.getHighest());
    }
}