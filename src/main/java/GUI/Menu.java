package main.java.GUI;

import main.java.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        label.setBounds(200, 11, 170, 41);
        menu.getContentPane().add(label);

        JButton btnPreferences = new JButton("Preferences");
        btnPreferences.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.preferences.setVisible(true);

        });
        btnPreferences.setBounds(150, 50, 150, 23);
        menu.getContentPane().add(btnPreferences);

        JButton btnNewRecipes = new JButton("New Recipes");
        btnNewRecipes.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.new_recipes.setVisible(true);

        });
        btnNewRecipes.setBounds(150, 90, 150, 23);
        menu.getContentPane().add(btnNewRecipes);

        JButton btnRecipeBook = new JButton("Saved Recipes");
        btnRecipeBook.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.show_recipes.setVisible(true);

        });
        btnRecipeBook.setBounds(150, 130, 150, 23);
        menu.getContentPane().add(btnRecipeBook);

        JButton btnGroups = new JButton("Groups");
        btnGroups.addActionListener(e -> {
            menu.setVisible(false);
            GUIForm.groups.setVisible(true);

        });
        btnGroups.setBounds(150, 170, 150, 23);
        menu.getContentPane().add(btnGroups);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> {
            menu.setVisible(false);
//                GUIForm.groups.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        menu.getContentPane().add(btnExit);
    }

    public void setVisible(boolean b) {
        menu.setVisible(true);
    }
}
