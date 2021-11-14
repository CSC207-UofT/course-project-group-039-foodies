package test.java;

import main.java.Entities.Recipe;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SubRecipeBookTests {

    @Test
    public void SubRecipeBookTest() {
        SubRecipeBook subrecipebook = new SubRecipeBook("123", "123");
        assertEquals("123", subrecipebook.getName());
    }

    @Test
    public void addRecipeTest() {
        SubRecipeBook subrecipebook = new SubRecipeBook("123", "123");

        //create new recipe
        ArrayList<String> pancakeingre = new ArrayList<>();
        pancakeingre.add("milk");
        pancakeingre.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        subrecipebook.addRecipe(recipe1);
        assertTrue(subrecipebook.containsRecipe(recipe1));
    }

    @Test
    public void removeRecipeTest() {
        SubRecipeBook subrecipebook = new SubRecipeBook("123", "123");

        //create new recipe
        ArrayList<String> pancakeingre = new ArrayList<>();
        pancakeingre.add("milk");
        pancakeingre.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        subrecipebook.addRecipe(recipe1);
        assertTrue(subrecipebook.containsRecipe(recipe1));

        //remove a recipe
        subrecipebook.removeRecipe(recipe1);
        assertFalse(subrecipebook.containsRecipe(recipe1));
    }

    @Test
    public void getRecipes() {
        SubRecipeBook subrecipebook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeingre = new ArrayList<>();
        pancakeingre.add("milk");
        pancakeingre.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subrecipebook
        subrecipebook.addRecipe(recipe1);

        Recipe[] recipes = subrecipebook.getRecipes();
        assertEquals(1, recipes.length);
    }

    @Test
    public void getRecipeTest() {
        SubRecipeBook subrecipebook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeingre = new ArrayList<>();
        pancakeingre.add("milk");
        pancakeingre.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subrecipebook
        subrecipebook.addRecipe(recipe1);

        Recipe recipereturned = subrecipebook.getRecipe("pancakes");
        assertEquals("pancakes", recipereturned.getName());
    }

    @Test
    public void containsRecipeTest() {
        SubRecipeBook subrecipebook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeingre = new ArrayList<>();
        pancakeingre.add("milk");
        pancakeingre.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subrecipebook
        subrecipebook.addRecipe(recipe1);
        assertTrue(subrecipebook.containsRecipe(recipe1));
    }

    @Test
    public void sizeTest() {
        SubRecipeBook subrecipebook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeingre = new ArrayList<>();
        pancakeingre.add("milk");
        pancakeingre.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subrecipebook
        subrecipebook.addRecipe(recipe1);
        assertEquals(1, subrecipebook.size());
    }
}
