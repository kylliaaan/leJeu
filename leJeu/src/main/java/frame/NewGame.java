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

public class NewGame extends JFrame {
	public NewGame() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Commence ta game");
		btnNewButton.setBounds(121, 193, 142, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(337, 229, 89, 23);
		panel.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Guerrier");
		rdbtnNewRadioButton.setBounds(40, 93, 111, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Magicien");
		rdbtnNewRadioButton_1.setBounds(40, 119, 111, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Assassin");
		rdbtnNewRadioButton_2.setBounds(40, 145, 111, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel = new JLabel("Choisis ton soprasien :\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 24, 217, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HP XXX | ATQ XX | PA XX | PM XX ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(121, 97, 228, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HP XXX | ATQ XX | PA XX | PM XX ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(121, 123, 228, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("HP XXX | ATQ XX | PA XX | PM XX ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(121, 149, 228, 14);
		panel.add(lblNewLabel_1_2);
	}
}
