package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

public class ViewTopPicks {
    public JFrame viewTopPicks;

    public ViewTopPicks() {
        initialize();
    }

    private void initialize() {
        viewTopPicks = new JFrame();
        viewTopPicks.setBounds(100, 100, 450, 300);
        viewTopPicks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewTopPicks.setTitle("Recipick");
        viewTopPicks.getContentPane().setLayout(null);

        JButton btnReady = new JButton("Ready to see your Top Picks?");
        btnReady.addActionListener(e -> {
            viewTopPicks.setVisible(false);
//                GUIForm.new_recipes.setVisible(true);

        });
        btnReady.setBounds(75, 70, 300, 100);
        viewTopPicks.getContentPane().add(btnReady);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            viewTopPicks.setVisible(false);
            GUIForm.newRecipes.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        viewTopPicks.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        viewTopPicks.setVisible(true);
    }
}

