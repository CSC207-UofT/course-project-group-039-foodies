package test.java;

import com.sun.source.tree.AssertTree;
import main.java.Entities.RecipeBook;
import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.RecipeFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RecipeBookTests {
    Recipe recipe1;
    Recipe recipe2;
    RecipeBook overallrecipebook;
    SubRecipeBook subrecipebook1;
    SubRecipeBook subrecipebook2;

//    @Before
//    public void setUp() {
//        // create an overallrecipebook
//        final RecipeBook overallrecipebook = new RecipeBook();
//
//        // create the recipes
//        final RecipeCollection recipes = new RecipeCollection();
//
//        final ArrayList<String> pancakeingre = new ArrayList<>();
//        pancakeingre.add("milk");
//        pancakeingre.add("pancake mix");
//
//        final ArrayList<String> mashedpotatoesingre = new ArrayList<>();
//        mashedpotatoesingre.add("potatoes");
//        mashedpotatoesingre.add("milk");
//        mashedpotatoesingre.add("seasoning");
//
//        final Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
//                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");
//
//        final Recipe recipe2 = RecipeFactory.createRecipe("mashedpotatoes", "lunch", 2,
//                mashedpotatoesingre, "Cook potatoes. Mash potatoes until smooth. Add milk and seasoning to " +
//                        "taste. Enjoy");
//
//        recipes.addRecipe(recipe1);
//        recipes.addRecipe(recipe2);
//
//        final SubRecipeBook subrecipebook1 = new SubRecipeBook("breakfast");
//        final SubRecipeBook subrecipebook2 = new SubRecipeBook("lunch", "lunch ideas");
//
//    }

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
        overallRecipeBook.addSubRecipeBook(subrecipebook1);
        assertEquals(2, overallRecipeBook.getSubRecipeBooks().size());
        overallRecipeBook.addSubRecipeBook(subrecipebook2);
        assertEquals(3, overallRecipeBook.getSubRecipeBooks().size());
        overallRecipeBook.removeSubRecipeBook(subrecipebook1);
        assertEquals(2, overallRecipeBook.getSubRecipeBooks().size());
    }

    @Test
    public void showSubRecipeBookTest() {
        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook(subrecipebook1);
        overallRecipeBook.addSubRecipeBook(subrecipebook2);
        SubRecipeBook shownSubRecipeBook = overallRecipeBook.showSubRecipeBook(subrecipebook1);
        assertEquals(subrecipebook1, shownSubRecipeBook);
    }

    @Test
    public void getSubRecipeBooksTest(){
        RecipeBook overallRecipeBook = new RecipeBook();
        overallRecipeBook.addSubRecipeBook(subrecipebook1);
        overallRecipeBook.addSubRecipeBook(subrecipebook2);
        ArrayList<SubRecipeBook> subRecipeBooks = overallRecipeBook.getSubRecipeBooks();
        subRecipeBooks.remove(0); // removes the "AllRecipes" SubRecipeBook
        ArrayList<SubRecipeBook> expected = new ArrayList<>();
        expected.add(subrecipebook1);
        expected.add(subrecipebook2);
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
