package main.java.CLI.Pages;

import main.java.CLI.CommandLineInterface;

public class SignedOutPage extends Page {
    private static class CreateAccountCommand extends Command {
        private CreateAccountCommand() {
            super("create account", "Creates a new account");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.displayMessage("Input your new username");
            String username = CLI.getTextInput();
            CLI.getUserManager().createNewUser(username);
        }
    }

    private static class SignInCommand extends Command {
        private SignInCommand() {
            super("sign in", "Signs into a user");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.displayMessage("Enter your username");
            String username = CLI.getTextInput();
            if (CLI.getUserManager().isUser(username)) {
                CLI.signIn(CLI.getUserManager().getUser(username));
                CLI.getUserManager().signIn(username);
            } else {
                CLI.displayMessage("User does not exist");
            }
        }
    }

    public SignedOutPage() {
        super(new Command[]{
                new CreateAccountCommand(),
                new SignInCommand()
        });
    }
}
