package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Entities.User;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.Gateways.UserCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;

public class AddSubRecipeBookCommand extends Command {

    public AddSubRecipeBookCommand() {
        super("add a subrecipebook", "Adds a new sub recipe book to the user's recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the new sub recipe book");
        String subrecipebookname = CLI.getTextInput();

        CLI.displayMessage("Enter a description for the new sub recipe book");
        String subrecipebookdesc = CLI.getTextInput();

        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(CLI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        recipebookmanager.addSubRecipeBook(subrecipebookname, subrecipebookdesc);

        User user = CLI.getUser();
        String username = user.getUsername();
        if (!RecipeBookCSVReader.getInstance().isSubRecipeBook(username, subrecipebookname)) {
            RecipeBookCSVReader.getInstance().addnewSubRecipeBook(user, subrecipebookname, subrecipebookdesc);
            CLI.displayMessage("New SubRecipeBook with name " + subrecipebookname + " and description " + subrecipebookdesc
                    + " created successfully");
        } else {
            CLI.displayMessage("A subrecipebook with the name " + subrecipebookname + " already exists");
        }
    }
}
