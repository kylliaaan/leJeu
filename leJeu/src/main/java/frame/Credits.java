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
		lblNewLabel.setBounds(143, 55, 292, 62);
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
		
		JLabel lblNewLabel_1 = new JLabel("MARTIN, LOUIS, KYLLIAN");
		lblNewLabel_1.setBounds(212, 151, 194, 14);
		jf.getContentPane().add(lblNewLabel_1);
		
		
		return jf;
	}

}
