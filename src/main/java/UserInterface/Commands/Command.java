package main.java.UserInterface.Commands;

import main.java.UserInterface.UserInterface;

public abstract class Command {
    String name;
    String description;
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public abstract void runAction(UserInterface CLI);
}



