package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.Entities.RecipeBook;
import main.java.Entities.User;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class AddSubRecipeBookCommand extends Command {

    public AddSubRecipeBookCommand() {
        super("add a subrecipebook", "Adds a new sub recipe book to the user's recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Enter the name of the new sub recipe book");

        String subRecipeBookDesc = UI.queryUser("Enter a description for the new sub recipe book");

//        RecipeBook recipebook = UI.getUser().getRecipeBook();
//        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(UI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        recipebookmanager.addSubRecipeBook(subRecipeBookName, subRecipeBookDesc);

        User user = UI.getUser();
        String username = user.getUsername();
        if (!RecipeBookCSVReader.getInstance().isSubRecipeBook(username, subRecipeBookName)) {
            RecipeBookCSVReader.getInstance().addnewSubRecipeBook(user, subRecipeBookName, subRecipeBookDesc);
            UI.displayMessage("New SubRecipeBook with name " + subRecipeBookName + " and description " + subRecipeBookDesc
                    + " created successfully");
        } else {
            UI.displayMessage("A subrecipebook with the name " + subRecipeBookName + " already exists");
        }
    }
}
