package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.UserInterface.Commands.GroupCommands.CreateGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.RemoveGroupMemberCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateDietCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateIncludeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.UpdateOmitCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

import java.awt.*;

public class EditPreferences {
    public JFrame editPreferences;

    public EditPreferences() {
        initialize();
    }

    private void initialize() {
        editPreferences = new JFrame();
        editPreferences.setBounds(100, 100, 450, 300);
        editPreferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editPreferences.setTitle("Recipick");
        editPreferences.getContentPane().setLayout(null);

        // saved preferences panel
        JLabel lbltitle = new JLabel("Edit Preferences");
        lbltitle.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbltitle.setBounds(170, 15, 200, 23);
        editPreferences.getContentPane().add(lbltitle);

        JButton include = GUIForm.createButtonFromCommand(new UpdateIncludeCommand());
        include.setBounds(115, 55, 220, 23);
        editPreferences.getContentPane().add(include);

        JButton omit = GUIForm.createButtonFromCommand(new UpdateOmitCommand());
        omit.setBounds(115, 95, 220, 23);
        editPreferences.getContentPane().add(omit);

        JButton diet = GUIForm.createButtonFromCommand(new UpdateDietCommand());
        diet.setBounds(125, 135, 200, 23);
        editPreferences.getContentPane().add(diet);

//        JTextField textField = new JTextField();
//        textField.setBounds(200, 121, 86, 20);
//        editPreferences.getContentPane().add(textField);
//        textField.setColumns(10);
//        textField.setText("");
//
//        JButton add = new JButton("Enter");
//        add.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        add.setBounds(290, 119, 70, 23);
//        editPreferences.getContentPane().add(add);
//
//        JTextField textField_1 = new JTextField();
//        textField_1.setBounds(200, 161, 86, 20);
//        editPreferences.getContentPane().add(textField_1);
//        textField_1.setColumns(10);
//
//        JButton add_omit = new JButton("Enter");
//        add_omit.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        add_omit.setBounds(290, 161, 70, 23);
//        editPreferences.getContentPane().add(add_omit);


        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            editPreferences.setVisible(false);
            GUIForm.preferences.setVisible(true);

        });

        btnBack.setBounds(150, 210, 150, 23);
        editPreferences.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        editPreferences.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        editPreferences.setVisible(true);
    }
}

