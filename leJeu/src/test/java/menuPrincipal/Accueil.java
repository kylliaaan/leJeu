package menuPrincipal;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import frame.Credits;
import frame.NewCompte;
import frame.Seconnecter;
import test.App;

import java.awt.Font;

public class Accueil {
	
	public static JFrame jf;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame Accueil() {
		
		jf = new JFrame("A LA RECHERCHE DU SOPRA");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setBounds(400, 200, 650, 500);
		jf.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("SE CONNECTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seconnecter.Seconnecter().setVisible(true);
				jf.dispose();
				
			}
		});
		btnNewButton.setBounds(251, 208, 124, 53);
		jf.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("A la recherche du SOPRA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(197, 77, 215, 120);
		jf.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("CREDITS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits.Credits().setVisible(true);		
				jf.dispose();
			}
		});
		btnNewButton_1.setBounds(514, 418, 89, 23);
		jf.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CREER UN COMPTE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCompte.NewCompte().setVisible(true);	
				jf.dispose();
			}
		});
		btnNewButton_2.setBounds(239, 290, 147, 23);
		jf.getContentPane().add(btnNewButton_2);
		jf.setVisible(true);
	
	return jf;
	
	}

	
}
