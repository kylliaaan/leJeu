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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDeJeu {

	public static JFrame jf;
	static Personnage j = App.joueur1; // Gerer avec Martin 
	static String nom1 = null;
	static String nom2 = null;
	static String pasDePm = null;
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame PanelDeJeu() {

	jf = new JFrame("A LA RECHERCHE DU SOPRA");
	jf.setBounds(400, 200, 650, 250);
	jf.getContentPane().setLayout(null);
	
	if (App.joueur1.equals("Magicien")) {
		
		nom1 = "Magicien";
	}
	else if (App.joueur1.equals("Guerrier")){nom1 = "Guerrier";}

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
	
	
	JButton haut = new JButton("New button");
	haut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (j.getpM()<=0) {pasDePm = "Tu as 0 pm";}
			
			if(NewCarte.map[j.getX()-1][j.getY()]==0) {
				NewCarte.map[j.getX()][j.getY()]=0;j.setX(j.getX()-1);j.setpM(j.getpM()-1);}
		}
	});
	haut.setBounds(355, 105, 36, 23);
	jf.getContentPane().add(haut);
	
	JButton gauche = new JButton("<");
	gauche.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (j.getpM()<=0) {pasDePm = "Tu as 0 pm";}
			
			if(NewCarte.map[j.getX()][j.getY()-1]==0) {
				NewCarte.map[j.getX()][j.getY()]=0;j.setY(j.getY()-1);j.setpM(j.getpM()-1);}
		}
	});
	gauche.setBounds(309, 139, 36, 23);
	jf.getContentPane().add(gauche);
	
	JButton bas = new JButton("New button");
	bas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (j.getpM()<=0) {pasDePm = "Tu as 0 pm";}
			
			if(NewCarte.map[j.getX()+1][j.getY()]==0) {
				NewCarte.map[j.getX()][j.getY()]=0;j.setX(j.getX()+1);j.setpM(j.getpM()-1);}
		}
	});
	bas.setBounds(355, 139, 36, 23);
	jf.getContentPane().add(bas);
	
	JButton droite = new JButton(">");
	droite.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 if (j.getpM()<=0) {pasDePm = "Tu as 0 pm";}
			 /* while(j.getpM()>0) {
				int NewCarte.map[][] = new int[c.getX()][c.getY()];
				NewCarte.map[joueur1.getX()][joueur1.getY()]=1;
				NewCarte.map[joueur2.getX()][joueur2.getY()]=2;
				for ( int ln = 0; ln < c.getX(); ln++)
				{
					for ( int col = 0; col < c.getY(); col++) 
					{
						if (obstacles[ln][col]==1) {NewCarte.map[ln][col]=9;} //Obstacle haut
						else if (obstacles[ln][col]==2) {NewCarte.map[ln][col]=8;}}} //Obstacle bas */
			if(NewCarte.map[j.getX()][j.getY()+1]==0) {
				NewCarte.map[j.getX()][j.getY()]=0;j.setY(j.getY()+1);j.setpM(j.getpM()-1);}
		}
	});
	droite.setBounds(401, 139, 36, 23);
	jf.getContentPane().add(droite);
	
	JLabel lblNewLabel_2 = new JLabel(pasDePm);
	lblNewLabel_2.setBounds(253, 61, 122, 14);
	jf.getContentPane().add(lblNewLabel_2);
	
	
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
	
	JButton btnNewButton_1 = new JButton("Fin du tour");
	btnNewButton_1.setBounds(526, 105, 89, 23);
	jf.getContentPane().add(btnNewButton_1);
	
	return jf;
	}
}
