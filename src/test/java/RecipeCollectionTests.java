package test.java;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.RecipeFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class RecipeCollectionTests {
    private RecipeCollection recipes = new RecipeCollection();
    private final Recipe recipe0 = RecipeFactory.createRecipe("test0", "test", 0, new ArrayList<>(), "test");
    private final Recipe recipe1 = RecipeFactory.createRecipe("test1", "test", 0, new ArrayList<>(), "test");
    private final Recipe recipe2 = RecipeFactory.createRecipe("test2", "test", 0, new ArrayList<>(), "test");

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

}
