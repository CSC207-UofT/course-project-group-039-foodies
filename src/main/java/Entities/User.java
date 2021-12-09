package main.java.Entities;

public class User {
    /**
     * Creates a User object
     */
    private final String fullName;
    private final String userName;
    private final String eMail;
    private final RecipeBook recipeBook;

    /**
     * Creates a user with a name, username, and email.
     *
     * @param fullname - the user's first and last name
     * @param username - the user's unique username
     * @param email    - the user's email address
     */
    public User(String fullname, String username, String email) {
        this.fullName = fullname;
        this.userName = username;
        this.eMail = email;
        this.recipeBook = new RecipeBook();
    }

    /**
     * Creates a user with a name, username, email, and recipe book.
     * @param fullname full name of the user.
     * @param username username of the user.
     * @param email email of the user.
     * @param recipebook recipe book of the user.
     */
    public User(String fullname, String username, String email, RecipeBook recipebook) {
        this.fullName = fullname;
        this.userName = username;
        this.eMail = email;
        this.recipeBook = recipebook;
    }

    /**
     * Returns the user's fullname
     *
     * @return - fullname
     */
    public String getFullname() {
        return this.fullName;
    }

    /**
     * Returns the user's username
     *
     * @return - return the username
     */
    public String getUsername() {
        return this.userName;
    }

    /**
     * Returns the user's email address
     *
     * @return - return the email address
     */
    public String getEmail() {
        return this.eMail;
    }

    /**
     * Returns the user's recipebook
     *
     * @return - return the recipebook
     */
    public RecipeBook getRecipeBook() {
        return this.recipeBook;
    }
}
