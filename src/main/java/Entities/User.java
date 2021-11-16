package main.java.Entities;

import java.util.Scanner;

public class User {
    /** Creates a User object */
    private final String fullname;
    private final String username;
    private final String email;
    private final RecipeBook recipeBook;

    /**
     * Creates a user with a name, username, email and  with code recipe code to the Recipe Book
     *
     * @param fullname - the user's first and last name
     * @param username - the user's unique username
     * @param email - the user's email address
     */

    public User(String fullname, String username, String email) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.recipeBook = new RecipeBook();
    }

    public User(String fullname, String username, String email, RecipeBook recipebook) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.recipeBook = recipebook;
    }
    /**
     * Returns the user's fullname
     * @return - fullname
     */
    public String getFullname() { return this.fullname; }

    /**
     * Returns the user's username
     * @return - return the username
     */

    public String getUsername() { return this.username; }

    /**
     * Returns the user's email address
     * @return - return the email address
     */

    public String getEmail() { return this.email; }

    /**
     * Returns the user's recipebook
     * @return - return the recipebook
     */

    public RecipeBook getRecipeBook() { return this.recipeBook; }

    /**
     * Users are prompted with messages from the command line.
     * Private attribute for a new instance of user are added using input from the command line.
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String fullname = keyboard.nextLine();
        System.out.print("Please enter your preferred username: ");
        String username = keyboard.nextLine();
        System.out.print("Please enter your email: ");
        String email = keyboard.nextLine();
        User user = new User(fullname, username, email) ;
    }
}