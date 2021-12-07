package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Sorts.RatingSort;
import main.java.UseCases.Sorts.ServingsSort;
import main.java.UseCases.Sorts.Sort;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Sort recipes in the sub-recipe book.
 */
public class SortSavedRecipeBookCommand extends ChoiceCommand<RatingOption> {
    /**
     * Initialize SortSavedRecipeBookCommand.
     */
    public SortSavedRecipeBookCommand() {super("sort", "Sorts the saved recipes to be seen");}

    /**
     * Set sort given by the user to the saved sub-recipe book.
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

        String subRecipeBook = UI.queryUser("Input the name of Sub-recipe book that you want to filter");
        UI.getUser().getRecipeBook().setSort(subRecipeBook, sort);
        GetNewRecipeCommand.initializeIterator(UI);
    }
}
