package main.java.GUI;

import main.java.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAllSavedRecipes {
    public JFrame viewAllSavedRecipes;

    public ViewAllSavedRecipes() {
        initialize();
    }

    private void initialize() {
        viewAllSavedRecipes = new JFrame();
        viewAllSavedRecipes.setBounds(100, 100, 450, 300);
        viewAllSavedRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewAllSavedRecipes.setTitle("Recipick");
        viewAllSavedRecipes.getContentPane().setLayout(null);


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewAllSavedRecipes.setVisible(false);
            GUIForm.show_recipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewAllSavedRecipes.getContentPane().add(btnExit);
    }

    public void setVisible(boolean b) {
        viewAllSavedRecipes.setVisible(true);
    }
}
