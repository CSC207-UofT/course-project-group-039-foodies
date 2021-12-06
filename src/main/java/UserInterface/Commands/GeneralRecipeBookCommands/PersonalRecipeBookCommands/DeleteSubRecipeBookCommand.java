package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class DeleteSubRecipeBookCommand extends Command {

    public DeleteSubRecipeBookCommand() {
        super("delete subrecipebook", "deletes the subrecipe book with name provided");
    }

    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Please enter the name of the sub-recipe book to be deleted");
        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());

        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            recipebookmanager.removeSubRecipeBook(subRecipeBookName);
            RecipeBookCSVReader.getInstance().deleteSubRecipeBook(UI.getUser(), subRecipeBookName);
            UI.displayMessage("SubRecipeBook successfully deleted");
        } else {
            UI.displayMessage("The SubRecipeBook you want to delete does not exist. ");
        }
    }
}
