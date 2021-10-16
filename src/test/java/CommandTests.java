package test.java;

import main.java.CLI.CommandLineInterface;
import main.java.UseCases.RecipeBookManager;
import org.junit.Test;

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
                        "create account",
                        "testName",
                        "testUserName",
                        "testEmail",
                        "sign in",
                        "testUserName"
                }, 2);

        assertEquals(CLI.getUser().getUsername(), "testUserName");
    }

    @Test
    public void testAddToRecipeBook() {
        CommandLineInterface CLI = runCommands(new String[]{
                "create account",
                "testName",
                "testUserName",
                "testEmail",
                "sign in",
                "testUserName",
                "enter recipe viewer",
                "get new recipe",
                "add to recipe book",
                "TemporaryRecipeName",
        }, 5);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertTrue(recipeBookManager.containsRecipe("TemporaryRecipeName"));
    }

    @Test
    public void testRemoveRecipeCommand() {
        CommandLineInterface CLI = runCommands(new String[]{
                "create account",
                "testName",
                "testUserName",
                "testEmail",

                "sign in",
                "testUserName",

                "enter recipe viewer",

                "get new recipe",

                "add to recipe book",
                "TemporaryRecipeName",

                "go back",

                "enter recipe book",
                "remove recipe",
                "TemporaryRecipeName"
        }, 8);

        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        assertFalse(recipeBookManager.containsRecipe("TemporaryRecipeName"));
    }
}
