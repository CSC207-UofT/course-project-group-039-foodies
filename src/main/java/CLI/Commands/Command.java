package main.java.CLI.Commands;

import main.java.CLI.CommandLineInterface;

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
    public abstract void runAction(CommandLineInterface CLI);
}



