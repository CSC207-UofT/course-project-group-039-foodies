package main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.CLI.CommandLineInterface;
import main.java.UseCases.Sorts.*;

public class SortRecipeBookCommand extends ChoiceCommand<RatingOption> {
    public SortRecipeBookCommand() {
        super("sort", "Sorts the recipes to be seen");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        Sort sort = null;
        switch (chooseOption(
                CLI,
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

        CLI.getRecipeCollection().setSort(sort);
    }
}
