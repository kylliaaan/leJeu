package frame;

import java.awt.BorderLayout;
import java.awt.Container;
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

public class NewCompte {
	private static JPasswordField passwordField;
	private static JTextField textField;
	private static JPasswordField passwordField_1;
	public static JFrame jf;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame NewCompte() {
		
		
		jf = new JFrame("A LA RECHERCHE DU SOPRA");
		jf.setBounds(400, 200, 650, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Bienvenue jeune Padawan ! ! !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(177, 52, 264, 25);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login : ");
		lblNewLabel_1.setBounds(48, 143, 89, 14);
		jf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password : ");
		lblNewLabel_2.setBounds(48, 183, 125, 14);
		jf.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm password : ");
		lblNewLabel_4.setBounds(48, 227, 154, 14);
		jf.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(96, 334, 89, 23);
		jf.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBounds(434, 334, 89, 23);
		jf.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(252, 180, 96, 20);
		jf.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(252, 140, 96, 20);
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(252, 224, 96, 20);
		jf.getContentPane().add(passwordField_1);
		
		return jf;
	}

	
}
