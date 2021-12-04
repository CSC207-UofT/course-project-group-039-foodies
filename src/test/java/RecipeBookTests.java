package test.java;

import main.java.Entities.RecipeBook;
import main.java.Entities.Recipe;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecipeBookTests {
    SubRecipeBook subRecipeBook1;
    SubRecipeBook subRecipeBook2;


    @Test
    public void OverallRecipeBookTest() {
        RecipeBook overallRecipeBook = new RecipeBook();
        assertEquals(1, overallRecipeBook.getSubRecipeBooks().size());
        assertEquals(0, overallRecipeBook.getAllRecipes().length );

    }

    @Test
    public void addSubRecipeBookTest() {
        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook("breakfast recipes", "Collection of breakfast recipes");
        assertEquals(2, overallRecipeBook.getSubRecipeBooks().size());
        overallRecipeBook.addSubRecipeBook("lunch recipes");
        assertEquals(3, overallRecipeBook.getSubRecipeBooks().size());
    }

    @Test
    public void removeSubRecipeBookTest() {
        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook(subRecipeBook1);
        assertEquals(2, overallRecipeBook.getSubRecipeBooks().size());
        overallRecipeBook.addSubRecipeBook(subRecipeBook2);
        assertEquals(3, overallRecipeBook.getSubRecipeBooks().size());
        overallRecipeBook.removeSubRecipeBook(subRecipeBook1);
        assertEquals(2, overallRecipeBook.getSubRecipeBooks().size());
    }

    @Test
    public void showSubRecipeBookTest() {
        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook(subRecipeBook1);
        overallRecipeBook.addSubRecipeBook(subRecipeBook2);
        SubRecipeBook shownSubRecipeBook = overallRecipeBook.showSubRecipeBook(subRecipeBook1);
        assertEquals(subRecipeBook1, shownSubRecipeBook);
    }

    @Test
    public void getSubRecipeBooksTest(){
        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook(subRecipeBook1);
        overallRecipeBook.addSubRecipeBook(subRecipeBook2);
        ArrayList<SubRecipeBook> subRecipeBooks = overallRecipeBook.getSubRecipeBooks();
        subRecipeBooks.remove(0); // removes the "AllRecipes" SubRecipeBook
        ArrayList<SubRecipeBook> expected = new ArrayList<>();
        expected.add(subRecipeBook1);
        expected.add(subRecipeBook2);
        assertEquals(expected, subRecipeBooks);
    }

    @Test
    public void getAllRecipesTest() {
        ArrayList<String> pancakeIngredients = new ArrayList<>();

        // make a recipe
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        RecipeBook overallRecipeBook = new RecipeBook();
        RecipeBookManager recipebookmanager = new RecipeBookManager(overallRecipeBook);

        // make a sub-recipe book
        recipebookmanager.addSubRecipeBook("SubRecipeBook1", "a SubRecipeBook");

        // add the recipe to the sub-recipe book
        recipebookmanager.addRecipe("SubRecipeBook1", recipe3);
        Recipe[] recipes = overallRecipeBook.getAllRecipes();
        assertEquals(1, recipes.length);
    }

    @Test
    public void addRecipeTest() {
        // make a recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook("SubRecipeBook1", "a sub-recipe book");
        overallRecipeBook.addRecipe("SubRecipeBook1", recipe3);
        assertTrue(overallRecipeBook.showSubRecipeBook("AllRecipes").containsRecipe(recipe3));
        assertTrue(overallRecipeBook.showSubRecipeBook("SubRecipeBook1").containsRecipe(recipe3));
    }

    @Test
    public void removeRecipe() {
        // make a recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook("SubRecipeBook1", "a sub-recipe book");
        overallRecipeBook.addRecipe("SubRecipeBook1", recipe3);
        assertTrue(overallRecipeBook.showSubRecipeBook("AllRecipes").containsRecipe(recipe3));
        assertTrue(overallRecipeBook.showSubRecipeBook("SubRecipeBook1").containsRecipe(recipe3));
        overallRecipeBook.removeRecipe("SubRecipeBook1", recipe3 );
        assertFalse(overallRecipeBook.showSubRecipeBook("AllRecipes").containsRecipe(recipe3));
        assertFalse(overallRecipeBook.showSubRecipeBook("SubRecipeBook1").containsRecipe(recipe3));
    }

    @Test
    public void sizeTest() {
        // make a recipe
        ArrayList<String> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add("milk");
        pancakeIngredients.add("pancake mix");
        Recipe recipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredients, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook("SubRecipeBook1", "a sub-recipe book");
        overallRecipeBook.addRecipe("SubRecipeBook1", recipe3);
        assertEquals(1, overallRecipeBook.size());
    }

}
