package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.Application;
import main.java.UserInterface.GUI.GUIForm;
import main.java.UserInterface.UserInterface;

import javax.swing.*;

import java.awt.*;

public class ViewPreferences {
    public JFrame viewPreferences;

    public ViewPreferences() {
        initialize();
    }

    private void initialize() {
        viewPreferences = new JFrame();
        viewPreferences.setBounds(100, 100, 450, 300);
        viewPreferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPreferences.setTitle("Recipick");
        viewPreferences.getContentPane().setLayout(null);

        // saved preferences panel
        JLabel lbltitle = new JLabel("Preferences");
        lbltitle.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbltitle.setBounds(170, 63, 200, 23);
        viewPreferences.getContentPane().add(lbltitle);

        JLabel include = new JLabel("Ingredients to Include:");
        include.setFont(new Font("Tahoma", Font.PLAIN, 12));
        include.setBounds(55, 119, 300, 23);
        viewPreferences.getContentPane().add(include);

        JLabel omit = new JLabel("Ingredients to Omit:");
        omit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        omit.setBounds(55, 159, 300, 23);
        viewPreferences.getContentPane().add(omit);


        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            viewPreferences.setVisible(false);
            GUIForm.preferences.setVisible(true);

        });

        btnBack.setBounds(150, 210, 150, 23);
        viewPreferences.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewPreferences.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        viewPreferences.setVisible(true);
    }
}

