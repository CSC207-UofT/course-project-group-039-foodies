package main.java.GUI;

import main.java.GUIForm;

import javax.swing.*;

public class ViewRecipesByRandom {
    public JFrame viewByRandom;

    public ViewRecipesByRandom() {
        initialize();
    }

    private void initialize() {
        viewByRandom = new JFrame();
        viewByRandom.setBounds(100, 100, 450, 300);
        viewByRandom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewByRandom.setTitle("Recipick");
        viewByRandom.getContentPane().setLayout(null);

        JButton btnReady = new JButton("Ready to see a random recipe?");
        btnReady.addActionListener(e -> {
            viewByRandom.setVisible(false);
//                GUIForm.new_recipes.setVisible(true);

        });
        btnReady.setBounds(75, 70, 300, 100);
        viewByRandom.getContentPane().add(btnReady);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            viewByRandom.setVisible(false);
            GUIForm.new_recipes.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        viewByRandom.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        viewByRandom.setVisible(true);
    }
}

