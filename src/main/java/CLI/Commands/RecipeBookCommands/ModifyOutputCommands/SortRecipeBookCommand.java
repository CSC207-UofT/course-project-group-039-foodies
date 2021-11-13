package main.java.CLI.Commands.RecipeBookCommands.ModifyOutputCommands;

import main.java.CLI.CommandLineInterface;
import main.java.Modifiers.Sorts.RatingSort;
import main.java.Modifiers.Sorts.ServingsSort;
import main.java.Modifiers.Sorts.Sort;



public class SortRecipeBookCommand extends ModifyOutputCommand<ratingOption> {
    public SortRecipeBookCommand() {
        super("sort recipe book", "Sorts the recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        Sort sort = null;
        switch (chooseOption(
                CLI,
                ratingOption.class,
                "Input 'rating' to sort the recipebook by rating," +
                        "and 'servings' to sort the recipe book by servings"
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
