package main.java.CLI.Commands.AdminCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.UseCases.Utilities.UserManager;

/**
 * Allows the user to create a new account
 */
public class CreateAccountCommand extends Command {
    public CreateAccountCommand() {
        super("create account", "Creates a new account");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input your Full Name");
        String fullname = CLI.getTextInput();
        CLI.displayMessage("Input your username");
        String username = CLI.getTextInput();
        CLI.displayMessage("Input your email");
        String email = CLI.getTextInput();
        if (UserManager.addUser(fullname, username, email)) {
            CLI.displayMessage("The user has been created");
        } else {
            CLI.displayMessage("The user cannot be created; the username is already taken");
        }
    }
}
