package main.java.UserInterface.Commands.RecipeViewerCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.Gateways.RecipeCSVReader;
import main.java.UserInterface.UserInterface;

public class EnterRecipeViewerCommand extends Command {
    public EnterRecipeViewerCommand() {
        super("enter recipe viewer", "Enters the recipe viewer");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterRecipeViewer();


        Command help = new HelpCommand();
        help.runAction(UI);
    }
}

