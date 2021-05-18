package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menuPrincipal.Accueil;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Credits{
	
	private static JPanel contentPane;
	public static JFrame jf;

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame Credits() {

		jf = new JFrame("A LA RECHERCHE DU SOPRA");
		jf.setBounds(400, 200, 650, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UN JEU CREER PAR :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 62, 292, 62);
		jf.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ACCUEIL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				Accueil.Accueil().setVisible(true);
			}
		});
		btnNewButton.setBounds(487, 405, 89, 23);
		jf.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("MARTIN, LOUIS & KYLLIAN");
		lblNewLabel_1.setBounds(198, 153, 194, 14);
		jf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\kylli\\Desktop\\Git\\Projet\\leJeu\\src\\main\\resources\\photo\\jA.png"));
		lblNewLabel_2.setBounds(78, 298, 108, 154);
		jf.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\"Promis je vous lib\u00E8re \u00E0 17h30\" ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 252, 241, 31);
		jf.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("- Jordan \u00E0 19h -");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(78, 279, 99, 44);
		jf.getContentPane().add(lblNewLabel_4);
		
		
		return jf;
	}

}
