package main.java.CLI.Pages;

import main.java.CLI.CommandLineInterface;

public class Page {
    private Command[] commands;

    public Page(Command[] commands) {
        this.commands = commands;
    }

    protected static class CommandNotFound extends Command {
        public CommandNotFound() {
            super("command not found", "This is the default command not found command");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.displayMessage("The inputted command is not found. Input \"help\" to see" +
                    " a list of available commands");
        }
    }

    protected static class HelpCommand extends Command {
        public HelpCommand() {
            super("help", "Displays the list of available commands");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.displayMessage("The following commands can be called:");
            for (Command command : CLI.getCurrentCommands()) {
                CLI.displayMessage(String.format("\"%s\" - %s%n", command.getName(), command.getDescription()));
            }
        }
    }

    protected static class QuitCommand extends Command {
        public QuitCommand() {
            super("quit", "Quits the program");
        }

        @Override
        public void runAction(CommandLineInterface CLI) {
            CLI.isRunning = false;
        }
    }

    public Command findCommand(String name) {
        for (Command command : getAvailableCommands()) {
            if (name.equals(command.getName())) {
                return command;
            }
        }
        return new CommandNotFound();
    }

    public Command[] getAvailableCommands() {
        Command[] allCommands = new Command[2 + commands.length];
        allCommands[0] = new HelpCommand();
        allCommands[1] = new QuitCommand();

        System.arraycopy(commands, 0, allCommands, 2, commands.length);

        return allCommands;
    }
}
