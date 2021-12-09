package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.ListGroupRecipeBooksCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.RemoveGroupRecipeCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

/**
 * Group recipe page (Show Group Recipes).
 */
public class GroupRecipe {
    public JFrame showGroupRecipes;

    public GroupRecipe() {
        initialize();
    }

    private void initialize() {
        showGroupRecipes = new JFrame();
        showGroupRecipes.setBounds(100, 100, 450, 300);
        showGroupRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showGroupRecipes.setTitle("Recipick");
        showGroupRecipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Show Group Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(140, 11, 200, 41);
        showGroupRecipes.getContentPane().add(label);

        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            showGroupRecipes.setVisible(false);
            GUIForm.viewSavedRecipesByFilter.setVisible(true);
        });
        byFilter.setBounds(75, 50, 150, 23);
        showGroupRecipes.getContentPane().add(byFilter);

        JButton bySort = new JButton("By Sort");
        bySort.addActionListener(e -> {
            showGroupRecipes.setVisible(false);
            GUIForm.viewSavedRecipesBySort.setVisible(true);
        });
        bySort.setBounds(225, 50, 150, 23);
        showGroupRecipes.getContentPane().add(bySort);


        JButton showAll = GUIForm.createButtonFromCommand(new ListGroupRecipeBooksCommand());
        showAll.setBounds(150, 90, 150, 23);
        showGroupRecipes.getContentPane().add(showAll);

        JButton removeRecipe = GUIForm.createButtonFromCommand(new RemoveGroupRecipeCommand());
        removeRecipe.setBounds(150, 130, 150, 23);
        showGroupRecipes.getContentPane().add(removeRecipe);

        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            showGroupRecipes.setVisible(false);
            GUIForm.menu.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        showGroupRecipes.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showGroupRecipes.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        showGroupRecipes.setVisible(true);
    }
}
