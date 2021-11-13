package main.java.UserInterface.CLI;

import main.java.UserInterface.Commands.*;
import main.java.UserInterface.Commands.AdminCommands.*;
import main.java.UserInterface.Commands.AdminCommands.CreateAccountCommand;
import main.java.UserInterface.Commands.GroupCommands.EnterManageGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.CreateGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.UserInterface.Commands.GroupCommands.RemoveGroupMemberCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.AddToRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.EnterRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.ListRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.RemoveRecipeCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.EnterRecipeViewerCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.RateRecipeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdatePreferencesCommand;
import main.java.UserInterface.CLI.Page;

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
    public void manageGroup() { setPage(manageGroup); }
    public void goBack() {
        setPage(currentPage.getParent());
    }
    public Command[] getAvailableCommands() {
        return currentPage.getAvailableCommands();
    }
}

