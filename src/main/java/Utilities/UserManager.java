package main.java.Utilities;

import main.java.Entities.User;

import java.util.HashMap;

public class UserManager {
    static HashMap<String, User> userMap = new HashMap<>();

    /** Return whether a user with a certain username is in the userMap
     * @param username The username of the user
     * @return True if and only if user is in userMap
     */
    public static boolean containsUser(String username) {
        return userMap.containsKey(username);
    }

    /** Return whether a user is in the userMap
     * @param user The User object representing the user
     * @return True if and only if user is in userMap
     */
    public static boolean containsUser(User user) {
        return containsUser(user.getUsername());
    }

    /** Assuming that a user is contained in userMap, return the User with a certain username
     * @param username The username of the user to search for
     * @return The user object representing the required user
     */
    public static User getUser(String username) {
        return userMap.get(username);
    }

    /** Create a new user
     * @param fullname The name of the user
     * @param username The username of the user
     * @param email The email of the user
     * @return the created User
     */
    public static User createNewUser(String fullname, String username, String email) {
        return new User(fullname, username, email);
    }

    /** If the ID string does not appear as a key in userMap,
     * then add the pair to userMap.
     * @param user The user to be added
     * @return true if the user was successfully added to userMap,
     * and false otherwise.
     */
    public static boolean addUser(User user){
        String userName = user.getUsername();
        if (containsUser(user)) {
            return false;
        }
        else {
            userMap.put(userName, user);
            return true;
        }
    }

    /**
     * Adds a new user to userMap
     * @param fullname The name of the user
     * @param username The username of the user
     * @param email The email of the user
     * @return true if the user was successfully added to userMap,
     * and false otherwise.
     */
    public static boolean addUser(String fullname, String username, String email) {
        return addUser(createNewUser(fullname, username, email));
    }

    /** If the ID string appears as a key in userMap,
     * then remove the pair from userMap.
     * @param user The user object to be deleted
     * @return true if the user was successfully deleted from userMap,
     * and false otherwise.
    */
    public boolean deleteUser(User user) {
        String userName = user.getUsername();
        if ((userMap.containsKey(userName)) && userMap.get(userName).equals(user)) {
            userMap.remove(userName);
            return true;
        } else {
            return false;
        }
    }
}
