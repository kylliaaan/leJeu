package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Accueil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public Accueil() {
		setTitle("A la recherche du sopra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// if pour vérifier la connexion
				
				Seconnecter sCT = new Seconnecter();
				sCT.setVisible(true);
				dispose();
				
				// else if renvoyer vers un pop up qui demande de réessayer ou de quitter ( aller à l'accueil)
				
				
			}
		});
		btnNewButton.setBounds(142, 116, 121, 49);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Credits");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits cD = new Credits();
				cD.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(337, 229, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("A la recherche du Sopra");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(67, 9, 269, 86);
		panel.add(lblNewLabel);
	}
}
