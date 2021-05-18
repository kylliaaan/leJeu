package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Aventure{

	
	public static JFrame jf;


	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame Aventure() {
		
		 
		jf = new JFrame("A LA RECHERCHE DU SOPRA");
		jf.setBounds(400, 200, 650, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AVENTURE : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(231, 71, 98, 29);
		jf.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Continuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(95, 205, 98, 23);
		jf.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Nouvelle Partie");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewGame.NewGame().setVisible(true);
				jf.dispose();
			}
		});
		btnNewButton_2.setBounds(351, 205, 128, 23);
		jf.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoixModes.ChoixModes().setVisible(true);;
				jf.dispose();
			}
		});
		btnNewButton_3.setBounds(503, 408, 89, 23);
		jf.getContentPane().add(btnNewButton_3);
	return jf;
	}

}
