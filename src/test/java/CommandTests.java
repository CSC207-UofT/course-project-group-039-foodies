package test.java;

import main.java.Entities.Recipe;
import main.java.Gateways.GroupCSVReader;
import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.CLI.CommandLineInterface;

import java.io.File;
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

                "enter personal recipe book",

                "add a sub recipe book",
                "testName",
                "testDescription",

                "go back",

                "enter recipe viewer",

                "add to sub recipe book",
                "Hot Cross Buns",
                "testName"
        }, 7);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertTrue(recipeBookManager.findSubRecipeBook("testName").containsRecipe("Hot Cross Buns"));
    }

    @Test
    public void testRemoveRecipeCommand() {
        CommandLineInterface CLI = runCommands(new String[]{
                "sign in",
                "testUserName",
                "testPassword",

                "enter recipe book",

                "enter personal recipe book",

                "add a sub recipe book",
                "testName",
                "testDescription",

                "go back",

                "enter recipe viewer",

                "add to sub recipe book",
                "Hot Cross Buns",
                "testName",

                "go back",

                "enter recipe book",

                "enter personal recipe book",

                "remove recipe",
                "Hot Cross Buns",
                "testName"
        }, 11);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertFalse(recipeBookManager.containsRecipe("Hot Cross Buns"));
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

