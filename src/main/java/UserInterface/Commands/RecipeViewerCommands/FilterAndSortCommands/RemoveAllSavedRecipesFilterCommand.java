package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Filters.AllergyFilter;
import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Filters.FoodTypeFilter;
import main.java.UseCases.Filters.ServingsFilter;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Remove filters for the all saved recipes.
 */
public class RemoveAllSavedRecipesFilterCommand extends ChoiceCommand<FilterOption>{
    /**
     * Initialize RemoveSavedFilterCommand.
     */
    public RemoveAllSavedRecipesFilterCommand() {
        super("remove filter", "Removes a filter from AllRecipes book.");
    }

    /**
     * Remove filter given by the user from all their saved recipes list given by the user.
     * @param UI an instance of the user interface.
     */

    @Override
    public void runAction(UserInterface UI) {
        Filter filter = null;

        switch (chooseOption(
                UI,
                FilterOption.class,
                "Input 'allergy' to remove a filter that filters out an allergen from AllRecipes " +
                        "book, and 'foodtype' to remove a filter that filters in a type of food, and " +
                        "'servings' to remove a filter that filters the number of servings."
        )) {
            case allergy:
                String ingredient = UI.queryUser("Input the name of the ingredient that " +
                        "the filter to remove filters out");
                filter = new AllergyFilter(ingredient);
                break;
            case foodtype:
                String foodtype = UI.queryUser("Input the name of the food type that the filter to remove filters in");
                filter = new FoodTypeFilter(foodtype);
                break;
            case servings:
                int servings = Integer.parseInt(
                        UI.queryUser("Input the number of servings that the filter to remove filters in")
                );
                filter = new ServingsFilter(servings);
                break;
        }

        UI.getUser().getRecipeBook().removeFilter("AllRecipes", filter);
        GetNewRecipeCommand.initializeIterator(UI);
    }
}

