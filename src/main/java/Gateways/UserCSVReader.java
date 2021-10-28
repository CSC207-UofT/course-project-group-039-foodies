package main.java.Gateways;

import main.java.Entities.User;

import java.util.ArrayList;

public class UserCSVReader extends CSVReader {
    private final static UserCSVReader instance = new UserCSVReader(); // a singleton

    public static UserCSVReader getInstance() {
        return instance;
    }

    protected UserCSVReader() {
        super(System.getProperty("user.dir")
                + "\\src\\main\\java\\Gateways\\databases\\users.csv",
                new String[]{"username", "password", "fullname", "email"});
    }

    public void addUser(User user, String password) {
        addUser(user.getUsername(), password, user.getFullname(), user.getEmail());
    }

    public void addUser(String username, String password, String fullName, String email) {
        ArrayList<String> userInfo = new ArrayList<>();

        userInfo.add(username);
        userInfo.add(password);
        userInfo.add(fullName);
        userInfo.add(email);

        writeLine(userInfo);
    }

    public boolean isUser(String username) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCorrectPassword(String username, String password) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                return line.get(1).equals(password);
            }
        }
        return false;
    }

    public User getUser(String username, String password) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username) && line.get(1).equals(password)) {
                return new User(line.get(2), line.get(0), line.get(3));
            }
        }
        return null;
    }

    public void removeUser(String username) {
        removeLine(username, "username");
    }
}
