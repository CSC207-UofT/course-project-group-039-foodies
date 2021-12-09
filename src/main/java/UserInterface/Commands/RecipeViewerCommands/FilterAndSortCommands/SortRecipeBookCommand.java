package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Sorts.RatingSort;
import main.java.UseCases.Sorts.ServingsSort;
import main.java.UseCases.Sorts.Sort;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Sort recipes from the database.
 */
public class SortRecipeBookCommand extends ChoiceCommand<RatingOption> {
    /**
     * Initialize SortRecipeBookCommand.
     */
    public SortRecipeBookCommand() {
        super("sort", "Sorts the recipes to be seen");
    }

    /**
     * Set sort to the recipes in the database based on its given sort algorithm by the user.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        Sort sort = null;
        switch (chooseOption(
                UI,
                RatingOption.class,
                "Input 'rating' to sort by rating, " +
                        "and 'servings' to sort by servings"
        )) {
            case rating:
                sort = new RatingSort();
                break;
            case servings:
                sort = new ServingsSort();
                break;
        }

        RecipeCollectionFacade.setSort(UI.getRecipeCollection(), sort);
        GetNewRecipeCommand.initializeIterator(UI);
    }
}
