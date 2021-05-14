package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewCompte extends JFrame{
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	public NewCompte() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue jeune Padawan ! ! !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 11, 264, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login : ");
		lblNewLabel_1.setBounds(21, 63, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password : ");
		lblNewLabel_2.setBounds(21, 101, 61, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm password : ");
		lblNewLabel_4.setBounds(21, 140, 105, 14);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(87, 217, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBounds(233, 217, 89, 23);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 98, 96, 20);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(139, 60, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(139, 140, 96, 20);
		panel.add(passwordField_1);
	}
}
