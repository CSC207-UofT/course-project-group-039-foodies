package main.java.CLI.Commands;

import main.java.CLI.CommandLineInterface;

public class SignOutCommand extends Command {
    public SignOutCommand() {
        super("sign out", "Signs out the current user");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().signOut();
        CLI.displayMessage("You have successfully signed out.");
    }
}
