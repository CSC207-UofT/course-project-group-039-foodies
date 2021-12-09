package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.RemoveRecipeCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.ListSubRecipeBookRecipesCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

public class GroupSubRecipeBook {
    public JFrame showGroupSubRecipeBook;

    public GroupSubRecipeBook() {
        initialize();
    }

    private void initialize() {
        showGroupSubRecipeBook = new JFrame();
        showGroupSubRecipeBook.setBounds(100, 100, 450, 300);
        showGroupSubRecipeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showGroupSubRecipeBook.setTitle("Recipick");
        showGroupSubRecipeBook.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Group Sub Recipe Book");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(165, 11, 170, 41);
        showGroupSubRecipeBook.getContentPane().add(label);

        // show recipes in sub-recipe book option
        JButton showAll = GUIForm.createButtonFromCommand(new ListSubRecipeBookRecipesCommand());
        showAll.setBounds(150, 90, 150, 23);
        showGroupSubRecipeBook.getContentPane().add(showAll);

        // remove recipes from the sub-recipe book option
        JButton removeRecipe = GUIForm.createButtonFromCommand(new RemoveRecipeCommand());
        removeRecipe.setBounds(150, 130, 150, 23);
        showGroupSubRecipeBook.getContentPane().add(removeRecipe);

        // go back option
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            showGroupSubRecipeBook.setVisible(false);
            GUIForm.groupRecipeBook.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        showGroupSubRecipeBook.getContentPane().add(btnBack);

        // background
        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showGroupSubRecipeBook.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        showGroupSubRecipeBook.setVisible(true);
    }
}
