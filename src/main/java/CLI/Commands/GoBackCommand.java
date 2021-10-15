package main.java.CLI.Commands;

import main.java.CLI.CommandLineInterface;

public class GoBackCommand extends Command {
    public GoBackCommand() {
        super("go back", "Go back to the main page");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().goBack();
    }
}
