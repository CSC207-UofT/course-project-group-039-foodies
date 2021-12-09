package main.java.UserInterface.CLI;

import java.util.*;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * The class responsible for handling input and output
 */
public class CommandLineInterface extends UserInterface {
    private final Scanner keyboard;

    /**
     * Initialize CommandLineInterface with Scanner keyboard.
     * @param keyboard keyboard
     */
    public CommandLineInterface(Scanner keyboard) {
        super(new PageManager());
        isRunning = true;
        this.keyboard = keyboard;
    }

    /**
     * Initialize CommandLineInterface with Scanner(System.in) of the CommandLineInterface.
     */
    public CommandLineInterface() {
        this(new Scanner(System.in));
    }

    /**
     * Prints out a message to the user
     *
     * @param message A String representing the message to be displayed
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Takes input from the user
     *
     * @return a String representing user input
     */
    public String getTextInput() {
        return keyboard.nextLine();
    }

    /**
     * Displays a message to the user, then takes input from the user
     *
     * @param message The message to display
     * @return The user input
     */
    public String queryUser(String message) {
        displayMessage(message);
        return getTextInput();
    }

    /**
     * Parses the user's input, taking input from the keyboard
     *
     * @return Returns the command the user called, and the commandNotFound command otherwise
     */
    public Command parseInput() {
        String input = keyboard.nextLine();
        return this.getPageManager().findCommand(input);
    }

    /**
     * Runs the CommandLineInterface.
     * @param args list of arguments
     */
    public static void main(String[] args) {
        CommandLineInterface CLI = new CommandLineInterface();
        CLI.displayMessage("Welcome to Recipick! Type \"help\" to see is a list of commands.");
        while (CLI.isRunning) {
            Command calledCommand = CLI.parseInput();
            calledCommand.runAction(CLI);
        }
    }
}
