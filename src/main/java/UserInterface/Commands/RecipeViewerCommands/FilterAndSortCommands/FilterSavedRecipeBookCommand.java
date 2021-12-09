package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Filters.AllergyFilter;
import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Filters.FoodTypeFilter;
import main.java.UseCases.Filters.ServingsFilter;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Filter recipes in the saved sub-recipe book.
 */
public class FilterSavedRecipeBookCommand extends ChoiceCommand<FilterOption> {
    /**
     * Initialize FilterSavedRecipeBookCommand.
     */
    public FilterSavedRecipeBookCommand() {super("filter", "Filters the saved recipes to be seen"); }

    /**
     * Add filter to the recipes in the saved sub-recipe book based on the given filtering algorithm by the user.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        Filter filter = null;

        switch (chooseOption(
                UI,
                FilterOption.class,
                "Input 'allergy' to filter out an allergen, " +
                        "'foodtype' to filter in a type of food, and " +
                        "'servings' to filter the number of servings."
        )) {
            case allergy -> {
                String ingredient = UI.queryUser("Input the name of the ingredient to filter out");
                filter = new AllergyFilter(ingredient);
            }
            case foodtype -> {
                String foodtype = UI.queryUser("Input the name of the food type to filter in");
                filter = new FoodTypeFilter(foodtype);
            }
            case servings -> {
                int servings = Integer.parseInt(UI.queryUser("Input the number of servings you need"));
                filter = new ServingsFilter(servings);
            }
        }

        String subRecipeBook = UI.queryUser("Input the name of Sub-recipe book that you want to filter");
        UI.getUser().getRecipeBook().addFilter(subRecipeBook, filter);
        GetNewRecipeCommand.initializeIterator(UI);
    }
}
