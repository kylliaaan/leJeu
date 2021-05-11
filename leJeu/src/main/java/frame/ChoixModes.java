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

public class ChoixModes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixModes frame = new ChoixModes();
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
	public ChoixModes() {
		setTitle("A la recherche du sopra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choisissez un mode  : ");
		lblNewLabel.setBounds(119, 25, 133, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Aventure");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aventure aV = new Aventure();
				aV.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(41, 91, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Multijoueur");
		btnNewButton_1.setBounds(253, 91, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Se d\u00E9connecter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil aC = new Accueil();
				aC.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(139, 171, 124, 23);
		contentPane.add(btnNewButton_2);
	}

}
