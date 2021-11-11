package main.java.CLI.Commands.UserPreferencesCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.PreferenceBook;
import main.java.Gateways.PreferenceBookCSVReader;
import main.java.Gateways.UserCSVReader;

import java.util.Objects;
// possible usecase import

/**
 * allows user to update the list of ingredients they want to ommit from their recommended recipes.
 */
public class UpdateOmitCommand extends Command {
    public UpdateOmitCommand() {
        super("update omitted ingredients", "Removes or adds ingredients to omit list");
    }
    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Would you like to remove or add an ingredient to your list of omitted ingredients?");
        String AddOrRem = CLI.getTextInput();
        PreferenceBookCSVReader instance = PreferenceBookCSVReader.getInstance();
        if (Objects.equals(AddOrRem, "add")) {
            CLI.displayMessage("Enter ingredient to omit from recipe selection");
            String ingredient = CLI.getTextInput();
            if (CLI.getPreferenceBook().contains("omit", ingredient)) {
                CLI.displayMessage("This ingredient is already omitted");
            } else {
                 instance.updateOmit(CLI.getUser().getUsername(), AddOrRem, ingredient);
                 CLI.displayMessage("List of omitted ingredients successfully updated");
            }
        } else {
            CLI.displayMessage("Enter ingredient to remove from list of omitted ingredients");
            String ingredient = CLI.getTextInput();
            if (!CLI.getPreferenceBook().contains("omit", ingredient)) {
                CLI.displayMessage("This ingredient is not in your omit list");
            } else {
                instance.updateOmit(CLI.getUser().getUsername(), AddOrRem, ingredient);
                CLI.displayMessage("List of omitted ingredients successfully updated");
            }
        }
    }

}

