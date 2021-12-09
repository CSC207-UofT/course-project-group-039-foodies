package test.java.GatewaysTests;

import main.java.Entities.Recipe;
import main.java.Gateways.RecipeCSVReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class RecipeCSVReaderTests {
    RecipeCSVReader database = RecipeCSVReader.getTestInstance();
    File databaseFile = new File(
            System.getProperty("user.dir") + "/src/test/java/GatewaysTests/recipesTest.csv"
    );

    @Before
    @After
    public void resetFile() {
        databaseFile.delete();
        try {
            databaseFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveRecipeTest() {
        database.saveRecipe(
                "TestName",
                "TestType",
                0, new ArrayList<>(),
                "1) Do this\n2) Do that\n3) Go back to step 1"
        );
        Recipe[] recipes = database.getRecipes().getRecipes();
        assertEquals(recipes.length, 1);
        assertEquals(recipes[0].getName(), "TestName");
    }

    @Test
    public void removeRecipeTest() {
        database.saveRecipe(
                "TestName0",
                "TestType",
                0, new ArrayList<>(),
                "1) Do this\n2) Do that\n3) Go back to step 1"
        );
        database.saveRecipe(
                "TestName1",
                "TestType",
                0, new ArrayList<>(),
                "1) Do this\n2) Do that\n3) Go back to step 1"
        );
        database.saveRecipe(
                "TestName2",
                "TestType",
                0, new ArrayList<>(),
                "1) Do this\n2) Do that\n3) Go back to step 1"
        );
        database.removeRecipe("TestName1");
        Recipe[] recipes = database.getRecipes().getRecipes();
        assertEquals(recipes.length, 2);
        if (recipes[0].getName().equals("TestName0")) {
            assertEquals(recipes[1].getName(), "TestName1");
        } else if (recipes[0].getName().equals("TestName1")) {
            assertEquals(recipes[1].getName(), "TestName0");
        } else {
            fail();
        }
    }
}
