package main.java.UserInterface.Commands.AdminCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

public class SignOutCommand extends Command {
    public SignOutCommand() {
        super("sign out", "Signs out the current user");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().signOut();
        UI.displayMessage("You have successfully signed out.");
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
