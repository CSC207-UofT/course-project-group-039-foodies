package test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;
import org.junit.Before;
import org.junit.Test;

public class RecipeBooktest {
    RecipeBook userrecipebook;

    @Before
    public void setup() {
        userrecipebook = new RecipeBook();
    }

    @Test
    public void testaddRecipe() {
        ArrayList<String> i1 = new ArrayList<>();
        i1.add("pancakes");
        i1.add("milk");
        i1.add("egg");
        Recipe r1 = new Recipe(1, "pancakes", "breakfast", 2, i1,
                "Mix all ingredients and cook");
        userrecipebook.addRecipe(1, r1);

        ArrayList<String> i2 = new ArrayList<>();
        i1.add("ramen");
        i1.add("milk");
        i1.add("egg");
        Recipe r2 = new Recipe(2, "ramen", "lunch", 2, i2,
                "Fry egg. Boil noodles until desired texture and add ramen seasoning");
        userrecipebook.addRecipe(2, r2);
        assert userrecipebook.size() == 2;
    }

    @Test
    public void testremoveRecipe() {
        ArrayList<String> i1 = new ArrayList<>();
        i1.add("pancakes");
        i1.add("milk");
        i1.add("egg");
        Recipe r1 = new Recipe(1, "pancakes", "breakfast", 2, i1,
                "Mix all ingredients and cook");
        userrecipebook.addRecipe(1, r1);

        ArrayList<String> i2 = new ArrayList<>();
        i1.add("ramen");
        i1.add("milk");
        i1.add("egg");
        Recipe r2 = new Recipe(2, "ramen", "lunch", 2, i2,
                "Fry egg. Boil noodles until desired texture and add ramen seasoning");
        userrecipebook.addRecipe(2, r2);
        userrecipebook.removeRecipe(1);
        assert userrecipebook.size() == 1;
    }







}
