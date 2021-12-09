package main.java.UserInterface.GUI.GUIPages;


import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.
        AddGroupSubRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.
        DeleteGroupSubRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.EnterGroupSubRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.
        ListGroupSubRecipeBooksCommand;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.EnterSubRecipeBookCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

/**
 * Group recipe book page (Group Recipe Books).
 */
public class GroupRecipeBook {
    public JFrame groupRecipeBook;

    public GroupRecipeBook() {
        initialize();
    }

    private void initialize() {
        groupRecipeBook = new JFrame();
        groupRecipeBook.setBounds(100, 100, 450, 300);
        groupRecipeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groupRecipeBook.setTitle("Recipick");
        groupRecipeBook.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Group Recipe Books");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(140, 11, 200, 41);
        groupRecipeBook.getContentPane().add(label);

        // option to add a sub recipe book
        JButton addSubRecipeBook = GUIForm.createButtonFromCommand(new AddGroupSubRecipeBookCommand());
        addSubRecipeBook.setBounds(115, 50, 230, 23);
        groupRecipeBook.getContentPane().add(addSubRecipeBook);

        // option to delete a sub recipe book
        JButton deleteSubRecipeBook = GUIForm.createButtonFromCommand(new DeleteGroupSubRecipeBookCommand());
        deleteSubRecipeBook.setBounds(115, 90, 230, 23);
        groupRecipeBook.getContentPane().add(deleteSubRecipeBook);

        // option to show all sub-recipe books in the group
        JButton showGroupSubRecipeBook = GUIForm.createButtonFromCommand(new ListGroupSubRecipeBooksCommand());
        showGroupSubRecipeBook.setBounds(130, 130, 200, 23);
        groupRecipeBook.getContentPane().add(showGroupSubRecipeBook);

        // option to enter a group sub-recipe book
        JButton enterGroupSubRecipeBook = GUIForm.createButtonFromCommand(new EnterGroupSubRecipeBookCommand());
        enterGroupSubRecipeBook.setBounds(130, 170, 200, 23);
        enterGroupSubRecipeBook.addActionListener(e -> {
            groupRecipeBook.setVisible(false);
            GUIForm.showGroupSubRecipeBook.setVisible(true);
        });
        groupRecipeBook.getContentPane().add(enterGroupSubRecipeBook);

        // option to go back
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            groupRecipeBook.setVisible(false);
            GUIForm.generalRecipeBook.setVisible();
        });
        btnBack.setBounds(150, 210, 150, 23);
        groupRecipeBook.getContentPane().add(btnBack);



    }

    public void setVisible(boolean b) {
        groupRecipeBook.setVisible(true);
    }
}
