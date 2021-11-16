package main.java.UserInterface.CLI;

import main.java.UserInterface.Commands.AdminCommands.CreateAccountCommand;
import main.java.UserInterface.Commands.AdminCommands.SignInCommand;
import main.java.UserInterface.Commands.AdminCommands.SignOutCommand;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.GoBackCommand;
import main.java.UserInterface.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.UserInterface.Commands.GroupCommands.CreateGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.EnterManageGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.RemoveGroupMemberCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.*;
import main.java.UserInterface.Commands.RecipeViewerCommands.EnterRecipeViewerCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveFilterCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSortCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.RateRecipeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateIncludeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateOmitCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdatePreferencesCommand;

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
                    new ListSubRecipeBooksCommand(),
                    new EnterSubRecipeBookCommand(),
                    new AddSubRecipeBookCommand(),
                    new DeleteSubRecipeBookCommand(),
                    new RemoveRecipeCommand(),
                    new GoBackCommand()
            }
    );
    
    Page subrecipeBook = new Page(
            recipeBook,
            new Command[] {
                    new ListSubRecipeBookRecipesCommand(),
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
    public void enterSubRecipeBook() {
        setPage(subrecipeBook);
    }
    public void enterRecipeViewer() {
        setPage(recipeViewer);
    }
    public void setUpdatePreferences() {
        setPage(updatePreferences);
    }
    public void manageGroup() {
        setPage(manageGroup);
    }
    public void goBack() {
        setPage(currentPage.getParent());
    }
    public Command[] getAvailableCommands() {
        return currentPage.getAvailableCommands();
    }
}
