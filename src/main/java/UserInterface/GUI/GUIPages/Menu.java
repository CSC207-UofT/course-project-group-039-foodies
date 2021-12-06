package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

import java.awt.*;

public class Menu {
    public JFrame menu;

    public Menu() {
        initialize();
    }

    private void initialize() {
        menu = new JFrame();
        menu.setBounds(100, 100, 450, 300);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setTitle("Recipick");
        menu.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Menu");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
//        label.setForeground(Color.WHITE);
        label.setBounds(200, 20, 170, 41);
        menu.getContentPane().add(label);

        JButton btnPreferences = new JButton("Preferences");
        btnPreferences.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.preferences.setVisible(true);

        });
        btnPreferences.setBounds(150, 60, 150, 23);
        menu.getContentPane().add(btnPreferences);

        JButton btnNewRecipes = new JButton("New Recipes");
        btnNewRecipes.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.newRecipes.setVisible(true);

        });
        btnNewRecipes.setBounds(150, 100, 150, 23);
        menu.getContentPane().add(btnNewRecipes);

        JButton btnRecipeBook = new JButton("Recipe Book");
        btnRecipeBook.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.viewRecipeBook.setVisible(true);
        });
        btnRecipeBook.setBounds(150, 140, 150, 23);
        menu.getContentPane().add(btnRecipeBook);

        JButton btnGroups = new JButton("Groups");
        btnGroups.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.groups.setVisible(true);

        });
        btnGroups.setBounds(150, 180, 150, 23);
        menu.getContentPane().add(btnGroups);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> {
            menu.setVisible(false);
//                GUIForm.groups.setVisible(true);

        });

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        menu.getContentPane().add(img);

        btnExit.setBounds(150, 220, 150, 23);
        menu.getContentPane().add(btnExit);
    }

    public void setVisible(boolean b) {
        menu.setVisible(true);
    }
}
