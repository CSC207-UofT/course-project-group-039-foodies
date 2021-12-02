package test.java.FilterTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.AllergyFilter;
import main.java.UseCases.Factories.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class AllergyFilterTest {

    @Test
    public void testAllergyFilter() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("walnut");
        ingre1.add("carrot");
        ingre1.add("bread");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("cucumber");
        ingre2.add("mango");
        ingre2.add("apple");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("eggplant");
        ingre3.add("egg");
        ingre3.add("nut");

        RecipeCollection recipes = new RecipeCollection();
        Recipe recipe1 = RecipeFactory.createRecipe
                ("food1", "Dessert", 1, ingre1, "Just.");
        Recipe recipe2 = RecipeFactory.createRecipe
                ("food2", "Lunch", 2, ingre2, "Do.");
        Recipe recipe3 = RecipeFactory.createRecipe
                ("food3", "Dinner", 3, ingre3, "It.");
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
