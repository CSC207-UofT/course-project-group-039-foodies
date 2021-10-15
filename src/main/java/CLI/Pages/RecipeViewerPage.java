package main.java.CLI.Pages;

import main.java.CLI.Pages.Commands.AddToRecipeBookCommand;
import main.java.CLI.Pages.Commands.Command;
import main.java.CLI.Pages.Commands.GetNewRecipeCommand;
import main.java.CLI.Pages.Commands.RateRecipeCommand;

public class RecipeViewerPage extends Page {
    public RecipeViewerPage(Page parent) {
        super(parent);

        Command[] commands = {
                new GetNewRecipeCommand(),
                new RateRecipeCommand(),
                new AddToRecipeBookCommand(),
                new GoBackCommand()
        };
        setCommands(commands);
    }
}
