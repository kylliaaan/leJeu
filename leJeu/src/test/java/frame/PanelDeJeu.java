package frame;

import test.App;
import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;

import metier.Personnage;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelDeJeu {

	public static JFrame jf;
	static Personnage j = App.joueur1; 
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame PanelDeJeu() {

	jf = new JFrame("A LA RECHERCHE DU SOPRA");
	jf.setBounds(400, 200, 650, 250);
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
	
	
	JLabel lblNewLabel = new JLabel("Joueur 1  :"+nom1+" | "+App.joueur1.gethP()+" HP | "+App.joueur1.getpM()+" PM | "+App.joueur1.getpA()+" PA");
	lblNewLabel.setBounds(23, 11, 562, 14);
	jf.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Joueur 2  :"+nom2+" | "+App.joueur2.gethP()+" HP | "+App.joueur2.getpM()+" PM | "+App.joueur2.getpA()+" PA");
	lblNewLabel_1.setBounds(23, 36, 562, 14);
	jf.getContentPane().add(lblNewLabel_1);
	
	JButton btnNewButton = new JButton("ATTAQUE");
	btnNewButton.setBounds(85, 165, 89, 23);
	jf.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("New button");
	btnNewButton_1.setBounds(355, 105, 36, 23);
	jf.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton("<");
	btnNewButton_1_1.setBounds(309, 139, 36, 23);
	jf.getContentPane().add(btnNewButton_1_1);
	
	JButton btnNewButton_1_1_1 = new JButton("New button");
	btnNewButton_1_1_1.setBounds(355, 139, 36, 23);
	jf.getContentPane().add(btnNewButton_1_1_1);
	
	JButton btnNewButton_1_1_1_1 = new JButton(">");
	btnNewButton_1_1_1_1.setBounds(401, 139, 36, 23);
	jf.getContentPane().add(btnNewButton_1_1_1_1);
	
	JButton btnNewButton_2 = new JButton("QUITTER");
	btnNewButton_2.setBounds(526, 165, 89, 23);
	jf.getContentPane().add(btnNewButton_2);
	
	// public void 
	
	
	JComboBox comboBox = new JComboBox();
		
		switch(App.alt) {
		case 1 : comboBox.addItem(App.attaque1);  break;
		case 2 :  comboBox.addItem(App.attaque2) ;	break;	
		case 3 :  comboBox.addItem(App.attaque3) ; break;
		case 4 :  comboBox.addItem(App.attaque4); break;
		}
		
	comboBox.setSelectedItem(null);
	comboBox.setBounds(21, 96, 229, 41);
	jf.getContentPane().add(comboBox);

	




	return jf;
	}
}
