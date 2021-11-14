package main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands;
import main.java.CLI.*;
import main.java.UseCases.Filters.*;

public class FilterRecipeBookCommand extends ChoiceCommand<FilterOption> {
    public FilterRecipeBookCommand() {
        super("filter", "Filters the recipes to be seen");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        Filter filter = null;

        switch (chooseOption(
                CLI,
                FilterOption.class,
                "Input 'allergy' to filter out an allergen, " +
                        "'foodtype' to filter in a type of food, and " +
                        "'servings' to filter the number of servings."
        )) {
            case allergy:
                CLI.displayMessage("Input the name of the ingredient to filter out");
                String ingredient = CLI.getTextInput();
                filter = new AllergyFilter(ingredient);
                break;
            case foodtype:
                CLI.displayMessage("Input the name of the food type to filter in");
                String foodtype = CLI.getTextInput();
                filter = new FoodTypeFilter(foodtype);
                break;
            case servings:
                CLI.displayMessage("Input the number of servings you need");
                int servings = Integer.parseInt(CLI.getTextInput());
                filter = new ServingsFilter(servings);
                break;
        }

        CLI.getRecipeCollection().addFilter(filter);
    }

}
