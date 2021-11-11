package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.GUIForm;
import main.java.Gateways.UserCSVReader;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame1.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Recipick");
		frame.getContentPane().setLayout(null);

		// title
		JLabel label = new JLabel("Recipick");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(170, 11, 170, 41);
		frame.getContentPane().add(label);

		// log-in panel
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoginScreen.setBounds(170, 63, 101, 23);
		frame.getContentPane().add(lblLoginScreen);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(55, 119, 64, 23);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(55, 159, 64, 23);
		frame.getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setBounds(130, 121, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("");

		textField_1 = new JPasswordField();
		textField_1.setBounds(130, 161, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String user;
//				char[] pass;
//				user = textField.getText();
//				pass = textField_1.getPassword();
//				String password = new String(pass);

//				if (UserCSVReader.getInstance().isUser(user, password)) {
//					if (UserCSVReader.getInstance().isCorrectPassword(user, password)) {
				JOptionPane.showMessageDialog(null,"Log In Successful","ALERT",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				GUIForm.menu.setVisible(true);

			}
		});
		btnLogin.setBounds(260, 138, 89, 23);
		frame.getContentPane().add(btnLogin);

	}
	public void setVisible(boolean b) {
		frame.setVisible(true);
	}
}