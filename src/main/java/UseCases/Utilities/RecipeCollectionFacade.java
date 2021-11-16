package main.java.UseCases.Utilities;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Sorts.Sort;

public class RecipeCollectionFacade {
    public static Recipe findRecipe(RecipeCollection recipeCollection, String recipeName) {
        return recipeCollection.findRecipe(recipeName);
    }

    public static void addFilter(RecipeCollection recipeCollection, Filter filter) {
        recipeCollection.addFilter(filter);
    }

    public static void removeFilter(RecipeCollection recipeCollection, Filter filter) {
        recipeCollection.removeFilter(filter);
    }

    public static void setSort(RecipeCollection recipeCollection, Sort sort) {
        recipeCollection.setSort(sort);
    }

    public static void removeSort(RecipeCollection recipeCollection) {
        recipeCollection.removeSort();
    }


}
