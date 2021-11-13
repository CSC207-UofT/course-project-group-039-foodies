package main.java.CLI;

import main.java.CLI.Commands.*;
import main.java.CLI.Commands.AdminCommands.*;
import main.java.CLI.Commands.AdminCommands.CreateAccountCommand;
import main.java.CLI.Commands.GroupCommands.EnterManageGroupCommand;
import main.java.CLI.Commands.GroupCommands.CreateGroupCommand;
import main.java.CLI.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.CLI.Commands.GroupCommands.RemoveGroupMemberCommand;
import main.java.CLI.Commands.RecipeBookCommands.*;
import main.java.CLI.Commands.RecipeViewerCommands.EnterRecipeViewerCommand;
import main.java.CLI.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.CLI.Commands.UserPreferencesCommands.RateRecipeCommand;
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
                    new RateRecipeCommand(),
                    new AddToRecipeBookCommand(),
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

