package main.java.CLI.Commands.RecipeViewerCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.CLI.Commands.HelpCommand;
import main.java.Gateways.RecipeCSVReader;

public class EnterRecipeViewerCommand extends Command {
    public EnterRecipeViewerCommand() {
        super("enter recipe viewer", "Enters the recipe viewer");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().enterRecipeViewer();

        CLI.setRecipeCollection(RecipeCSVReader.getInstance().getRecipes());

        Command help = new HelpCommand();
        help.runAction(CLI);
    }
}

