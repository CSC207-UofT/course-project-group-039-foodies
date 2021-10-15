package main.java.CLI.Commands;

import main.java.CLI.CommandLineInterface;

public class EnterRecipeViewerCommand extends Command {
    public EnterRecipeViewerCommand() {
        super("enter recipe viewer", "Enters the recipe viewer");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().enterRecipeViewer();
    }
}

