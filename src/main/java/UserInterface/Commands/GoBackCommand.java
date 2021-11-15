package main.java.UserInterface.Commands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.UserInterface;

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
