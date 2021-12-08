package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.GUI.Application;

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
            Command getNewRecipe = new GetNewRecipeCommand();
            getNewRecipe.runAction(Application.getInstance());
        });

        ViewTopPicks.viewRecipeButton(btnReady, viewByRandom);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewByRandom.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        viewByRandom.setVisible(true);
    }
}

