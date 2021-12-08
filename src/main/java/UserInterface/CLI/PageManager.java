package main.java.UserInterface.CLI;

import main.java.UserInterface.Commands.AdminCommands.CreateAccountCommand;
import main.java.UserInterface.Commands.AdminCommands.SignInCommand;
import main.java.UserInterface.Commands.AdminCommands.SignOutCommand;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.GoBackCommand;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.*;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.*;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.EnterGeneralRecipeBookCommand;

import main.java.UserInterface.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.UserInterface.Commands.GroupCommands.CreateGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.EnterManageGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.RemoveGroupMemberCommand;
import main.java.UserInterface.Commands.GroupCommands.ViewGroupsCommand;
import main.java.UserInterface.Commands.GroupCommands.DeleteGroupCommand;

import main.java.UserInterface.Commands.RecipeViewerCommands.EnterGroupRecipeViewerCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.*;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewGroupRecipeCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.EnterRecipeViewerCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;

import main.java.UserInterface.Commands.UserPreferencesCommands.*;

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
                    new EnterGeneralRecipeBookCommand(),
                    new EnterRecipeViewerCommand(),
                    new EnterGroupRecipeViewerCommand(),
                    new SignOutCommand(),
                    new UpdatePreferencesCommand(),
                    new EnterManageGroupCommand()
            }
    );

    Page generalRecipeBook = new Page(
            signedIn,
            new Command[] {
                    new EnterRecipeBookCommand(),
                    new EnterGroupRecipeBookCommand(),
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

    Page groupRecipeBook = new Page(
            signedIn,
            new Command[] {
                    new ListGroupSubRecipeBooksCommand(),
                    new EnterGroupSubRecipeBookCommand(),
                    new AddGroupSubRecipeBookCommand(),
                    new DeleteGroupSubRecipeBookCommand(),
                    new RemoveGroupRecipeCommand(),
                    new GoBackCommand()
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

    Page groupRecipeViewer = new Page(
            signedIn,
            new Command[]{
                    new GetNewGroupRecipeCommand(),
                    new RateGroupRecipeCommand(), //remove this
                    new AddToGroupRecipeBookCommand(),
                    new SortGroupRecipeBookCommand(),
                    new FilterGroupRecipeBookCommand(),
                    new RemoveFilterCommand(),
                    new RemoveSortCommand(),
                    new GoBackCommand()
            }
    );

    Page subRecipeBook = new Page(
            recipeBook,
            new Command[] {
                    new ListSubRecipeBookRecipesCommand(),
                    new RemoveRecipeCommand(),
                    new RateRecipeCommand(),
                    new GoBackCommand()
            }
    );

    Page groupSubRecipeBook = new Page(
            groupRecipeBook,
            new Command[] {
                    new ListGroupSubRecipeBookRecipesCommand(),
                    new RemoveGroupRecipeCommand(),
                    new RateGroupRecipeCommand(),
                    new GoBackCommand()
            }
    );

    Page manageGroup = new Page(
            signedIn,
            new Command[] {
                    new CreateGroupCommand(),
                    new AddGroupMemberCommand(),
                    new RemoveGroupMemberCommand(),
                    new ViewGroupsCommand(),
                    new DeleteGroupCommand(),
                    new GoBackCommand()
            }
    );

    Page preferenceBook = new Page(
            signedIn,
            new Command[] {
                    new UpdateOmitCommand(),
                    new UpdateIncludeCommand(),
                    new UpdateDietCommand(),
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
    public void enterGeneralRecipeBook() { setPage(generalRecipeBook);}
    public void enterRecipeBook() {
        setPage(recipeBook);
    }
    public void enterSubRecipeBook() {
        setPage(subRecipeBook);
    }
  
    public void enterGroupRecipeBook() { setPage(groupRecipeBook); }
  
    public void enterGroupSubRecipeBook() { setPage(groupSubRecipeBook);}
    public void enterRecipeViewer() {
        setPage(recipeViewer);
    }
    public void enterGroupRecipeViewer() {
        setPage(groupRecipeViewer);
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
