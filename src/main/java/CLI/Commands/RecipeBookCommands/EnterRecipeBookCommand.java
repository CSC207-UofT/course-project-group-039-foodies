package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.CLI.Commands.HelpCommand;

public class EnterRecipeBookCommand extends Command {
    public EnterRecipeBookCommand() {
        super("enter recipe book", "Enters the recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().enterRecipeBook();
        Command help = new HelpCommand();
        help.runAction(CLI);
    }
}
