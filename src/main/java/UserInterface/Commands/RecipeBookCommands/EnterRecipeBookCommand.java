package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

public class EnterRecipeBookCommand extends Command {
    public EnterRecipeBookCommand() {
        super("enter recipe book", "Enters the recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterRecipeBook();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
