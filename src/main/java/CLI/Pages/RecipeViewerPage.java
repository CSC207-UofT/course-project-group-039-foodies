package main.java.CLI.Pages;

import main.java.CLI.Pages.Commands.GetNewRecipeCommand;
import main.java.CLI.Pages.Commands.RateRecipeCommand;

public class RecipeViewerPage extends Page {
    public RecipeViewerPage(Page parent) {
        super(parent);

        Command[] commands = {
                new GetNewRecipeCommand(),
                new RateRecipeCommand(),
                new GoBackCommand()
        };
        setCommands(commands);
    }
}
