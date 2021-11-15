package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Sorts.RatingSort;
import main.java.UseCases.Sorts.ServingsSort;
import main.java.UseCases.Sorts.Sort;
import main.java.UserInterface.UserInterface;

public class SortRecipeBookCommand extends ChoiceCommand<RatingOption> {
    public SortRecipeBookCommand() {
        super("sort", "Sorts the recipes to be seen");
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

        UI.getRecipeCollection().setSort(sort);
    }
}
