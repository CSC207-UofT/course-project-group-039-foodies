package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * allows user to update their diet prefrerences.
 */
public class UpdateDietCommand extends Command {

    List<String> pescatarian = Arrays.asList("chicken", "beef", "pork", "lamb", "steak");
    List<String> vegetarian = Arrays.asList("fish", "salmon", "tuna", "tilapia");
    List<String> vegan = Arrays.asList("milk", "eggs", "honey", "cheese", "yogurt", "cream", "mayonnaise");

    public UpdateDietCommand() {
        super("update diet preferences", "Choose a diet to adhere to");
    }
    @Override
    public void runAction(UserInterface UI) {
        String diet = UI.queryUser(
                "Which diet would you like to adhere to? Options: Vegetarian, Vegan, Pescatarian, No Diet"
        );
        PreferenceBookCSVReader instance = PreferenceBookCSVReader.getInstance();

        //cases for adding different diets
        switch (diet) {
            case "Pescatarian":
                //creating list of ingredients to remove; not part of pesc diet
                List<String> RemoveFromDiet = new ArrayList<>();
                RemoveFromDiet.addAll(vegetarian);
                RemoveFromDiet.addAll(vegan);

                //update csv file
                instance.updateDiet(UI.getUser().getUsername(), "Pescatarian", UI.getPreferenceBook().getDiet());
                changeDiet(pescatarian, RemoveFromDiet, UI, instance);

                break;

            case "Vegetarian":
                //creating list for vegetarian diet
                List<String> VegAddToDiet = new ArrayList<>();
                VegAddToDiet.addAll(pescatarian);
                VegAddToDiet.addAll(vegetarian);

                //update csv file
                instance.updateDiet(UI.getUser().getUsername(), "Vegetarian", UI.getPreferenceBook().getDiet());
                changeDiet(VegAddToDiet, vegan, UI, instance);

                break;

            case "Vegan":
                //creating list for vegan diet
                List<String> VeganAddToDiet = new ArrayList<>();
                VeganAddToDiet.addAll(pescatarian);
                VeganAddToDiet.addAll(vegetarian);
                VeganAddToDiet.addAll(vegan);

                //empty list to remove
                List<String> VeganRemFromDiet = new ArrayList<>();

                //update csv
                instance.updateDiet(UI.getUser().getUsername(), "Vegan", UI.getPreferenceBook().getDiet());
                changeDiet(VeganAddToDiet, VeganRemFromDiet, UI, instance);

                break;

            case "No Diet":
                //empty list to 'add'
                List<String> NDAddToDiet = new ArrayList<>();

                //list of dietary restrictions to remove
                List<String> NDRemFromDiet = new ArrayList<>();
                NDRemFromDiet.addAll(pescatarian);
                NDRemFromDiet.addAll(vegetarian);
                NDRemFromDiet.addAll(vegan);

                //update csv
                instance.updateDiet(UI.getUser().getUsername(), "No Diet", UI.getPreferenceBook().getDiet());
                changeDiet(NDAddToDiet, NDRemFromDiet, UI, instance);

                break;

            default:
                UI.displayMessage("This option does not exist");
                break;
        }
        UI.buildPreferences(PreferenceBookCSVReader.getInstance().getPreferenceBook(UI.getUser().getUsername()));
    }

    public void changeDiet(List<String> AddToDiet, List<String> RemoveFromDiet, UserInterface UI, PreferenceBookCSVReader instance) {
        if (!AddToDiet.isEmpty()) {
            for (String i : AddToDiet) {
                if (!UI.getPreferenceBook().contains("omit", i)) {
                    instance.updateOmit(UI.getUser().getUsername(), "add", i);
                }
            }
        }

        if (!RemoveFromDiet.isEmpty()) {
            for (String j : RemoveFromDiet) {
                if (UI.getPreferenceBook().contains("omit", j)) {
                    instance.updateOmit(UI.getUser().getUsername(), "remove", j);
                }
            }
        }

        UI.displayMessage("Diet preference successfully updated");
    }
}
