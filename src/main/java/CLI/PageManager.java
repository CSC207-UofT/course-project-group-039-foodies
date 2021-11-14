package main.java.CLI;

import main.java.CLI.Commands.*;
import main.java.CLI.Commands.AdminCommands.*;
import main.java.CLI.Commands.RecipeBookCommands.*;
import main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands.*;
import main.java.CLI.Commands.RecipeViewerCommands.*;
import main.java.CLI.Commands.UserPreferencesCommands.*;

public class PageManager {
    Page signedOut = new Page(
            null,
            new Command[]{
                    new SignInCommand(),
                    new CreateAccountCommand()
            }
    );

    Page signedIn = new Page(
            signedOut,
            new Command[] {
                    new EnterRecipeBookCommand(),
                    new EnterRecipeViewerCommand(),
                    new SignOutCommand(),
                    new UpdatePreferencesCommand()
            }
    );

    Page recipeViewer = new Page(
            signedIn,
            new Command[]  {
                    new GetNewRecipeCommand(),
                    new RateRecipeCommand(),
                    new AddToRecipeBookCommand(),
                    new SortRecipeBookCommand(),
                    new FilterRecipeBookCommand(),
                    new RemoveFilterCommand(),
                    new RemoveSortCommand(),
                    new GoBackCommand()
            }
    );

    Page recipeBook = new Page(
            signedIn,
            new Command[] {
                    new ListRecipeBookCommand(),
                    new RemoveRecipeCommand(),
                    new RateRecipeCommand(),
                    new GoBackCommand()
            }
    );

    Page currentPage = signedOut;

    public void setPage(Page page) {
        currentPage = page;
    }
    public Command findCommand(String name) {
        return currentPage.findCommand(name);
    }
    public void signIn() {
        setPage(signedIn);
    }
    public void signOut() {
        setPage(signedOut);
    }
    public void enterRecipeBook() {
        setPage(recipeBook);
    }
    public void enterRecipeViewer() {
        setPage(recipeViewer);
    }
    public void goBack() {
        setPage(currentPage.getParent());
    }
    public Command[] getAvailableCommands() {
        return currentPage.getAvailableCommands();
    }
}
