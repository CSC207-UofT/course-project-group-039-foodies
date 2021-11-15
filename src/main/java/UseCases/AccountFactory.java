package main.java.UseCases;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.Gateways.UserCSVReader;

/**
 * createAccount saves user details and creates empty PreferenceBooks and RecipeBooks for the user.
 */
public class AccountFactory {
    public static void createAccount(String username, String password, String fullname, String email) {
        UserCSVReader.getInstance().addUser(username, password, fullname, email);
        PreferenceBookCSVReader.getInstance().addPreferenceBook(username);
        //RecipeBookCSVReader.getInstance().addRecipeBook(username)  create empty recipe book
    }
}
