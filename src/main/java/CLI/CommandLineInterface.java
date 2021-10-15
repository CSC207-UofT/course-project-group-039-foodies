package main.java.CLI;

import java.util.*;
import main.java.CLI.Pages.*;
import main.java.User;

/** The class responsible for handling input and output
 */
public class CommandLineInterface {
    public boolean isRunning;
    private final Scanner keyboard;
    private User user;
    Page currentPage;

    private CommandLineInterface() {
        isRunning = true;
        currentPage = new SignedOutPage(null);
        user = null;
        keyboard = new Scanner(System.in);
    }

    /** Changes the current page the user is on
     * @param newPage A Page object representing the page to change to
     */
    public void changePage(Page newPage) {
        currentPage = newPage;
    }

    /** Updates the private attribute user, signing the new user in
     * @param user The User object representing the user to sign in
     */
    public void signIn(User user) {
        this.user = user;
    }

    /** A getter for the current user
     * @return a User object representing the signed-in user
     */
    public User getUser() {
        return user;
    }

    /** Prints out a message to the user
     * @param message A String representing the message to be displayed
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /** Takes input from the user
     * @return a String representing user input
     */
    public String getTextInput() {
        return keyboard.nextLine();
    }

    /**
     * Returns all commands that the user can currently call
     * @return An array of command
     */
    public Command[] getCurrentCommands() {
        return currentPage.getAvailableCommands();
    }

    /**
     * Parses the user's input, taking input from the keyboard
     * @return Returns the command the user called, and the commandNotFound command otherwise
     */
    private Command parseInput() {
        String input = keyboard.nextLine();
        return currentPage.findCommand(input);
    }

    public static void main(String[] args) {
        CommandLineInterface CLI = new CommandLineInterface();
        while (CLI.isRunning) {
            Command calledCommand = CLI.parseInput();
            calledCommand.runAction(CLI);
        }
    }
}
