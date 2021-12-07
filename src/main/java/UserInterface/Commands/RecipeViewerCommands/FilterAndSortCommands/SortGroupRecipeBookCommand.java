package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Sorts.RatingSort;
import main.java.UseCases.Sorts.ServingsSort;
import main.java.UseCases.Sorts.Sort;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewGroupRecipeCommand;
import main.java.UserInterface.UserInterface;

public class SortGroupRecipeBookCommand extends ChoiceCommand<RatingOption> {
    public SortGroupRecipeBookCommand() {
        super("sort", "Sorts the group recipes to be seen");
    }

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
        GetNewGroupRecipeCommand.initializeIterator(UI);
    }
}
