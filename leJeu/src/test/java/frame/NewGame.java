package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;

public class NewGame{
	
	public static JFrame jf;


	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame NewGame() {
		
		jf = new JFrame("A LA RECHERCHE DU SOPRA");
		jf.setBounds(400, 200, 650, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Commence ta game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new NewCarte().start();
				PanelDeJeu.PanelDeJeu().setVisible(true);
			}
		});
		btnNewButton.setBounds(244, 313, 142, 23);
		jf.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				ChoixModes.ChoixModes().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(465, 389, 89, 23);
		jf.getContentPane().add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Guerrier");
		rdbtnNewRadioButton.setBounds(132, 167, 111, 23);
		jf.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Magicien");
		rdbtnNewRadioButton_1.setBounds(132, 198, 111, 23);
		jf.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Assassin");
		rdbtnNewRadioButton_2.setBounds(132, 228, 111, 23);
		jf.getContentPane().add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel = new JLabel("Choisis ton soprasien :\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 24, 217, 14);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HP 100 | ATQ 20 | PA 8 | PM 4 ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(263, 171, 228, 14);
		jf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HP 70 | ATQ 12 | PA 10 | PM 3 ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(263, 202, 228, 14);
		jf.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("HP 85 | ATQ 30 | PA 6 | PM 5 ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(263, 232, 228, 14);
		jf.getContentPane().add(lblNewLabel_1_2);
		return jf;
	}
}
