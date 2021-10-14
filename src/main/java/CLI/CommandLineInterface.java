package main.java.CLI;

import java.util.*;
import main.java.CLI.Pages.*;
import main.java.RecipeBookManager;
import main.java.RecipeManager;
import main.java.User;
import main.java.UserManager;

import static java.util.Map.entry;

public class CommandLineInterface {
    public boolean isRunning;
    private final Scanner keyboard;
    private User user;
    private final RecipeBookManager recipeBookManager;
    private final UserManager userManager;
    private final RecipeManager recipeManager;
    String currentPage;

    private CommandLineInterface() {
        currentPage = "SignedOut";
        user = null;
        keyboard = new Scanner(System.in);
        recipeBookManager = new RecipeBookManager();
        userManager = new UserManager();
        recipeManager = new RecipeManager();
    }

    Map<String, Page> pages = Map.ofEntries(
            entry("SignedOut", new SignedOutPage()),
            entry("SignedIn", new SignedInPage()),
            entry("RecipeBook", new RecipeBookPage()),
            entry("RecipeViewer", new RecipeViewerPage())
    );

    private void changePage(String startPage, String endPage) {
        if (currentPage.equals(startPage)) {
            currentPage = endPage;
        }
    }

    public void signIn(User user) {
        changePage("SignedOut", "SignedIn");
        this.user = user;
    }

    public void signOut() {
        changePage("SignedIn", "SignedOut");
    }

    public void enterRecipeBook() {
        changePage("SignedIn", "RecipeBook");
    }

    public void exitRecipeBook() {
        changePage("RecipeBook", "SignedIn");
    }

    public void enterRecipeViewer() {
        changePage("SignedIn", "RecipeViewer");
    }

    public void exitRecipeViewer() {
        changePage("RecipeViewer", "SignedIn");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public RecipeBookManager getRecipeBookManager() {
        return recipeBookManager;
    }

    public RecipeManager getRecipeManager() {
        return recipeManager;
    }

    public User getUser() {
        return user;
    }

    public String getTextInput() {
        return keyboard.nextLine();
    }

    /**
     * Returns all commands that the user can currently call
     * @return An array of command
     */
    public Command[] getCurrentCommands() {
        return pages.get(currentPage).getAvailableCommands();
    }

    /**
     * Parses the user's input, taking input from the keyboard
     * @return Returns the command the user called, and the commandNotFound command otherwise
     */
    private Command parseInput() {
        String input = keyboard.nextLine();
        return pages.get(currentPage).findCommand(input);
    }

    public static void main(String[] args) {
        CommandLineInterface CLI = new CommandLineInterface();
        while (CLI.isRunning) {
            Command calledCommand = CLI.parseInput();
            calledCommand.runAction(CLI);
        }
    }
}
