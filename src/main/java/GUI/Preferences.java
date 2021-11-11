package main.java.GUI;

import main.java.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Preferences {
    public JFrame preferences;

    public Preferences() {
        initialize();
    }

    private void initialize() {
        preferences = new JFrame();
        preferences.setBounds(100, 100, 450, 300);
        preferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        preferences.setTitle("Recipick");
        preferences.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Preferences");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(200, 11, 170, 41);
        preferences.getContentPane().add(label);

        JButton viewSavedPreferences = new JButton("View Saved Preferences");
        viewSavedPreferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preferences.setVisible(false);
//                GUIForm.show_preferences.setVisible(true);

            }
        });
        viewSavedPreferences.setBounds(150, 50, 150, 23);
        preferences.getContentPane().add(viewSavedPreferences);

        JButton modifyPreferences = new JButton("Add/Edit Preferences");
        modifyPreferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preferences.setVisible(false);
//                GUIForm.add_preferences.setVisible(true);

            }
        });
        modifyPreferences.setBounds(150, 90, 150, 23);
        preferences.getContentPane().add(modifyPreferences);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preferences.setVisible(false);
                GUIForm.menu.setVisible(true);

            }
        });
        btnBack.setBounds(150, 210, 150, 23);
        preferences.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        preferences.setVisible(true);
    }
}
