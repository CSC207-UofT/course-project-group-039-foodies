package test.java;

import com.sun.source.tree.AssertTree;
import main.java.Entities.RecipeBook;
import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class OverallRecipeBookTests {
    Recipe recipe1;
    Recipe recipe2;
    RecipeBook overallrecipebook;
    SubRecipeBook subrecipebook1;
    SubRecipeBook subrecipebook2;

    @Before
    public void setUp() {
        // create an overallrecipebook
        final RecipeBook overallrecipebook = new RecipeBook();

        // create the recipes
        final RecipeCollection recipes = new RecipeCollection();

        final ArrayList<String> pancakeingre = new ArrayList<>();
        pancakeingre.add("milk");
        pancakeingre.add("pancake mix");

        final ArrayList<String> mashedpotatoesingre = new ArrayList<>();
        mashedpotatoesingre.add("potatoes");
        mashedpotatoesingre.add("milk");
        mashedpotatoesingre.add("seasoning");

        final Recipe recipe1 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeingre, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        final Recipe recipe2 = RecipeFactory.createRecipe("mashedpotatoes", "lunch", 2,
                mashedpotatoesingre, "Cook potatoes. Mash potatoes until smooth. Add milk and seasoning to " +
                        "taste. Enjoy");

        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);

        final SubRecipeBook subrecipebook1 = new SubRecipeBook("breakfast");
        final SubRecipeBook subrecipebook2 = new SubRecipeBook("lunch", "lunch ideas");

    }

    @Test
    public void OverallRecipeBookTest() {
        RecipeBook overallrecipebook = new RecipeBook();
        assertEquals(0, overallrecipebook.getSubRecipeBooks().size());
        assertEquals(0, overallrecipebook.getAllRecipes().length );

    }

    @Test
    public void addSubRecipeBookTest() {
        RecipeBook overallrecipebook = new RecipeBook();
        overallrecipebook.addSubRecipeBook("breakfast recipes", "Collection of breakfast recipes");
        assertEquals(1, overallrecipebook.getSubRecipeBooks().size());
        overallrecipebook.addSubRecipeBook("lunch recipes");
        assertEquals(2, overallrecipebook.getSubRecipeBooks().size());
    }

    @Test
    public void removeSubRecipeBookTest() {
        RecipeBook overallrecipebook = new RecipeBook();
        overallrecipebook.addSubRecipeBook(subrecipebook1);
        assertEquals(1, overallrecipebook.getSubRecipeBooks().size());
        overallrecipebook.addSubRecipeBook(subrecipebook2);
        assertEquals(2, overallrecipebook.getSubRecipeBooks().size());
        overallrecipebook.removeSubRecipeBook(subrecipebook1);
        assertEquals(1, overallrecipebook.getSubRecipeBooks().size());
    }

    @Test
    public void showSubRecipeBookTest() {
        RecipeBook overallrecipebook = new RecipeBook();
        overallrecipebook.addSubRecipeBook(subrecipebook1);
        overallrecipebook.addSubRecipeBook(subrecipebook2);
        SubRecipeBook shownsubrecipebook = overallrecipebook.showSubRecipeBook(subrecipebook1);
        assertEquals(subrecipebook1, shownsubrecipebook);
    }

    @Test
    public void getSubRecipeBooksTest(){

    }


}
