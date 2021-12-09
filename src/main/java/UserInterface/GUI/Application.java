package main.java.UserInterface.GUI;

import main.java.UserInterface.UserInterface;

import java.awt.*;

/**
 * Runs GUI of the program.
 */
public class Application extends UserInterface {
    private static final Application instance = new Application();

    protected Application() {
        super(null);
    }

    /**
     * Gets the instance.
     * @return instance of the Application.
     */
    public static Application getInstance() {
        return instance;
    }

    @Override
    public void displayMessage(String message) {
        GUIForm.displayMessage(message);
    }

    @Override
    public String queryUser(String message) {
        return GUIForm.queryUser(message);
    }

    /**
     * Runs Application.
     * @param args list of arguments.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> GUIForm.start.start.setVisible(true));
    }
}
