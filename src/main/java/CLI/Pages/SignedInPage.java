package main.java.CLI.Pages;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Commands.*;

public class SignedInPage extends Page {
    public SignedInPage(Page parent) {
        super(parent);

        Command[] commands = {
                new EnterRecipeBookCommand(),
                new EnterRecipeViewerCommand(),
                new SignOutCommand(),
                new UpdatePreferencesCommand()
        };
        setCommands(commands);
    }

    private class EnterRecipeBookCommand extends Command{
        private EnterRecipeBookCommand() {
            super("enter recipe book", "Enters the recipe book");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.changePage(new RecipeBookPage(SignedInPage.this));
        }
    }

    private class EnterRecipeViewerCommand extends Command {
        private EnterRecipeViewerCommand() {
            super("enter recipe viewer", "Enters the recipe viewer");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.changePage(new RecipeViewerPage(SignedInPage.this));
        }
    }

    private class SignOutCommand extends Command {
        public SignOutCommand() {
            super("sign out", "Signs out the current user");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.changePage(parent);
            CLI.displayMessage("You have successfully signed out.");
        }
    }
}
