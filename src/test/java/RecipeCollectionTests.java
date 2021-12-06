package test.java;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.FoodTypeFilter;
import main.java.UseCases.RecipeFactory;
import main.java.UseCases.Sorts.ServingsSort;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

public class RecipeCollectionTests {
    private RecipeCollection recipes = new RecipeCollection();
    private final Recipe recipe0 = RecipeFactory.createRecipe("test0", "type0", 10, new ArrayList<>(), "test");
    private final Recipe recipe1 = RecipeFactory.createRecipe("test1", "type1", 5, new ArrayList<>(), "test");
    private final Recipe recipe2 = RecipeFactory.createRecipe("test2", "type0", 2, new ArrayList<>(), "test");

    @Before
    @After
    public void resetRecipes() {
        recipes = new RecipeCollection();
    }

    @Test
    public void addRecipeTest() {
        recipes.addRecipe(recipe0);
        assertTrue(recipes.containsRecipe(recipe0));
        assertFalse(recipes.containsRecipe(recipe1));
    }

    @Test
    public void sizeTest() {
        recipes.addRecipe(recipe0);
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);

        recipes.addRecipe(recipe0);
        assertEquals(recipes.size(), 3);
    }

    @Test
    public void removeRecipeTest() {
        recipes.addRecipe(recipe0);
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);

        recipes.removeRecipe(recipe0);
        assertFalse(recipes.containsRecipe(recipe0));
        assertEquals(recipes.size(), 2);
    }

    @Test
    public void findRecipeTest() {
        recipes.addRecipe(recipe0);

        assertEquals(recipes.findRecipe(recipe0.getName()), recipe0);
        assertNull(recipes.findRecipe(recipe2.getName()));
    }

    @Test
    public void sortRecipesTest() {
        recipes.addRecipe(recipe0);
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.setSort(new ServingsSort());

        Iterator<Recipe> iterator = recipes.iterator();
        assertEquals(iterator.next(), recipe2);
        assertEquals(iterator.next(), recipe1);
        assertEquals(iterator.next(), recipe0);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void filterRecipesTest() {
        recipes.addRecipe(recipe0);
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.addFilter(new FoodTypeFilter("type0"));

        Iterator<Recipe> iterator = recipes.iterator();
        assertNotEquals(iterator.next(), recipe1);
        assertNotEquals(iterator.next(), recipe1);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void removeFilterTest() {
        recipes.addRecipe(recipe0);
        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.addFilter(new FoodTypeFilter("type0"));
        recipes.addFilter(new FoodTypeFilter("type1"));
        recipes.removeFilter(new FoodTypeFilter("type0"));

        Iterator<Recipe> iterator = recipes.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), recipe1);
        assertFalse(iterator.hasNext());
    }
}
