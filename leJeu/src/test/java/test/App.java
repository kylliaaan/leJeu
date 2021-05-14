package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import metier.Attaque;
import metier.Carte;
import metier.Guerrier;
import metier.Magicien;
import metier.Personnage;
import util.Context;

public class App {

//	static List<Objet> inventaire = new ArrayList();
	
	static List<Attaque> attaque1 = new ArrayList();
	static List<Attaque> attaque2 = new ArrayList();
	static Attaque cDP = new Attaque(1, "coup_de_poing", "physique", 1, 5);
	static Attaque cDB = new Attaque(1, "coup_de_baton", "physique", 2, 10);
	static Attaque bM = new Attaque(5, "baguette_magique", "magique",1, 5);
	static Attaque bDF = new Attaque(8, "boule_de_feu", "magique", 4, 25);
	static Personnage joueur1 = null;
	static Personnage joueur2 = null;
	static int nombreJoueur = 1;
	int perso = 1;
		
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static void menuPrincipal() {
		
		System.out.println("Welcome to the jeu");
		System.out.println(" ");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Quitter");
		System.out.println("Choisir un menu");
		
		int choix= saisieInt("");
		switch(choix) 
		{
		case 1 : menuJeu();break;
		case 2 : System.exit(0);break;
		default : menuPrincipal();break;
		}
	}

	public static void seConnecter() {
//		String login =saisieString("Saisir votre login");
//		String password =saisieString("Saisir votre password");
//		String login =saisieString("Saisir votre login");
//		String password =saisieString("Saisir votre password");
//		Compte c=DAOCompte.seConnecter(login, password);
//		if(c instanceof Compte)
//		{
//			String msg=login+" s'est connecté le : "+LocalDateTime.now()+"\n";
//			ecrireFichier("connect.txt",msg);
//			menuJeu();
//		}
//		else 
//		{
//			String msg=login+" erreur de connexion le : "+LocalDateTime.now()+"\n";
//			ecrireFichier("errorConnect.txt",msg);
//			System.out.println("Identifiants invalides");
//		}
	}

	public static void menuJeu() {
		System.out.println(" ");
		System.out.println("1 - Aventure");
		System.out.println("2 - Multi");
		System.out.println("3 - Se deconnecter");
		
		int choix =saisieInt("Choix:");
		switch(choix) 
		{
		case 1 : menuAventure();break;
		case 2 : menuMulti();break;
		case 3 : menuPrincipal();break;
		default : menuJeu();break;
			}
	}
	
	public static void menuAventure() {	
		System.out.println("");
		System.out.println("Aventure");
		System.out.println("1 - Continuer");
		System.out.println("2 - Nouvelle partie");
		System.out.println("3 - Retour");
		
		int choix =saisieInt("Choix:");
		switch(choix) 
		{
		case 1 : retrouverPartie();jeuSolo();break;
		case 2 : choixPerso(1);jeuSolo();break;
		case 3 : menuJeu();break;
		default : menuAventure();break;
		}
	}
	
	public static void menuMulti() {	
		System.out.println("");
		System.out.println("Multi");
		System.out.println("1 - Local");
		System.out.println("2 - En ligne");
		System.out.println("3 - Retour");
		int choix =saisieInt("Choix:");
		switch(choix) 
		{
		case 1 : nombreJoueur = 2;choixPerso(1);choixPerso(2);jeuMulti();break;
		case 2 : choixPerso(1);jeuOnline();break;
		case 3 : menuJeu();break;
		default : menuMulti();break;
		}
	}
	
	
	public static void choixPerso(int perso) {	
		System.out.println("");
		System.out.println("Choix du personnage ");
		System.out.println("Pour le joueur "+perso+":");	
		System.out.println("1 - Guerrier");
		System.out.println("2 - Mage");
		System.out.println("3 - Shrek");
		int choix =saisieInt("Choix:");
		Personnage fantome=null;
		if (choix==1) {
			fantome = new Guerrier(0,0);
		}
		else if (choix==2) {
			fantome = new Magicien(0,0);
		}
		else if (choix==3) {
			System.out.println("Non");
			choixPerso(perso);
		}
		else {
			choixPerso(perso);
		}	
		
		if (perso==1) {joueur1=fantome;}
		else if (perso==2) {joueur2=fantome;}
		
		
		
	}
	
	public static void retrouverPartie() {
		
		jeuSolo();
	}
	
	public static void jeuSolo() {
		System.out.println("On a pas encore d'IA déso, ça arrive promis!");
		menuJeu();
	}
	
	public static void jeuOnline() {
		System.out.println("On a pas de online mdr tu t'es cru sur Fortnite?");
		menuJeu();
	}
	
	public static void jeuMulti() {
		Carte carte= new Carte("forêt",10,10);
		int maxPm1=joueur1.getpM();
		int maxPm2=joueur2.getpM();
		placer(joueur1,carte);
		placer(joueur2,carte);
		afficherCarte(carte);
		int alt=1;
		while (joueur1.gethP()>0&&joueur2.gethP()>0) {
			if (alt==1) {
				System.out.println("Joueur 1 :");
				joueur1.setpM(maxPm1);
				joueur1.setpA(joueur1.getpA()+2);
				tour(joueur1,carte);
				alt=2;
			}
			else {
				System.out.println("Joueur 2 :");
				joueur2.setpM(maxPm2);
				joueur2.setpA(joueur2.getpA()+2);
				tour(joueur2,carte);
				alt=1;
			}
		}
		int vainqueur=0;
		if (joueur1.gethP()<=0&&joueur2.gethP()<=0) {
			System.out.println("Egalité");
		}
		else {
			if(joueur1.gethP()<=0&&joueur2.gethP()>0) {
				vainqueur=1;
			}
			else if(joueur2.gethP()<=0&&joueur1.gethP()>0) {
				vainqueur=2;
			}
			System.out.println("Joueur "+vainqueur+" a gagné!");
		}
	}	
	
	private static void tour(Personnage j,Carte c) {
		boolean passer=false;
		while (passer==false &&	(j.getpA()>0 || j.getpM()>0)) {
			System.out.println("1-Attaquer (PA = "+j.getpA()+") | 2-Se déplacer (PM = "+j.getpM()+") | 3-Passer");
			int choix = saisieInt("");
			switch(choix) {
			case 1 : 
				if(j.getpA()<=0) {tour(j,c);}
				else{attaquer(j);};break;
			case 2 : 
				if(j.getpM()<=0) {tour(j,c);}
				else{deplacer(j,c);};break;	
			case 3 : passer=true;break;
			default : tour(j,c);break;}
		}
	}

	private static void deplacer(Personnage j,Carte c) {
		if (j.getpM()<=0) {System.out.println("Pas assez de PM");}
		while(j.getpM()>+0) {
			System.out.println("PM : "+j.getpM());
			int tab[][] = new int[c.getX()][c.getY()];
			tab[joueur1.getX()][joueur1.getY()]=1;
			if (nombreJoueur==2) {
			tab[joueur2.getX()][joueur2.getY()]=2;}
			obstacle(c);
			String direction = saisieString("Droite D | Gauche Q | Haut Z | Bas S | Retour R");
			direction.equalsIgnoreCase(direction);
			switch(direction) {
				case "S": if(tab[j.getX()+1][j.getY()]==0) {
					tab[j.getX()][j.getY()]=0;j.setX(j.getX()+1);j.setpM(j.getpM()-1);};break;
				case "Z": if(tab[j.getX()-1][j.getY()]==0) {
					tab[j.getX()][j.getY()]=0;j.setX(j.getX()-1);j.setpM(j.getpM()-1);};break;
				case "Q": if(tab[j.getX()][j.getY()-1]==0) {
					tab[j.getX()][j.getY()]=0;j.setY(j.getY()-1);j.setpM(j.getpM()-1);};break;
				case "D": if(tab[j.getX()][j.getY()+1]==0) {
					tab[j.getX()][j.getY()]=0;j.setY(j.getY()+1);j.setpM(j.getpM()-1);};break;
				case "R":tour(j,c);break;
			default : deplacer(j,c);break;}
			tab[joueur1.getX()][joueur1.getY()]=1;
			if (nombreJoueur==2) {
			tab[joueur2.getX()][joueur2.getY()]=2;}
			for (int[] ligne : tab) {
	            System.out.println(Arrays.toString(ligne));
	        }
		}
	}

	private static void attaquer(Personnage j) {
			afficherAttaques(j);
			int choix=saisieInt("");
			if(j==joueur1) {Attaque.calculDegat(joueur1,joueur2, attaque1.get(choix).getNomAttaque());}
			if(j==joueur2) {Attaque.calculDegat(joueur2,joueur1, attaque2.get(choix).getNomAttaque());}
			System.out.println("HP Joueur 1 : "+joueur1.gethP()+" | HP Joueur 2 : "+joueur2.gethP());
	}

	private static void afficherAttaques(Personnage j) {
		if(j==joueur1) {
			for (int i= 0; i<attaque1.size();i++) {	
				System.out.println((i+1)+" "+attaque1.get(i).getNomAttaque()+" |type: "+attaque1.get(i).getType()+" |dégats: "+attaque1.get(i).getDegats()+" |PA: "+attaque1.get(i).getpA()+" |portée: "+attaque1.get(i).getRange());
			}
		}
		if(j==joueur2) {
			for (int i= 1; i<attaque2.size();i++) {	
				System.out.println((i+1)+" "+attaque2.get(i).getNomAttaque()+" |type: "+attaque2.get(i).getType()+" |dégats: "+attaque2.get(i).getDegats()+" |PA: "+attaque2.get(i).getpA()+" |portée: "+attaque2.get(i).getRange());
			}
		}
	}

	public static void afficherCarte(Carte c) {
		int tabCarte[][] = new int[c.getX()][c.getY()];
		tabCarte[joueur1.getX()][joueur1.getY()]=1;
		if (nombreJoueur==2) {
		tabCarte[joueur2.getX()][joueur2.getY()]=2;}
		obstacle(c);
		for (int[] ligne : tabCarte) {
            System.out.println(Arrays.toString(ligne));
        }
	}
	private static void obstacle(Carte c) {
	}

	public static void placer(Personnage j,Carte c) {
		Carte carte= new Carte("forêt",10,10);
		int tabCarteP[][] = new int[carte.getX()][carte.getY()];
		obstacle(c);
		if (j==joueur1) {
        	System.out.println("Joueur 1 :");
        	tabCarteP[3][2]=1;
        	tabCarteP[4][1]=2;
        	tabCarteP[5][1]=3;
        	tabCarteP[6][2]=4;}
        else if (j==joueur2) {
        	System.out.println("Joueur 2 :");
        	tabCarteP[3][7]=1;
        	tabCarteP[4][8]=2;
        	tabCarteP[5][8]=3;
        	tabCarteP[6][7]=4;}
        for (int[] ligne : tabCarteP) {
            System.out.println(Arrays.toString(ligne));
        }
		int choix =saisieInt("Position de départ?(1/2/3/4)");
		int x=0;
		int y=0;
		if (j==joueur1) {
			switch(choix) 
			{
			case 1 :x=3;y=2;break;
			case 2 :x=4;y=1 ;break;
			case 3 :x=5;y=1 ;break;
			case 4 :x=6;y=2 ;break;
			default :placer(j,c);break;
			}
		}
		if (j==joueur2) {
			switch(choix) 
			{
			case 1 :x=3;y=7;break;
			case 2 :x=4;y=8 ;break;
			case 3 :x=5;y=8 ;break;
			case 4 :x=6;y=7 ;break;
			default :placer(j,c);break;
			}
		}
		j.setPosition(x, y);
	}
	
	public static void main(String[] args) {
//		int cpt=1;
//		Map<String,Personnage> listPerso = new HashMap();
//		listPerso.put("joueur"+cpt,new Guerrier(0,0));
//		cpt++;
//		listPerso.put("joueur"+cpt,new Magicien(0,0));
//		cpt++;
//			
//		for(int i=1;i<cpt;i++) 
//		{
//			System.out.println(listPerso.get("joueur"+i));
//		}
		/* attaque1.add(cDP);
		attaque2.add(cDP);
		attaque1.add(cDB);
		attaque2.add(cDB);
		attaque1.add(bM);
		attaque2.add(bM);
		attaque1.add(bDF);
		attaque2.add(bDF);
		menuPrincipal(); */
		
//		Accueil ac = new Accueil();
//		ac.setVisible(true);
//		User Martin= new User("martin","martin");
//		User Kyllian= new User("kyllian","kyllian");
//		User Louis= new User("louis","louis");
//		Context.get_instance().getDaoUser().save(Martin);
//		Context.get_instance().getDaoUser().save(Kyllian);
//		Context.get_instance().getDaoUser().save(Louis);
//		User u = Context.get_instance().getDaoUser().findById(2);
//		System.out.println(u);

//		Context.get_instance().getDaoPerso().save(new Guerrier(0,0));
//		Context.get_instance().getDaoPerso().save(new Magicien(0,0));
//		Personnage p = Context.get_instance().getDaoPerso().findById(2);
//		Context.get_instance().getDaoPerso().save(p);
//		System.out.println(p+"\n");
		
		Context.get_instance().getDaoAttaque().save(cDP);
//		Context.get_instance().getDaoAttaque().save(cDB);
//		Context.get_instance().getDaoAttaque().save(bM);
//		Context.get_instance().getDaoAttaque().save(bDF);
		
		Context.get_instance().getEmf().close();
		
		menuPrincipal();
		
		
	} 
}
	
	

