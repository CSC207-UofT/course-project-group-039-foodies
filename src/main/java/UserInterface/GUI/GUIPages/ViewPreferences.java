package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

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
        JLabel lbltitle = new JLabel("Saved Preferences");
        lbltitle.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbltitle.setBounds(170, 63, 200, 23);
        viewPreferences.getContentPane().add(lbltitle);

        JLabel ingredients = new JLabel("Ingredients to Include:");
        ingredients.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ingredients.setBounds(55, 119, 300, 23);
        viewPreferences.getContentPane().add(ingredients);

        JLabel omit = new JLabel("Ingredients to Omit:");
        omit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        omit.setBounds(55, 159, 300, 23);
        viewPreferences.getContentPane().add(omit);


        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            viewPreferences.setVisible(false);
            GUIForm.preferences.setVisible(true);

        });

//        JLabel img = new JLabel("New image");
//        img.setIcon(new ImageIcon("src/food background.jpeg"));
//        img.setBounds(0, 0, 460, 300);
//        viewPreferences.getContentPane().add(img);

        btnBack.setBounds(150, 210, 150, 23);
        viewPreferences.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        viewPreferences.setVisible(true);
    }
}

