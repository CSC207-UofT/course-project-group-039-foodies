package main.java.CLI.Commands.RecipeViewerCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;

public class EnterRecipeViewerCommand extends Command {
    public EnterRecipeViewerCommand() {
        super("enter recipe viewer", "Enters the recipe viewer");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().enterRecipeViewer();
    }
}

