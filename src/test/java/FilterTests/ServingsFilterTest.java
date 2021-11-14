package test.java.FilterTests;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.ServingsFilter;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ServingsFilterTest {

    @Test
    public void testServingsFilter() {
        ArrayList<String> ingre1 = new ArrayList<>();
        ingre1.add("a");
        ArrayList<String> ingre2 = new ArrayList<>();
        ingre2.add("b");
        ArrayList<String> ingre3 = new ArrayList<>();
        ingre3.add("c");

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

        ServingsFilter servings = new ServingsFilter(2);
        Recipe[] filtered = servings.filter(recipes.getRecipes());

        assertEquals(1, filtered.length);
        assertEquals("food2", filtered[0].getName());
    }
}
