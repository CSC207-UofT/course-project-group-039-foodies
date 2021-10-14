package main.java.CLI.Pages;

import main.java.CLI.CommandLineInterface;

public class SignedInPage extends Page {
    private static class EnterRecipeBookCommand extends Command{
        private EnterRecipeBookCommand() {
            super("enter recipe book", "Enters the recipe book");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.enterRecipeBook();
        }
    }

    private static class EnterRecipeViewerCommand extends Command {
        private EnterRecipeViewerCommand() {
            super("enter recipe viewer", "Enters the recipe viewer");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.enterRecipeViewer();
        }
    }

    private static class SignOutCommand extends Command {
        public SignOutCommand() {
            super("sign out", "Signs out the current user");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.signOut();
        }
    }

    private static class UpdatePreferencesCommand extends Command {
        public UpdatePreferencesCommand() {
            super("update preferences", "Starts a questionnaire to update user preferences");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {

        }
    }

    private static class ViewHighestRatedRecipesCommand extends Command {
        public ViewHighestRatedRecipesCommand() {
            super("view highest rated recipes", "Displays a list of the most popular recipes");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {

        }
    }

    public SignedInPage() {
        super(new Command[] {
                new EnterRecipeBookCommand(),
                new EnterRecipeViewerCommand(),
                new SignOutCommand(),
                new UpdatePreferencesCommand(),
                new ViewHighestRatedRecipesCommand()
        });
    }
}
