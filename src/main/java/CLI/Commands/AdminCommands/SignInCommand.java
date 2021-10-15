package main.java.CLI.Commands.AdminCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.CLI.Commands.HelpCommand;
import main.java.UseCases.Utilities.UserManager;

public class SignInCommand extends Command {
    public SignInCommand() {
        super("sign in", "Signs into a user");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter your username");
        String username = CLI.getTextInput();
        if (UserManager.containsUser(username)) {
            CLI.signIn(UserManager.getUser(username));
            CLI.getPageManager().signIn();
            CLI.displayMessage("You have successfully signed in");

            Command help = new HelpCommand();
            help.runAction(CLI);
        } else {
            CLI.displayMessage("The user does not exist");
        }
    }
}
