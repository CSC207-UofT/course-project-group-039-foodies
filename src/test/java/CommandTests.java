package test.java;

import main.java.Entities.Recipe;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.CLI.CommandLineInterface;
import org.junit.Test;

import java.util.Iterator;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

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

                "add a subrecipebook",
                "testName",
                "testDescription",

                "go back",

                "enter recipe viewer",

                "add to subrecipebook",
                "Ramen",
                "testName"
        }, 6);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertTrue(recipeBookManager.findsubrecipebook("testName").containsRecipe("Ramen"));
    }

    @Test
    public void testRemoveRecipeCommand() {
        CommandLineInterface CLI = runCommands(new String[]{
                "sign in",
                "testUserName",
                "testPassword",

                "enter recipe viewer",

                "add to recipe book",
                "Ramen",

                "go back",

                "enter recipe book",

                "remove recipe",
                "Ramen"
        }, 6);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertFalse(recipeBookManager.containsRecipe("Smoothie"));
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
