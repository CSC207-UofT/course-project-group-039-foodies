package main.java.UserInterface.Commands;

import main.java.UserInterface.UserInterface;

/**
 * Abstract command.
 */
public abstract class Command {
    String name;
    String description;

    /**
     * Initialize Command.
     * @param name name of the command.
     * @param description description of the command.
     */
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets name of the command.
     * @return name of the command.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Description of the command.
     * @return description of the command.
     */
    public String getDescription() {
        return description;
    }
    public abstract void runAction(UserInterface CLI);
}



