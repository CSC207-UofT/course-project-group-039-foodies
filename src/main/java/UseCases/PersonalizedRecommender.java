package main.java.UseCases;
import main.java.Entities.Recipe;
import main.java.Entities.RecipeBook;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PersonalizedRecommender {
    RecipeBook recipebook;
    private HashMap<String, Integer> topIngredients;

    public PersonalizedRecommender(RecipeBook recipebook, HashMap<String, Integer> topIngredients) {
        this.recipebook = recipebook;
        this.topIngredients = topIngredients;
    }

    /**
     * Return ingredients and their respective number of mentions in the current recipe book
     *
     * @param recipeBook The user's current recipebook
     * @return A Hashmap of ingredients and their respective number of mentions in the current recipe book
     */

    public HashMap<String, Integer> topIngredients(RecipeBook recipeBook) {
        HashMap<String, Integer> topIngredients = new HashMap<>();
        for (Recipe recipe : recipeBook.getRecipes()) {
            for (String ingredient : recipe.getIngredients()) {
                topIngredients.put(ingredient, topIngredients.get(ingredient) + 1);
            }
        }
        return topIngredients;
    }

    public String mostPopularIngredient() {
        String max = "";
        int maxValueInMap = (Collections.max(topIngredients.values()));  // This will return max value in the HashMap
        for (Map.Entry<String, Integer> entry : topIngredients.entrySet()) {  // Iterate through HashMap
            if (entry.getValue() == maxValueInMap) {
                max = entry.getKey();
            }
        }
        return max;

    }
}
