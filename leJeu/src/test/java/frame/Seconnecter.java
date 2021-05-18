package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menuPrincipal.Accueil;
import test.App;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Seconnecter {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	
	public static JFrame jf;
	private static JPasswordField passwordField_1;
	private static JTextField loginField_1;
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame Seconnecter() {
		
		jf = new JFrame("A LA RECHERCHE DU SOPRA");
		jf.setBounds(400, 200, 650, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONNECTEZ-VOUS :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(153, 82, 247, 45);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN : ");
		lblNewLabel_1.setBounds(63, 182, 49, 14);
		jf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setBounds(63, 267, 96, 14);
		jf.getContentPane().add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(203, 264, 96, 20);
		jf.getContentPane().add(passwordField_1);
		
		loginField_1 = new JTextField();
		loginField_1.setBounds(203, 179, 96, 20);
		jf.getContentPane().add(loginField_1);
		loginField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password="";
				for(char c : passwordField_1.getPassword())
				{
					password+=c;
				}
				App.seConnecter(loginField_1.getText(),password);
				jf.dispose();
			}
		});
		btnNewButton.setBounds(129, 356, 89, 23);
		jf.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RETOUR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				Accueil.Accueil().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(348, 356, 89, 23);
		jf.getContentPane().add(btnNewButton_1);
		
	return jf;	
	}

}
