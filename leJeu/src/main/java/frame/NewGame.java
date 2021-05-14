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
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		rdbtnNewRadioButton_1.setBounds(132, 202, 111, 23);
		jf.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Assassin");
		rdbtnNewRadioButton_2.setBounds(132, 228, 111, 23);
		jf.getContentPane().add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel = new JLabel("Choisis ton soprasien :\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 24, 217, 14);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HP XXX | ATQ XX | PA XX | PM XX ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(299, 172, 228, 14);
		jf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HP XXX | ATQ XX | PA XX | PM XX ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(299, 206, 228, 14);
		jf.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("HP XXX | ATQ XX | PA XX | PM XX ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(299, 232, 228, 14);
		jf.getContentPane().add(lblNewLabel_1_2);
		return jf;
	}
}
