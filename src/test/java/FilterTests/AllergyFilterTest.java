package test.java.FilterTests;

import main.java.Entities.Recipe;
import main.java.Filters.AllergyFilter;
import main.java.UseCases.DatabaseManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AllergyFilterTest {

    @Test
    public void testFoodTypeFilter() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("nut");
        ingre1.add("carrot");
        ingre1.add("bread");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("cucumber");
        ingre2.add("mango");
        ingre2.add("apple");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("eggplant");
        ingre3.add("egg");
        ingre3.add("oil");

        DatabaseManager manager = new DatabaseManager();
        manager.addRecipe("food1", "Dessert", 1, ingre1, "Just.");
        manager.addRecipe("food2", "Lunch", 2, ingre2, "Do.");
        manager.addRecipe("food3", "Dinner", 3, ingre3, "It.");

        AllergyFilter allergy = new AllergyFilter(manager.getRecipes(), "nut");
        Recipe[] filtered = allergy.filter();

        assertEquals(2, filtered.length);
        assertEquals("food2", filtered[0].getName());
        assertEquals("food3", filtered[1].getName());
    }
}
