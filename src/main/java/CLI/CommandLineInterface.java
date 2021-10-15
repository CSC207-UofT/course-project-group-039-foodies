package main.java.CLI;

import java.util.*;

import main.java.CLI.Commands.Command;
import main.java.Entities.User;
import main.java.UseCases.DatabaseManager;

/**
 * The class responsible for handling input and output
 */
public class CommandLineInterface {
    public boolean isRunning;
    private final Scanner keyboard;
    private final DatabaseManager databaseManager;
    private User user;
    PageManager pageManager;

    public CommandLineInterface() {
        isRunning = true;
        pageManager = new PageManager();
        databaseManager = new DatabaseManager();
        user = null;
        keyboard = new Scanner(System.in);
    }

    /**
     * Updates the private attribute user, signing the new user in
     * @param user The User object representing the user to sign in
     */
    public void signIn(User user) {
        this.user = user;
    }

    /**
     * A getter for the current user
     * @return a User object representing the signed-in user
     */
    public User getUser() {
        return user;
    }

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

    public DatabaseManager getRecipeDatabase() {
        return databaseManager;
    }

    public PageManager getPageManager() {
        return pageManager;
    }
    /**
     * Parses the user's input, taking input from the keyboard
     * @return Returns the command the user called, and the commandNotFound command otherwise
     */
    private Command parseInput() {
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
}
