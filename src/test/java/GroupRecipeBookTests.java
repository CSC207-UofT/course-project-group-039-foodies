package test.java;

import main.java.Entities.*;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UseCases.RecipeFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupRecipeBookTests {
    GroupSubRecipeBook groupSubRecipeBook1;
    GroupSubRecipeBook groupSubRecipeBook2;

    @Test
    public void OverallGroupRecipeBookTest() {
        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        assertEquals(1, overallGroupRecipeBook.getGroupSubRecipeBooks().size());
        assertEquals(0, overallGroupRecipeBook.getAllRecipes().length );

    }

    @Test
    public void addGroupSubRecipeBookTest() {
        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        overallGroupRecipeBook.addGroupSubRecipeBook("breakfast recipes", "Collection of breakfast recipes");
        assertEquals(2, overallGroupRecipeBook.getGroupSubRecipeBooks().size());
        overallGroupRecipeBook.addGroupSubRecipeBook("lunch recipes");
        assertEquals(3, overallGroupRecipeBook.getGroupSubRecipeBooks().size());
    }

    @Test
    public void removeGroupSubRecipeBookTest() {
        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        overallGroupRecipeBook.addGroupSubRecipeBook(groupSubRecipeBook1);
        assertEquals(2, overallGroupRecipeBook.getGroupSubRecipeBooks().size());
        overallGroupRecipeBook.addGroupSubRecipeBook(groupSubRecipeBook2);
        assertEquals(3, overallGroupRecipeBook.getGroupSubRecipeBooks().size());
        overallGroupRecipeBook.removeGroupSubRecipeBook(groupSubRecipeBook1);
        assertEquals(2, overallGroupRecipeBook.getGroupSubRecipeBooks().size());
    }

    @Test
    public void showGroupSubRecipeBookTest() {
        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        overallGroupRecipeBook.addGroupSubRecipeBook(groupSubRecipeBook1);
        overallGroupRecipeBook.addGroupSubRecipeBook(groupSubRecipeBook2);
        GroupSubRecipeBook shownGroupSubRecipeBook = overallGroupRecipeBook.showGroupSubRecipeBook(groupSubRecipeBook1);
        assertEquals(groupSubRecipeBook1, shownGroupSubRecipeBook);
    }

    @Test
    public void getGroupSubRecipeBooksTest(){
        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        overallGroupRecipeBook.addGroupSubRecipeBook(groupSubRecipeBook1);
        overallGroupRecipeBook.addGroupSubRecipeBook(groupSubRecipeBook2);
        ArrayList<GroupSubRecipeBook> groupSubRecipeBooks = overallGroupRecipeBook.getGroupSubRecipeBooks();
        groupSubRecipeBooks.remove(0);
        ArrayList<GroupSubRecipeBook> expected = new ArrayList<>();
        expected.add(groupSubRecipeBook1);
        expected.add(groupSubRecipeBook2);
        assertEquals(expected, groupSubRecipeBooks);
    }

    @Test
    public void getAllRecipesTest() {
        ArrayList<String> pancakeIngredient = new ArrayList<>();

        // make a groupRecipe
        pancakeIngredient.add("milk");
        pancakeIngredient.add("pancake mix");
        Recipe groupRecipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredient, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        GroupRecipeBookManager grouprecipebookmanager = new GroupRecipeBookManager(overallGroupRecipeBook);

        // make a groupSubRecipeBook
        grouprecipebookmanager.addSubRecipeBook("subRecipeBook1", "a subRecipeBook");

        // add the groupRecipe to the groupSubRecipeBook
        grouprecipebookmanager.addRecipe("subRecipeBook1", groupRecipe3);
        Recipe[] groupRecipes = overallGroupRecipeBook.getAllRecipes();
        assertEquals(1, groupRecipes.length);
    }

    @Test
    public void addRecipeTest() {
        // make a recipe
        ArrayList<String> pancakeIngredient = new ArrayList<>();
        pancakeIngredient.add("milk");
        pancakeIngredient.add("pancake mix");
        Recipe groupRecipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredient, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        overallGroupRecipeBook.addGroupSubRecipeBook("subRecipeBook1", "a subRecipeBook");
        overallGroupRecipeBook.addRecipe("subRecipeBook1", groupRecipe3);
        assertTrue(overallGroupRecipeBook.showGroupSubRecipeBook("subRecipeBook1").containsRecipe(groupRecipe3));
    }

    @Test
    public void removeRecipe() {
        // make a recipe
        ArrayList<String> pancakeIngredient = new ArrayList<>();
        pancakeIngredient.add("milk");
        pancakeIngredient.add("pancake mix");
        Recipe groupRecipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredient, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        overallGroupRecipeBook.addGroupSubRecipeBook("subRecipeBook1", "a subRecipeBook");
        overallGroupRecipeBook.addRecipe("subRecipeBook1", groupRecipe3);
        assertTrue(overallGroupRecipeBook.showGroupSubRecipeBook("subRecipeBook1").containsRecipe(groupRecipe3));
        overallGroupRecipeBook.removeRecipe("subRecipeBook1", groupRecipe3 );
        assertFalse(overallGroupRecipeBook.showGroupSubRecipeBook("subRecipeBook1").containsRecipe(groupRecipe3));
    }

    @Test
    public void sizeTest() {
        // make a recipe
        ArrayList<String> pancakeIngredient = new ArrayList<>();
        pancakeIngredient.add("milk");
        pancakeIngredient.add("pancake mix");
        Recipe groupRecipe3 = RecipeFactory.createRecipe("pancakes", "breakfast", 2,
                pancakeIngredient, "Add milk to pancake mix. Combine. Fry pancakes on pan");

        GroupRecipeBook overallGroupRecipeBook = new GroupRecipeBook();
        overallGroupRecipeBook.addGroupSubRecipeBook("subRecipeBook1", "a subRecipeBook");
        overallGroupRecipeBook.addRecipe("subRecipeBook1", groupRecipe3);
        assertEquals(1, overallGroupRecipeBook.size());
    }
}

