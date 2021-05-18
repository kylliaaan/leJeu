package frame;

import test.App;
import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelDeJeu {

	public static JFrame jf;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame PanelDeJeu() {

	jf = new JFrame("A LA RECHERCHE DU SOPRA");
	jf.setBounds(400, 200, 650, 300);
	jf.getContentPane().setLayout(null);
	
	String nom1 = null;
	
	if (App.joueur1.equals("Magicien")) {
		
		nom1 = "Magicien";
	}
	else if (App.joueur1.equals("Guerrier")){nom1 = "Guerrier";}
	
	String nom2 = null;
	
	if (App.joueur1.equals("Magicien")) {
		
		nom2 = "Magicien";
	}
	else if (App.joueur1.equals("Guerrier")){nom2 = "Guerrier";}
	
	
	JLabel lblNewLabel = new JLabel("Joueur 1  :"+nom1+" | "+App.joueur1.getpM()+" PM | "+App.joueur1.getpA()+" PA");
	lblNewLabel.setBounds(23, 11, 562, 14);
	jf.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Joueur 2  :"+nom2+" | "+App.joueur2.getpM()+" PM | "+App.joueur2.getpA()+" PA");
	lblNewLabel_1.setBounds(23, 36, 562, 14);
	jf.getContentPane().add(lblNewLabel_1);
	
	JButton btnNewButton = new JButton("ATTAQUE");
	btnNewButton.setBounds(83, 216, 89, 23);
	jf.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("New button");
	btnNewButton_1.setBounds(355, 182, 36, 23);
	jf.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton("<");
	btnNewButton_1_1.setBounds(306, 216, 36, 23);
	jf.getContentPane().add(btnNewButton_1_1);
	
	JButton btnNewButton_1_1_1 = new JButton("New button");
	btnNewButton_1_1_1.setBounds(355, 216, 36, 23);
	jf.getContentPane().add(btnNewButton_1_1_1);
	
	JButton btnNewButton_1_1_1_1 = new JButton(">");
	btnNewButton_1_1_1_1.setBounds(405, 216, 36, 23);
	jf.getContentPane().add(btnNewButton_1_1_1_1);
	
	JButton btnNewButton_2 = new JButton("QUITTER");
	btnNewButton_2.setBounds(537, 229, 89, 23);
	jf.getContentPane().add(btnNewButton_2);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(23, 81, 229, 113);
	jf.getContentPane().add(comboBox);

	




	return jf;
	}
}
