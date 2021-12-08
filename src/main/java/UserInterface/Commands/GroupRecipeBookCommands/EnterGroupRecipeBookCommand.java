package main.java.UserInterface.Commands.GroupRecipeBookCommands;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

public class EnterGroupRecipeBookCommand extends Command {
    public EnterGroupRecipeBookCommand() {
        super("enter group recipe book",
                "Enters the group recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterGroupRecipeBook();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
