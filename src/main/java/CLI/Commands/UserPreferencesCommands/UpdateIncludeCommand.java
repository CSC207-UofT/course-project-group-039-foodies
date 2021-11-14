package main.java.CLI.Commands.UserPreferencesCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.PreferenceBook;
import main.java.Gateways.PreferenceBookCSVReader;

import java.util.Objects;
// possible usecase import

/**
 * allows user to update the list of ingredients they want to include in their recommended recipes.
 */
public class UpdateIncludeCommand extends Command {
    public UpdateIncludeCommand() {
        super("update included ingredients", "Remove or add ingredients to include list");
    }
    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Would you like to remove or add an ingredient to your list of included ingredients?");
        String AddOrRem = CLI.getTextInput();
        PreferenceBookCSVReader instance = PreferenceBookCSVReader.getInstance();
        if (Objects.equals(AddOrRem, "add")) {
            CLI.displayMessage("Enter ingredient to include in the recipe selection");
            String ingredient = CLI.getTextInput();
            if (CLI.getPreferenceBook().contains("include", ingredient)) {
                CLI.displayMessage("This ingredient is already included");
            } else {
                instance.updateInclude(CLI.getUser().getUsername(), AddOrRem, ingredient);
                CLI.displayMessage("List of included ingredients successfully updated");
            }
        } else {
            CLI.displayMessage("Enter ingredient to remove from list of included ingredients");
            String ingredient = CLI.getTextInput();
            if (!CLI.getPreferenceBook().contains("include", ingredient)) {
                CLI.displayMessage("This ingredient is not in your include list");
            } else {
                instance.updateInclude(CLI.getUser().getUsername(), AddOrRem, ingredient);
                CLI.displayMessage("List of included ingredients successfully updated");
            }
        }
        CLI.buildPreferences(PreferenceBookCSVReader.getInstance().getPreferenceBook(CLI.getUser().getUsername()));
        //update preference book

    }
}