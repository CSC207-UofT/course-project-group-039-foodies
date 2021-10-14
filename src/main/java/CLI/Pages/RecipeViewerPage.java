package main.java.CLI.Pages;

import main.java.CLI.CommandLineInterface;
import main.java.Commands.Command;

public class RecipeViewerPage extends Page {
    private static class GetNewRecipeCommand extends Command {
        public GetNewRecipeCommand() {
            super("get new recipe", "Gets a new recipe to rate");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {

        }
    }

    private static class GoBackCommand extends Command {
        public GoBackCommand() {
            super("go back", "Go back to the main page");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.exitRecipeViewer();
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

    public RecipeViewerPage() {
        super(new Command[] {
                new GetNewRecipeCommand(),
                new RateRecipeCommand(),
                new GoBackCommand()
        });
    }
}
