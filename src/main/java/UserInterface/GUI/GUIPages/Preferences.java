package main.java.UserInterface.GUI.GUIPages;

import main.java.Gateways.UserCSVReader;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateDietCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateIncludeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateOmitCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

import java.awt.Font;

public class Preferences {
    public JFrame preferences;

    public Preferences() {
        initialize();
    }

    private void initialize() {
        preferences = new JFrame();
        preferences.setBounds(100, 100, 450, 300);
        preferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        preferences.setTitle("Recipick");
        preferences.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Preferences");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 10, 170, 41);
        preferences.getContentPane().add(label);

        // view saved preferences
        JButton viewSavedPreferences = GUIForm.createButtonFromCommand(new ViewPreferencesCommand());
        viewSavedPreferences.setBounds(115, 50, 220, 23);
        preferences.getContentPane().add(viewSavedPreferences);

        // modify include
        JButton include = GUIForm.createButtonFromCommand(new UpdateIncludeCommand());
        include.setBounds(115, 90, 220, 23);
        preferences.getContentPane().add(include);

        // modify omit
        JButton omit = GUIForm.createButtonFromCommand(new UpdateOmitCommand());
        omit.setBounds(115, 130, 220, 23);
        preferences.getContentPane().add(omit);

        // modify diet
        JButton diet = GUIForm.createButtonFromCommand(new UpdateDietCommand());
        diet.setBounds(125, 170, 200, 23);
        preferences.getContentPane().add(diet);

        // back button
        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            preferences.setVisible(false);
            GUIForm.menu.setVisible();
        });

        btnBack.setBounds(150, 210, 150, 23);
        preferences.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        preferences.getContentPane().add(img);
    }

    public void setVisible() {
        preferences.setVisible(true);
    }

}


