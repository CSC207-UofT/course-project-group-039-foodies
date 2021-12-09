package main.java.UserInterface.Commands;

import main.java.UserInterface.UserInterface;

/**
 * Allows user to go back to the main page.
 */
public class GoBackCommand extends Command {
    public GoBackCommand() {
        super("go back", "Go back to the main page");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().goBack();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
