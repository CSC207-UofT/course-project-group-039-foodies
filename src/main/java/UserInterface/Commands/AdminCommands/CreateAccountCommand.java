package main.java.UserInterface.Commands.AdminCommands;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.Gateways.UserCSVReader;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to create a new account
 */
public class CreateAccountCommand extends Command {
    public CreateAccountCommand() {
        super("create account", "Creates a new account");
    }

    /**
     * Create account.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String fullName = UI.queryUser("Input your Full Name");
        String username = UI.queryUser("Input your username");
        String password = UI.queryUser("Input your password");
        String email = UI.queryUser("Input your email");
        if (!UserCSVReader.getInstance().isUser(username)) {
            UserCSVReader.getInstance().addUser(username, password, fullName, email);
            PreferenceBookCSVReader.getInstance().addPreferenceBook(username);
            UI.displayMessage("The user has been created");
        } else {
            UI.displayMessage("The user cannot be created; the username is already taken");
        }
    }
}
