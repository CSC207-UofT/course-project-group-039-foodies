package main.java.Gateways;

import main.java.Entities.User;
import main.java.UseCases.UserFactory;

import java.util.ArrayList;

/**
 * Reads user CSV file.
 */
public class UserCSVReader extends CSVReader {
    private final static UserCSVReader instance = new UserCSVReader(
            System.getProperty("user.dir") + "/src/main/java/Gateways/databases/users.csv"
    );

    private final static UserCSVReader testInstance = new UserCSVReader(
            System.getProperty("user.dir") + "/src/test/java/GatewaysTests/usersTest.csv"
    );

    /**
     * Get instance of the UserCSVReader.
     * @return instance of the UserCSVReader.
     */
    public static UserCSVReader getInstance() {
        return instance;
    }

    /**
     * Get test instance of the UserCSVReader.
     * @return test instance of the UserCSVReader.
     */
    public static UserCSVReader getTestInstance() {
        return testInstance;
    }

    protected UserCSVReader(String path) {
        super(path, new String[]{"username", "password", "fullname", "email"});
    }

    /**
     * Adds a user to the database given the necessary information
     * @param username The username of the user being added
     * @param password The password of the user being added
     * @param fullName The full name of the user being added
     * @param email The email of the user being added
     */
    public void addUser(String username, String password, String fullName, String email) {
        ArrayList<String> userInfo = new ArrayList<>();

        userInfo.add(username);
        userInfo.add(password);
        userInfo.add(fullName);
        userInfo.add(email);

        writeLine(userInfo);
    }

    /**
     * Checks if a user exists with a certain username
     * @param username The user to check
     * @return A boolean representing whether there is a user
     */
    public boolean isUser(String username) {
        if (readFile().isEmpty()) { //for empty file case
            return false;
        }
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the password of a user is equal to a string
     * @param username The username to check
     * @param password The password being compared
     * @return Whether the inputted password is the password of the user
     */
    public boolean isCorrectPassword(String username, String password) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                return line.get(1).equals(password);
            }
        }
        return false;
    }

    /**
     * Returns a user with a certain username
     * @param username The username of the user
     * @return The user object with the right username and password
     */
    public User getUser(String username) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                return UserFactory.createUser(
                        line.get(2),
                        line.get(0),
                        line.get(3),
                        RecipeBookCSVReader.getInstance().getUserRecipeBook(username)
                );
            }
        }
        return null;
    }

    /**
     * @param username Removes a user with a certain username from the database
     */
    public void removeUser(String username) {
        removeLine(username, "username");
    }
}
