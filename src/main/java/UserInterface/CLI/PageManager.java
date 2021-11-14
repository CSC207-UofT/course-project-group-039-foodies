package main.java.CLI;

import main.java.CLI.Commands.*;
import main.java.CLI.Commands.AdminCommands.*;
import main.java.CLI.Commands.AdminCommands.CreateAccountCommand;
import main.java.CLI.Commands.GroupCommands.EnterManageGroupCommand;
import main.java.CLI.Commands.GroupCommands.CreateGroupCommand;
import main.java.CLI.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.CLI.Commands.GroupCommands.RemoveGroupMemberCommand;
import main.java.CLI.Commands.RecipeBookCommands.AddToRecipeBookCommand;
import main.java.CLI.Commands.RecipeBookCommands.EnterRecipeBookCommand;
import main.java.CLI.Commands.RecipeBookCommands.ListRecipeBookCommand;
import main.java.CLI.Commands.RecipeBookCommands.RemoveRecipeCommand;
import main.java.CLI.Commands.RecipeViewerCommands.EnterRecipeViewerCommand;
import main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterRecipeBookCommand;
import main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveFilterCommand;
import main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSortCommand;
import main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands.SortRecipeBookCommand;
import main.java.CLI.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.CLI.Commands.UserPreferencesCommands.RateRecipeCommand;
import main.java.CLI.Commands.UserPreferencesCommands.UpdateIncludeCommand;
import main.java.CLI.Commands.UserPreferencesCommands.UpdateOmitCommand;
import main.java.CLI.Commands.UserPreferencesCommands.UpdatePreferencesCommand;

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
                    new UpdatePreferencesCommand(),
                    new EnterManageGroupCommand()
            }
    );

    Page recipeViewer = new Page(
            signedIn,
            new Command[]  {
                    new GetNewRecipeCommand(),
                    new RateRecipeCommand(), //remove this
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

    Page manageGroup = new Page(
            signedIn,
            new Command[] {
                    new CreateGroupCommand(),
                    new AddGroupMemberCommand(),
                    new RemoveGroupMemberCommand()
            }
    );

    Page updatePreferences = new Page(
            signedIn,
            new Command[] {
                    new UpdateOmitCommand(),
                    new UpdateIncludeCommand(),
                    new GoBackCommand(),
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
    public void setUpdatePreferences() {
        setPage(updatePreferences);
    }
    public void manageGroup() { setPage(manageGroup); }
    public void goBack() {
        setPage(currentPage.getParent());
    }
    public Command[] getAvailableCommands() {
        return currentPage.getAvailableCommands();
    }
}

