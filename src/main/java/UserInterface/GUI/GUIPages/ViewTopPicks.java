package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.GUI.Application;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

/**
 * View top picks page.
 */
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
                    Command getNewRecipeCommand = new GetNewRecipeCommand();
                    getNewRecipeCommand.runAction(Application.getInstance());
                });
        viewRecipeButton(btnReady, viewTopPicks);
    }

    static void viewRecipeButton(JButton btnReady, JFrame viewTopPicks) {
        btnReady.setBounds(75, 70, 300, 100);
        viewRecipeContentPane(btnReady, viewTopPicks);
    }

    static void viewRecipeContentPane(JButton btnReady, JFrame viewTopPicks) {
        viewTopPicks.getContentPane().add(btnReady);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            viewTopPicks.setVisible(false);
            GUIForm.newRecipes.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        viewTopPicks.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewTopPicks.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        viewTopPicks.setVisible(true);
    }
}

