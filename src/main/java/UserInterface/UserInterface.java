package main.java.UserInterface;

import main.java.Entities.PreferenceBook;
import main.java.Entities.RecipeCollection;
import main.java.Entities.User;
import main.java.Gateways.RecipeCSVReader;
import main.java.UserInterface.CLI.PageManager;

abstract public class UserInterface {
    public boolean isRunning;
    private final PageManager pageManager;
    private User user;
    private RecipeCollection recipes;
    private PreferenceBook preferences;

    protected UserInterface(PageManager pageManager) {
        recipes = RecipeCSVReader.getInstance().getRecipes();
        this.pageManager = pageManager;
    }

    abstract public void displayMessage(String message);

    abstract public String queryUser(String message);


    /**
     * Updates the private attribute user, signing the new user in
     *
     * @param user The User object representing the user to sign in
     */
    public void signIn(User user) {
        this.user = user;
    }

    /**
     * A getter for the current user
     *
     * @return a User object representing the signed-in user
     */
    public User getUser() {
        return user;
    }

    public RecipeCollection getRecipeCollection() {
        return recipes;
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    public void setRecipeCollection(RecipeCollection recipes) {
        this.recipes = recipes;
    }

    public void buildPreferences(PreferenceBook prefs) {
        this.preferences = prefs;
    }

    /**
     * A getter for the current preference book
     * @return A PreferenceBook object representing the current user's preference book
     */
    public PreferenceBook getPreferenceBook() { return preferences; }
