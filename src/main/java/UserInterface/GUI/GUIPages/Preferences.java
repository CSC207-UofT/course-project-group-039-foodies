package main.java.UserInterface.GUI.GUIPages;

import main.java.Gateways.UserCSVReader;
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
        label.setBounds(175, 11, 170, 41);
        preferences.getContentPane().add(label);

        // view saved preferences
        JButton viewSavedPreferences = new JButton("View Saved Preferences");
        viewSavedPreferences.addActionListener(e -> {
            preferences.setVisible(false);
            GUIForm.viewPreferences.setVisible(true);

        });
        viewSavedPreferences.setBounds(125, 50, 200, 23);
        preferences.getContentPane().add(viewSavedPreferences);

        // modify preferences
        JButton modifyPreferences = new JButton("Add/Edit Preferences");
        modifyPreferences.addActionListener(e -> {
            preferences.setVisible(false);
            GUIForm.editPreferences.setVisible(true);

        });

        modifyPreferences.setBounds(125, 90, 200, 23);
        preferences.getContentPane().add(modifyPreferences);

        // back button
        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            preferences.setVisible(false);
            GUIForm.menu.setVisible(true);

        });

        btnBack.setBounds(150, 210, 150, 23);
        preferences.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        preferences.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        preferences.setVisible(true);
    }

}


