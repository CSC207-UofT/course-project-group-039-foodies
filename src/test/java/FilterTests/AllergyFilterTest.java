package test.java.FilterTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.AllergyFilter;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Test class which tests AllergyFilter class.
 */
public class AllergyFilterTest {

    /**
     * Test AllergyFilter with three recipes which contains three ingredients each.
     */
    @Test
    public void testAllergyFilter() {
        ArrayList<String> ingredient1 = new ArrayList<>();
        ingredient1.add("walnut");
        ingredient1.add("carrot");
        ingredient1.add("bread");
        ArrayList<String> ingredient2 = new ArrayList<>();
        ingredient2.add("cucumber");
        ingredient2.add("mango");
        ingredient2.add("apple");
        ArrayList<String> ingredient3 = new ArrayList<>();
        ingredient3.add("eggplant");
        ingredient3.add("egg");
        ingredient3.add("nut");

        RecipeCollection recipes = new RecipeCollection();
        Recipe recipe1 = RecipeFactory.createRecipe
                ("food1", "Dessert", 1, ingredient1, "Just.");
        Recipe recipe2 = RecipeFactory.createRecipe
                ("food2", "Lunch", 2, ingredient2, "Do.");
        Recipe recipe3 = RecipeFactory.createRecipe
                ("food3", "Dinner", 3, ingredient3, "It.");
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.addRecipe(recipe3);


        AllergyFilter allergy = new AllergyFilter("nut");
        Recipe[] filtered = allergy.filter(recipes.getRecipes());

        assertEquals(2, filtered.length);
        assertEquals("food1", filtered[0].getName());
        assertEquals("food2", filtered[1].getName());
    }
}
