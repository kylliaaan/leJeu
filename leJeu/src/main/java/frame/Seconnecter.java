package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seconnecter extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seconnecter frame = new Seconnecter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Seconnecter() {
		setTitle("A la recherche du sopra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil aC = new Accueil();
				aC.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(233, 187, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Se connecter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChoixModes cM = new ChoixModes();
				cM.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(89, 187, 96, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Identifiant : ");
		lblNewLabel.setBounds(43, 105, 74, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe : ");
		lblNewLabel_1.setBounds(39, 147, 89, 14);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 144, 120, 20);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(138, 102, 120, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Connectez-vous : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(78, 11, 199, 60);
		panel.add(lblNewLabel_2);
	}
}
