package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Filters.AllergyFilter;
import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Filters.FoodTypeFilter;
import main.java.UseCases.Filters.ServingsFilter;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewGroupRecipeCommand;
import main.java.UserInterface.UserInterface;

public class FilterGroupRecipeBookCommand extends ChoiceCommand<FilterOption> {
    public FilterGroupRecipeBookCommand() {
        super("filter", "Filters the group recipes to be seen");
    }

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
            case allergy:
                String ingredient = UI.queryUser("Input the name of the ingredient to filter out");
                filter = new AllergyFilter(ingredient);
                break;
            case foodtype:
                String foodtype = UI.queryUser("Input the name of the food type to filter in");
                filter = new FoodTypeFilter(foodtype);
                break;
            case servings:
                int servings = Integer.parseInt(UI.queryUser("Input the number of servings you need"));
                filter = new ServingsFilter(servings);
                break;
        }

        RecipeCollectionFacade.addFilter(UI.getRecipeCollection(), filter);
        GetNewGroupRecipeCommand.initializeIterator(UI);
    }
}
