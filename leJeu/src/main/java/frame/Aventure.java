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
		lblNewLabel.setBounds(174, 23, 98, 29);
		jf.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Continuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(70, 106, 98, 23);
		jf.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Nouvelle Partie");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewGame.NewGame().setVisible(true);
				jf.dispose();
			}
		});
		btnNewButton_2.setBounds(244, 106, 128, 23);
		jf.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoixModes.ChoixModes().setVisible(true);;
				jf.dispose();
			}
		});
		btnNewButton_3.setBounds(337, 229, 89, 23);
		jf.add(btnNewButton_3);
	return jf;
	}

}
