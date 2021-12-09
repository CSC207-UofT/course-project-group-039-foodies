package main.java.UserInterface.GUI.GUIPages;

import main.java.Entities.SubRecipeBook;
import main.java.Entities.User;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.EnterSubRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.ListSubRecipeBooksCommand;
import main.java.UserInterface.GUI.Application;
import main.java.UserInterface.GUI.GUIForm;
import main.java.UserInterface.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewAllSubRecipeBooks {
    public JFrame showSubRecipeBooks;

    /**
     * Initialise ViewAllSubRecipeBooks.
     */
    public ViewAllSubRecipeBooks() {initialize();}

    private void initialize() {
        showSubRecipeBooks = new JFrame();
        showSubRecipeBooks.setBounds(100, 100, 450, 300);
        showSubRecipeBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showSubRecipeBooks.setTitle("Recipick");
        showSubRecipeBooks.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("SubRecipeBooks");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(150, 20, 170, 41);
        showSubRecipeBooks.getContentPane().add(label);


        JButton btnViewAllSubRecipeBooks = GUIForm.createButtonFromCommand(new ListSubRecipeBooksCommand());
        btnViewAllSubRecipeBooks.setBounds(120, 50, 200, 23);
        showSubRecipeBooks.getContentPane().add(btnViewAllSubRecipeBooks);

//        JButton btnViewAllSubRecipeBooks = new JButton("View SubRecipeBooks");
//        btnViewAllSubRecipeBooks.addActionListener(e-> {
//
//        });

        btnViewAllSubRecipeBooks.setBounds(120, 50, 200, 23);
        showSubRecipeBooks.getContentPane().add(btnViewAllSubRecipeBooks);

        JButton btnEnterSubRecipeBook = GUIForm.createButtonFromCommand(new EnterSubRecipeBookCommand());
        btnEnterSubRecipeBook.addActionListener(e-> {
            GUIForm.showSubRecipes.setVisible(true);
            showSubRecipeBooks.setVisible(false);
        });
        btnEnterSubRecipeBook.setBounds(120, 100, 200, 23);
        showSubRecipeBooks.getContentPane().add(btnEnterSubRecipeBook);

        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.addActionListener(e -> {
            showSubRecipeBooks.setVisible(false);
            GUIForm.viewRecipeBook.setVisible(true);
        });
        btnGoBack.setBounds(160, 150, 100, 23);
        showSubRecipeBooks.getContentPane().add(btnGoBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showSubRecipeBooks.getContentPane().add(img);

    }

    public void setVisible(boolean b) {
        showSubRecipeBooks.setVisible(true);
    }
}
