package main.java.GUI;

import main.java.GUIForm;
import main.java.Gateways.UserCSVReader;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Signup {

    public JFrame frame1;

    /**
     * Create the sign-up page.
     */
    public Signup() {
        initialize();
    }

    /**
     * Initialize the contents of the frame1.
     */
    public void setVisible(boolean b) {
        frame1.setVisible(true);
    }
    private void initialize() {

        frame1 = new JFrame();
        frame1.setBounds(100, 100, 450, 350);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("Recipick");
        frame1.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Recipick");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(170, 11, 170, 41);
        frame1.getContentPane().add(label);

        // sign-up panel
        JLabel lblSignupScreen = new JLabel("Sign-up Screen");
        lblSignupScreen.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSignupScreen.setBounds(170, 63, 101, 23);
        frame1.getContentPane().add(lblSignupScreen);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmail.setBounds(55, 119, 64, 23);
        frame1.getContentPane().add(lblEmail);

        JTextField textField = new JTextField();
        textField.setBounds(130, 121, 86, 20);
        frame1.getContentPane().add(textField);
        textField.setColumns(10);
        textField.setText("");

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsername.setBounds(55, 159, 64, 23);
        frame1.getContentPane().add(lblUsername);

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(130, 161, 86, 20);
        frame1.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPassword.setBounds(55, 199, 64, 23);
        frame1.getContentPane().add(lblPassword);

        JPasswordField textField_2 = new JPasswordField();
        textField_2.setBounds(130, 201, 86, 20);
        frame1.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFullName.setBounds(55, 239, 64, 23);
        frame1.getContentPane().add(lblFullName);

        JTextField textField_3 = new JTextField();
        textField_3.setBounds(130, 241, 84, 20);
        frame1.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JButton btnSignup = new JButton("Sign Up");
        btnSignup.setBounds(260, 178, 89, 23);
        frame1.getContentPane().add(btnSignup);
        btnSignup.addActionListener(e -> {
                String email,user,fullName;
                char[] password;
                email = textField.getText();
                user = textField_1.getText();
                password = textField_2.getPassword();
                fullName = textField_3.getText();

                signUp(user, new String(password), fullName, email);
            });

        btnSignup.setBounds(260, 138, 89, 23);
        frame1.getContentPane().add(btnSignup);
    }

    private void signUp(String user, String password, String fullName, String email) {
        if (UserCSVReader.getInstance().isUser(user)) {
            JOptionPane.showMessageDialog(null, "The user cannot be created; the username is already taken");
        } else {
            UserCSVReader.getInstance().addUser(user, password, fullName, email);
            JOptionPane.showMessageDialog(null, "Sign Up Successful", "ALERT", JOptionPane.INFORMATION_MESSAGE);
            frame1.setVisible(false);
        }
    }
}