package main.java.UserInterface.Commands.AdminCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to sign out.
 */
public class SignOutCommand extends Command {
    public SignOutCommand() {
        super("sign out", "Signs out the current user");
    }

    /**
     * Sign out.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().signOut();
        UI.displayMessage("You have successfully signed out.");
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
