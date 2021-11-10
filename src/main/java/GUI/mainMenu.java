package main.java.GUI;

import javax.swing.*;
import java.awt.event.*;

public class mainMenu {
    private JPanel panelMain;
    private JButton logInButton;
    private JButton signUpButton;
    private JTextField enteremail;
    private JPasswordField enterpassword;
    private JPanel loginPanel;
    private JTextField enteremail1;
    private JTextField enterusername1;
    private JPasswordField enterpassword1;
    private JPanel signupPanel;
    private JLabel emailprompt;
    private JLabel promptemail1;
    private JLabel promptusername1;
    private JLabel promptpassword1;
    private JLabel promptpassword;

    public mainMenu() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.setVisible(true);
                emailprompt.setVisible(true);
                enteremail.setVisible(true);
                promptpassword.setVisible(true);
                enterpassword.setVisible(true);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupPanel.setVisible(true);
                promptemail1.setVisible(true);
                enteremail1.setVisible(true);
                promptusername1.setVisible(true);
                enterusername1.setVisible(true);
                promptpassword1.setVisible(true);
                enterpassword1.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new mainMenu().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
