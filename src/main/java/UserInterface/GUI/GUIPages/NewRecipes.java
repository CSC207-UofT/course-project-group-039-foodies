package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.AddToGroupRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.AddToRecipeBookCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

/**
 * New Recipes page.
 */
public class NewRecipes {
    public JFrame newRecipes;

    public NewRecipes() {
        initialize();
    }

    private void initialize() {
        newRecipes = new JFrame();
        newRecipes.setBounds(100, 100, 450, 300);
        newRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newRecipes.setTitle("Recipick");
        newRecipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("New Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        newRecipes.getContentPane().add(label);

        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewRecipesByFilter.setVisible();

        });
        byFilter.setBounds(75, 50, 150, 23);
        newRecipes.getContentPane().add(byFilter);

        JButton bySort = new JButton("By Sort");
        bySort.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewRecipesBySort.setVisible();
        });
        bySort.setBounds(225, 50, 150, 23);
        newRecipes.getContentPane().add(bySort);

        JButton topPicks = new JButton("Top Picks");
        topPicks.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewTopPicks.setVisible();

        });
        topPicks.setBounds(150, 80, 150, 23);
        newRecipes.getContentPane().add(topPicks);

        JButton random = new JButton("Random");
        random.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewByRandom.setVisible();

        });
        random.setBounds(150, 120, 150, 23);
        newRecipes.getContentPane().add(random);

        JButton addToRecipeBook = GUIForm.createButtonFromCommand(new AddToRecipeBookCommand());
        addToRecipeBook.setBounds(150, 160, 150, 23);
        newRecipes.getContentPane().add(addToRecipeBook);


        JButton addToGroupRecipeBook = GUIForm.createButtonFromCommand(new AddToGroupRecipeBookCommand());
        addToGroupRecipeBook.setBounds(150, 200, 150, 23);
        newRecipes.getContentPane().add(addToGroupRecipeBook);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.menu.setVisible();

        });

        btnBack.setBounds(150, 240, 150, 23);
        newRecipes.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        newRecipes.getContentPane().add(img);
    }

    public void setVisible() {
        newRecipes.setVisible(true);
    }
}
