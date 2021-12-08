package main.java.UserInterface.Commands.AdminCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.Gateways.UserCSVReader;
import main.java.UserInterface.UserInterface;

public class SignInCommand extends Command {
    public SignInCommand() {
        super("sign in", "Signs into a user");
    }

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.queryUser("Enter your username");
        String password = UI.queryUser("Enter your password");

        if (UserCSVReader.getInstance().isUser(username)) {
            if (UserCSVReader.getInstance().isCorrectPassword(username, password)) {
                UI.signIn(UserCSVReader.getInstance().getUser(username));
                UI.getPageManager().signIn();
                UI.displayMessage("You have successfully signed in");

                Command help = new HelpCommand();
                help.runAction(UI);
            } else {
                UI.displayMessage("You have entered the wrong password");
            }
        } else {
            UI.displayMessage("The user does not exist");
        }
    }
}