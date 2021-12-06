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
        SubRecipeBook subRecipeBook = new SubRecipeBook("123", "123");

        //create new recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        subRecipeBook.addRecipe(recipe1);
        assertTrue(subRecipeBook.containsRecipe(recipe1));
    }

    @Test
    public void removeRecipeTest() {
        SubRecipeBook subRecipeBook = new SubRecipeBook("123", "123");

        //create new recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        subRecipeBook.addRecipe(recipe1);
        assertTrue(subRecipeBook.containsRecipe(recipe1));

        //remove a recipe
        subRecipeBook.removeRecipe(recipe1);
        assertFalse(subRecipeBook.containsRecipe(recipe1));
    }

    @Test
    public void getRecipes() {
        SubRecipeBook subRecipeBook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subRecipeBook
        subRecipeBook.addRecipe(recipe1);

        Recipe[] recipes = subRecipeBook.getRecipes();
        assertEquals(1, recipes.length);
    }

    @Test
    public void getRecipeTest() {
        SubRecipeBook subRecipeBook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subRecipeBook
        subRecipeBook.addRecipe(recipe1);

        Recipe recipeReturned = subRecipeBook.getRecipe("pancakes");
        assertEquals("pancakes", recipeReturned.getName());
    }

    @Test
    public void containsRecipeTest() {
        SubRecipeBook subRecipeBook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subRecipeBook
        subRecipeBook.addRecipe(recipe1);
        assertTrue(subRecipeBook.containsRecipe(recipe1));
    }

    @Test
    public void sizeTest() {
        SubRecipeBook subRecipeBook = new SubRecipeBook("123", "123");

        // create new recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        // add recipe to the subRecipeBook
        subRecipeBook.addRecipe(recipe1);
        assertEquals(1, subRecipeBook.size());
    }
}
