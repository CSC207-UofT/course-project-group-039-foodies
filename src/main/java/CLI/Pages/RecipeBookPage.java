package main.java.CLI.Pages;

import main.java.CLI.Pages.Commands.ListRecipeBookCommand;
import main.java.CLI.Pages.Commands.RateRecipeCommand;
import main.java.CLI.Pages.Commands.RemoveRecipeCommand;

public class RecipeBookPage extends Page {
    public RecipeBookPage(Page parent) {
        super(parent);

        Command[] commands = {
                new ListRecipeBookCommand(),
                new RemoveRecipeCommand(),
                new RateRecipeCommand(),
                new GoBackCommand()
        };
        setCommands(commands);
    }
}
