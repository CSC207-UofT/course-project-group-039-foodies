package test.java;

import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.CLI.CommandLineInterface;

import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommandTests {
    private CommandLineInterface runCommands(String[] inputs, int length) {
        CommandLineInterface CLI = new CommandLineInterface(new Scanner(String.join("\n", inputs)));
        for (int i = 0; i < length; i++) {
            CLI.parseInput().runAction(CLI);
        }
        return CLI;
    }

    @Test
    public void testSignIn() {
        CommandLineInterface CLI = runCommands(
                new String[]{
                        "sign in",
                        "testUserName",
                        "testPassword"
                }, 1);

        assertEquals(CLI.getUser().getUsername(), "testUserName");
    }

    @Test
    public void testAddToRecipeBook() {
        CommandLineInterface CLI = runCommands(new String[]{
                "sign in",
                "testUserName",
                "testPassword",

                "enter recipe book",

                "add a sub recipe book",
                "testName",
                "testDescription",

                "go back",

                "enter recipe viewer",

                "add to sub recipe book",
                "Ramen",
                "testName"
        }, 6);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertTrue(recipeBookManager.findSubRecipeBook("testName").containsRecipe("Ramen"));
    }

    @Test
    public void testRemoveRecipeCommand() {
        CommandLineInterface CLI = runCommands(new String[]{
                "sign in",
                "testUserName",
                "testPassword",

                "enter recipe book",

                "add a sub recipe book",
                "testName",
                "testDescription",

                "go back",

                "enter recipe viewer",

                "add to sub recipe book",
                "Ramen",
                "testName",

                "go back",

                "enter recipe book",

                "remove recipe",
                "Ramen",
                "testName"
        }, 9);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertFalse(recipeBookManager.containsRecipe("Ramen"));
    }

    @Test
    public void testFilterRecipeCommand() {
        CommandLineInterface CLI = runCommands(new String[]{
                "sign in",
                "testUserName",
                "testPassword",

                "enter recipe viewer",

                "filter",
                "foodtype",
                "dessert"
        }, 3);

        Iterator<Recipe> recipes = CLI.getRecipeCollection().iterator();
        assertEquals(recipes.next().getFoodType(), "dessert");
    }

    @Test
    public void testRemoveFilterRecipeCommand() {
        CommandLineInterface CLI = runCommands(new String[]{
                "sign in",
                "testUserName",
                "testPassword",

                "enter recipe viewer",

                "filter",
                "foodtype",
                "dessert",

                "filter",
                "foodtype",
                "lunch",

                "remove filter",
                "foodtype",
                "dessert"
        }, 5);

        Iterator<Recipe> recipes = CLI.getRecipeCollection().iterator();
        assertTrue(recipes.hasNext());
        assertEquals(recipes.next().getFoodType(), "lunch");
    }

    @Test
    public void testSortRecipeCommand() {
        CommandLineInterface CLI = runCommands(new String[]{
                "sign in",
                "testUserName",
                "testPassword",

                "enter recipe viewer",

                "sort",
                "servings",
        }, 3);

        Iterator<Recipe> recipes = CLI.getRecipeCollection().iterator();
        assertTrue(recipes.next().getServings() <= recipes.next().getServings());
    }
}

