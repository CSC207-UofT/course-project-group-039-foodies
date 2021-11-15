package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.Entities.RecipeBook;
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

//        RecipeBook recipebook = UI.getUser().getRecipeBook();
        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(UI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);

        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            recipebookmanager.removeSubRecipeBook(subRecipeBookName);
            RecipeBookCSVReader.getInstance().deleteSubRecipeBook(UI.getUser(), subRecipeBookName);
            UI.displayMessage("SubRecipeBook successfully deleted");
        } else {
            UI.displayMessage("The SubRecipeBook you want to delete does not exist. ");
        }
    }
}
