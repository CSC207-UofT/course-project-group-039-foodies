package main.java.CLI.Pages;

import main.java.CLI.Pages.Commands.*;

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
