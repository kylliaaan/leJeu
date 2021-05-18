package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import menuPrincipal.Accueil;
import test.App;

public class ChoixModes extends JFrame {

	private JPanel contentPane;
	public static JFrame jf;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame ChoixModes() {
		 
		jf = new JFrame("A LA RECHERCHE DU SOPRA");
		jf.setBounds(400, 200, 650, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
			
		 
		
		
		JLabel lblNewLabel = new JLabel("Choisissez un mode  : ");
		lblNewLabel.setBounds(119, 25, 133, 29);
		jf.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Aventure");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aventure.Aventure().setVisible(true);
				jf.dispose();
			}
		});
		btnNewButton.setBounds(41, 91, 107, 23);
		jf.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Multijoueur");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				App.menuMulti();
				
			}
		});
		btnNewButton_1.setBounds(253, 91, 89, 23);
		jf.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SE DECONNECTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				Accueil.Accueil().setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(139, 171, 124, 23);
		jf.add(btnNewButton_2);
		return jf;
	}

}
