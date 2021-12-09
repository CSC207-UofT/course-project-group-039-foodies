package main.java.UserInterface.Commands.GroupRecipeBookCommands;

import main.java.Entities.GroupSubRecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupCSVReader;

public class ListGroupSubRecipeBooksCommand extends Command {
    public ListGroupSubRecipeBooksCommand() {
        super("show group subrecipebooks", "show all the GroupSubRecipeBooks " +
                "contained in GroupRecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.ListGroupSubRecipeBooksCommand.getUsername(UI);
    }
}