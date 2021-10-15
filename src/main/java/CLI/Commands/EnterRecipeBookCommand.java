package main.java.CLI.Commands;

import main.java.CLI.CommandLineInterface;

public class EnterRecipeBookCommand extends Command{
    public EnterRecipeBookCommand() {
        super("enter recipe book", "Enters the recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.getPageManager().enterRecipeBook();
    }
}
