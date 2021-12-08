package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Filters.AllergyFilter;
import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Filters.FoodTypeFilter;
import main.java.UseCases.Filters.ServingsFilter;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Remove filter from RecipeBook.
 */
public class RemoveGroupFilterCommand extends ChoiceCommand<FilterOption> {
    /**
     * Initialize RemoveFilterCommand.
     */
    public RemoveGroupFilterCommand() {
        super("remove filter", "Removes a filter that has been added");
    }

    /**
     * Remove filter given by the user from RecipeBook.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        Filter filter = null;

        switch (chooseOption(
                UI,
                FilterOption.class,
                "Input 'allergy' to remove a filter that filters out an allergen from the recipe book, " +
                        "'foodtype' to remove a filter that filters in a type of food, and " +
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

        RecipeCollectionFacade.removeFilter(UI.getRecipeCollection(), filter);
        GetNewRecipeCommand.initializeIterator(UI);
    }
}
