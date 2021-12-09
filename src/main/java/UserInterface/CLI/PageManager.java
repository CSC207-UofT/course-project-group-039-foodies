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

/**
 * Manages page.
 */
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
                    new ViewPreferencesCommand(),
                    new UpdateOmitCommand(),
                    new UpdateIncludeCommand(),
                    new UpdateDietCommand(),
                    new GoBackCommand(),
            }
    );

    Page currentPage = signedOut;

    /**
     * Set page to its current page.
     * @param page page
     */
    public void setPage(Page page) {
        currentPage = page;
    }

    /**
     * Find the command.
     * @param name name of the command.
     * @return found command.
     */
    public Command findCommand(String name) {
        return currentPage.findCommand(name);
    }

    /**
     * Set page to sign in page.
     */
    public void signIn() {
        setPage(signedIn);
    }

    /**
     * Set page to sign out page.
     */
    public void signOut() {
        setPage(signedOut);
    }

    /**
     * Set page to general recipe book.
     */
    public void enterGeneralRecipeBook() {
        setPage(generalRecipeBook);
    }

    /**
     * Set page to recipe book.
     */
    public void enterRecipeBook() {
        setPage(recipeBook);
    }

    /**
     * Set page to group recipe book.
     */
    public void enterGroupRecipeBook() {
        setPage(groupRecipeBook);
    }

    /**
     * Set page to sub-recipe book.
     */
    public void enterSubRecipeBook() {
        setPage(subRecipeBook);
    }

    /**
     * Set page to group sub-recipe book.
     */
    public void enterGroupSubRecipeBook() {
        setPage(groupSubRecipeBook);
    }

    /**
     * Set page to recipe viewer.
     */
    public void enterRecipeViewer() {
        setPage(recipeViewer);
    }

    /**
     * Set page to group recipe viewer.
     */
    public void enterGroupRecipeViewer() {
        setPage(groupRecipeViewer);
    }

    /**
     * Set page to preference book.
     */
    public void enterPreferenceBook() {
        setPage(preferenceBook);
    }

    /**
     * Set page to manage group.
     */
    public void manageGroup() {
        setPage(manageGroup);
    }

    /**
     * Set page to previous page.
     */
    public void goBack() {
        setPage(currentPage.getParent());
    }

    /**
     * Get available commands.
     * @return available commands.
     */
    public Command[] getAvailableCommands() {
        return currentPage.getAvailableCommands();
    }
}
