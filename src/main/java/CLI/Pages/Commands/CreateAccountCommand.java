package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Command;
import main.java.UserManager;

/**
 * Allows the user to create a new account
 */
public class CreateAccountCommand extends Command {
    public CreateAccountCommand() {
        super("create account", "Creates a new account");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input your new username");
        String username = CLI.getTextInput();
        UserManager.createNewUser(username);
        CLI.displayMessage("The user has been created");
    }
}
