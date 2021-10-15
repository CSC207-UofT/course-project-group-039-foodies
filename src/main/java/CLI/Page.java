package main.java.CLI;

import main.java.CLI.Commands.*;

/**
 * Stores a page the user can enter.
 * The commands attribute stores the commands that the user can call when on the page,
 * on top of the two default commands HelpCommand and QuitCommand
 *
 * The parent attribute stores the Page the user came from, and is null when the user
 * starts on this page.
 */
public class Page {
    private Command[] commands;
    protected Page parent;

    public Page(Page parent) {
        this.parent = parent;
    }

    public Page(Page parent, Command[] commands) {
        this.parent = parent;
        this.commands = commands;
    }

    /**
     * Sets the commands that the page can use on top of the default commands.
     *
     * @param commands The array of commands to be used in the page
     */
    protected void setCommands(Command[] commands) {
        this.commands = commands;
    }

    /**
     * Gets the command with a certain name. If a command is not found, an instance of the
     * CommandNotFound command is returned
     *
     * @param name The name of the command
     * @return The command with the right name
     */
    public Command findCommand(String name) {
        for (Command command : getAvailableCommands()) {
            if (name.equals(command.getName())) {
                return command;
            }
        }

        // No command has been found
        return new CommandNotFound();
    }

    public Page getParent() {
        return parent;
    }

    /**
     * Gets all commands the can currently be called by the user, including the
     * two default commands QuitCommand and HelpCommand.
     *
     * @return An array of commands that can be called in the current page
     */
    public Command[] getAvailableCommands() {
        Command[] allCommands = new Command[2 + commands.length];
        // Allows the default commands to be called
        allCommands[0] = new HelpCommand();
        allCommands[1] = new QuitCommand();

        // Allows the page specific commands to be called
        System.arraycopy(commands, 0, allCommands, 2, commands.length);

        return allCommands;
    }
}