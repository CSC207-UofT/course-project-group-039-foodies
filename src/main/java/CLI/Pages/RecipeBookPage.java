package main.java.CLI.Pages;

import main.java.CLI.CommandLineInterface;
import main.java.Recipe;

public class RecipeBookPage extends Page {
    private static class ListRecipeBookCommand extends Command {
        public ListRecipeBookCommand() {
            super("list recipes", "Lists all recipes in the recipe book");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            for (Recipe recipe : CLI.getRecipeBookManager().getRecipes(CLI.getUser())) {
                CLI.displayMessage(CLI.getRecipeBookManager().recipeToString(recipe));
            }
        }
    }

    private static class RemoveRecipeCommand extends Command {

        public RemoveRecipeCommand() {
            super("remove recipe", "Removes a recipe from the recipe book");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.displayMessage("Input the name of the recipe to remove");
            String recipe = CLI.getTextInput();
            if (CLI.getRecipeBookManager().containsRecipe(CLI.getUser(), recipe)) {
                CLI.getRecipeBookManager().removeRecipe(CLI.getUser(), recipe);
            } else {
                CLI.displayMessage("Recipe not found in recipe book.");
            }
        }
    }

    private static class RateRecipeCommand extends Command {
        public RateRecipeCommand() {
            super("rate recipe", "Rates a recipe");
        }
        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.displayMessage("Enter the name of the recipe to rate");
            String recipeName = CLI.getTextInput();
            if (CLI.getRecipeManager().isRecipe(recipeName)) {
                CLI.displayMessage("Enter rating from 1-5");
                int rating = Integer.parseInt(CLI.getTextInput());
                CLI.getUserManager().rateRecipe(CLI.getUser(), recipeName, rating);
            } else {
                CLI.displayMessage("Recipe not found");
            }
        }
    }

    private static class GoBackCommand extends Command {
        public GoBackCommand() {
            super("go back", "Go back to the main page");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.exitRecipeBook();
        }
    }

    public RecipeBookPage() {
        super(new Command[] {
                new ListRecipeBookCommand(),
                new RemoveRecipeCommand(),
                new RateRecipeCommand(),
                new GoBackCommand()
        });
    }
}
