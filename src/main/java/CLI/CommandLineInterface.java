package main.java.CLI;

import java.util.*;

import main.java.CLI.Commands.Command;
import main.java.Entities.PreferenceBook;
import main.java.Entities.RecipeCollection;
import main.java.Entities.User;

/**
 * The class responsible for handling input and output
 */
public class CommandLineInterface {
    public boolean isRunning;
    private final Scanner keyboard;
    private final PageManager pageManager;
    private User user;
    private RecipeCollection recipes;
    private PreferenceBook preferences;

    public CommandLineInterface(Scanner keyboard) {
        isRunning = true;
        pageManager = new PageManager();
        recipes = new RecipeCollection();
        user = null;
        preferences = null;
        this.keyboard = keyboard;
    }

    public CommandLineInterface() {
        this(new Scanner(System.in));
    }

    /**
     * Updates the private attribute user, signing the new user in
     * @param user The User object representing the user to sign in
     */
    public void signIn(User user) {
        this.user = user;
    }

    public void buildPreferences(PreferenceBook prefs) {
        this.preferences = prefs;
    }
    /**
     * A getter for the current user
     * @return a User object representing the signed-in user
     */
    public User getUser() {
        return user;
    }

    /**
     * A getter for the current preference book
     * @return A PreferenceBook object representing the current user's preference book
     */
    public PreferenceBook getPreferenceBook() { return preferences; }

    /**
     * Prints out a message to the user
     * @param message A String representing the message to be displayed
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Takes input from the user
     * @return a String representing user input
     */
    public String getTextInput() {
        return keyboard.nextLine();
    }

    public RecipeCollection getRecipeCollection() {
        return recipes;
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    /**
     * Parses the user's input, taking input from the keyboard
     * @return Returns the command the user called, and the commandNotFound command otherwise
     */
    public Command parseInput() {
        String input = keyboard.nextLine();
        return pageManager.findCommand(input);
    }

    public static void main(String[] args) {
        CommandLineInterface CLI = new CommandLineInterface();
        CLI.displayMessage("Welcome to Recipick! Type \"help\" to see is a list of commands.");
        while (CLI.isRunning) {
            Command calledCommand = CLI.parseInput();
            calledCommand.runAction(CLI);
        }
    }

    public void setRecipeCollection(RecipeCollection recipes) {
        this.recipes = recipes;
    }
}
