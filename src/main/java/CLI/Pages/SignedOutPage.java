package main.java.CLI.Pages;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Pages.Commands.*;
import main.java.Utilities.UserManager;

public class SignedOutPage extends Page {
    public SignedOutPage(Page parent) {
        super(parent);

        Command[] commands = {
                new SignInCommand(),
                new CreateAccountCommand()
        };
        setCommands(commands);
    }

    private class SignInCommand extends Command {
        private SignInCommand() {
            super("sign in", "Signs into a user");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.displayMessage("Enter your username");
            String username = CLI.getTextInput();
            if (UserManager.containsUser(username)) {
                CLI.signIn(UserManager.getUser(username));
                CLI.changePage(new SignedInPage(SignedOutPage.this));
                CLI.displayMessage("You have successfully signed in");
            } else {
                CLI.displayMessage("The user does not exist");
            }
        }
    }
}
