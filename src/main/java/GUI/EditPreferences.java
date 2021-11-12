package main.java.GUI;

import main.java.GUIForm;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        lbltitle.setBounds(170, 63, 200, 23);
        editPreferences.getContentPane().add(lbltitle);

        JLabel ingredients = new JLabel("Add Ingredient to Include:");
        ingredients.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ingredients.setBounds(55, 119, 300, 23);
        editPreferences.getContentPane().add(ingredients);

        JLabel omit = new JLabel("Add Ingredient to Omit:");
        omit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        omit.setBounds(55, 159, 300, 23);
        editPreferences.getContentPane().add(omit);

        JTextField textField = new JTextField();
        textField.setBounds(200, 121, 86, 20);
        editPreferences.getContentPane().add(textField);
        textField.setColumns(10);
        textField.setText("");

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(200, 161, 86, 20);
        editPreferences.getContentPane().add(textField_1);
        textField_1.setColumns(10);


        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            editPreferences.setVisible(false);
            GUIForm.preferences.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        editPreferences.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        editPreferences.setVisible(true);
    }
}

