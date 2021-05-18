package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import frame.ChoixModes;
import menuPrincipal.Accueil;
import metier.Assassin;
import metier.Attaque;
import metier.Bandit;
import metier.Carte;
import metier.Gobelin;
import metier.Guerrier;
import metier.Magicien;
import metier.Objet;
import metier.Personnage;
import metier.User;
import util.Context;

public class App {



	static User user = null;
	public static List<Attaque> attaque1 = new ArrayList();
	public static List<Attaque> attaque2 = new ArrayList();
	public static List<Attaque> attaque3 = new ArrayList();
	public static List<Attaque> attaque4 = new ArrayList();
	
	static List<Objet> inventaire1 = new ArrayList();
	static List<Objet> inventaire2 = new ArrayList();
	static List<Carte> cartes = new ArrayList();
	static Carte foret= new Carte("foret",10,10,7,7);
	static Carte grotte= new Carte("grotte",13,13,10,10);
	static Attaque cDP = new Attaque(1, "coup de poing", "physique", 1, 5);
	static Attaque cDB = new Attaque(2, "coup de baton", "physique", 2, 10);
	static Attaque bM = new Attaque(5, "baguette magique", "magique",1, 10);
	static Attaque bDF = new Attaque(8, "boule de feu", "magique", 4, 25);
	static Objet baton = new Objet("baton",0,10,0,1,0);
	static Objet baguetteMagique = new Objet("baguette magique",0,0,10,2,0);
	public static Personnage joueur1 = null;
	public static Personnage joueur2 = null;
	public static Personnage joueur3 = new Personnage(0);
	public static Personnage joueur4 = new Personnage(0);
	public static Personnage joueur5 = new Personnage(0);
	public static Personnage j = null;
	static int nombreJoueur = 1;
	int perso = 1;
	public static int alt = 1;

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
		System.out.println("2 - Nouveau compte");
		System.out.println("3 - Quitter");
		System.out.println("Choisir un menu");

		int choix= saisieInt("");
		switch(choix) 
		{
//		case 1 : seConnecter();break;
//		case 2 : nouveauCompte();break;
		case 3 : Context.get_instance().getEmf().close();System.exit(0);break;
		default : menuPrincipal();break;
		}
	}



//	public static void seConnecter() {
	public static void seConnecter(String login, String password) {
//		String login = saisieString("Saisir votre nom d'utilisateur");
//		String password = saisieString("Saisir votre mot de passe");
		User user = Context.get_instance().getDaoUser().checkConnect(login, password);
		if(user instanceof User)
		{
			//			String msg=login+" s'est connecte le : "+LocalDateTime.now()+"\n";
			//			ecrireFichier("connect.txt",msg);
//			menuJeu();
			ChoixModes.ChoixModes().setVisible(true);
		}
		else 
		{
			//			String msg=login+" erreur de connexion le : "+LocalDateTime.now()+"\n";
			//			ecrireFichier("errorConnect.txt",msg);
			//			System.out.println("Identifiants invalides");
//			System.out.println("\nIdentifiants invalides.\n");
//			menuPrincipal();
			Accueil.Accueil().setVisible(true);
		}
	}

	public static void nouveauCompte(String login, String password) {
//		String login = saisieString("Choisissez un nom d'utilisateur");
//		String password = saisieString("Choisissez un mot de passe");

		User newUser = new User(login,password);
		Context.get_instance().getDaoUser().save(newUser);
//		menuPrincipal();
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
		case 1 : retrouverPartie();jeuSolo();menuJeu();break;
		case 2 : jeuSolo();menuJeu();break;
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
		case 1 : nombreJoueur = 2;choixPerso(1);choixPerso(2);Carte carte= new Carte("foret",10,10,10,10);jeuMulti(carte);menuJeu();break; //Ajouter choix de carte ici
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
        System.out.println("2 - Magicien");
        System.out.println("3 - Assassin");
        int choix =saisieInt("Choix:");
        Personnage tampon=null;
        if (choix==1) {
            tampon = new Guerrier(0,0);
        }
        else if (choix==2) {
            tampon = new Magicien(0,0);
        }
        else if (choix==3) {
        	tampon = new Assassin(0,0);
        }
        else {
            choixPerso(perso);
        }

        if (perso==1) {joueur1=tampon;} 
        else if (perso==2) {joueur2=tampon;}



    }

	public static void retrouverPartie() {

		jeuSolo();
	}

	public static void jeuSolo() {
		choixPerso(1);
		int niveau=1;
		for (niveau=1;niveau <= cartes.size() ;niveau++) {
			System.out.println("Niveau "+niveau);
			combatSolo(niveau);
		}
		System.out.println("Vous avez termine le mode solo apres "+niveau+" niveaux!");
	}

	private static void combatSolo(int niveau) {
		System.out.println("Combat Solo");
		Carte carte = cartes.get(niveau-1);
		int obstacles[][]=creerObstacle(carte);
		placer(joueur1, obstacles, carte);
		joueur1.setpA(joueur1.getMaxPA());
		int ennemis = 0;
		switch (niveau) {
		case 1 :
			ennemis = 1;
			joueur2=new Gobelin();
			placerIa(joueur2,obstacles,carte,2);break;
		case 2 :
			ennemis = 2;
			joueur2=new Gobelin();
			joueur3=new Bandit();
			placerIa(joueur2,obstacles,carte,1);
			placerIa(joueur3,obstacles,carte,3);break;
		}
		while (joueur1.gethP()>0 && (joueur2.gethP()+joueur3.gethP()+joueur4.gethP()+joueur5.gethP())>0) {
			for (alt=1;alt<=ennemis+1;alt++) {
				switch (alt) {
				case 1 : j=joueur1;break;
				case 2 : j=joueur2;break;
				case 3 : j=joueur3;break;
				case 4 : j=joueur4;break;
				case 5 : j=joueur5;break;
				}
				
				if (j.gethP()>0 && joueur1.gethP()>0){
					afficherCarte(carte,obstacles);	
					if (alt==1) {
						System.out.println("Joueur  :");
						joueur1.setpM(joueur1.getMaxPM());
						joueur1.setpA(joueur1.getpA()+joueur1.getRegenPA());
						if (joueur1.getpA()>joueur1.getMaxPA()) {joueur1.setpA(joueur1.getMaxPA());}
						tour(joueur1,obstacles,carte);
					}
					else  {
						System.out.println("Tour de "+j);
						j.setpM(j.getMaxPM());
						j.setpA(j.getpA()+j.getRegenPA());
						if (j.getpA()>j.getMaxPA()) {j.setpA(j.getMaxPA());}
						if (j.getId()==10) {Gobelin.tourGobelin(j,joueur1, obstacles,carte);}
						if (j.getId()==20) {Bandit.tourBandit(j,joueur1, obstacles,carte);}
					}
				}
			}
		}
		if(joueur1.gethP()>0) {System.out.println("Vous avez termine le niveau "+niveau+"!");}
		else {System.out.println("Vous avez perdu!");menuJeu();}
	}

	public static void jeuOnline() {
		System.out.println("On a pas de online tu t'es cru sur Fortnite?");
		menuJeu();
	}

	public static void jeuMulti(Carte carte) {
		int obstacles[][]=creerObstacle(carte);
		String nom1=saisieString("Nom du joueur 1:");
		placer(joueur1,obstacles,carte);
		String nom2=saisieString("Nom du joueur 2:");
		placer(joueur2,obstacles,carte);
		if (nom1=="Frederic" || nom1=="Frederic") {joueur1.setAttaque(1);joueur1.setIntelligence(1);}
		else if (nom2=="Frederic" || nom2=="Frederic") {joueur2.setAttaque(1);joueur2.setIntelligence(1);}
		//		MapGenerator.GeneratorMap(carte,obstacles);
		int alt=1;
		while (joueur1.gethP()>0&&joueur2.gethP()>0) {
			if (alt==1) {
				alt=2;
				System.out.println("Joueur 1 :");
				joueur1.setpM(joueur1.getMaxPM());
				joueur1.setpA(joueur1.getpA()+joueur1.getRegenPA());
				if (joueur1.getpA()>joueur1.getMaxPA()) {joueur1.setpA(joueur1.getMaxPA());}
				tour(joueur1,obstacles,carte);
			}
			else {
				alt=1;
				System.out.println("Joueur 2 :");
				joueur2.setpM(joueur2.getMaxPM());
				joueur2.setpA(joueur2.getpA()+joueur2.getRegenPA());
				if (joueur2.getpA()>joueur2.getMaxPA()) {joueur2.setpA(joueur2.getMaxPA());}
				tour(joueur2,obstacles,carte);
			}
		}
		int vainqueur=0;
		if (joueur1.gethP()<=0&&joueur2.gethP()<=0) {
			System.out.println("Egalite");
		}
		else {
			if(joueur1.gethP()<=0&&joueur2.gethP()>0) {
				vainqueur=2;
			}
			else if(joueur2.gethP()<=0&&joueur1.gethP()>0) {
				vainqueur=1;
			}
			System.out.println("Joueur "+vainqueur+" a gagne!");
		}
	}


	private static void tour(Personnage j,int obstacles[][],Carte c) {
//		System.out.println("tour");
		if(j.getpA()!=0 && j.getpM()!=0) {
			System.out.println("1-Attaquer (PA = "+j.getpA()+") | 2-Se deplacer (PM = "+j.getpM()+") | 3-Fin du tour");}
		else if(j.getpA()==0 && j.getpM()!=0) {
			System.out.println("2-Se deplacer (PM = "+j.getpM()+") | 3-Fin du tour");}
		else if(j.getpA()!=0 && j.getpM()==0) {
			System.out.println("1-Attaquer (PA = "+j.getpA()+") | 3-Fin du tour");}
		else {return;}
		int choix = saisieInt("");
		switch(choix) {
		case 1 : 
			if(j.getpA()>0) {attaquer(j);}
			tour(j,obstacles,c);break;
		case 2 : 
			if(j.getpM()>0) {deplacer(j,obstacles,c);}
			else {tour(j,obstacles,c);}
			break;	
		case 3 : break;
		default : tour(j,obstacles,c);break;
		}
	}
		

	private static void deplacer(Personnage j,int obstacles[][],Carte c) {
//		System.out.println("d�placement");
		if (j.getpM()<=0) {System.out.println("Pas assez de PM");}
		while(j.getpM()>0) {
			System.out.println("PM : "+j.getpM());
			int map[][] = new int[c.getX()][c.getY()];
			map[joueur1.getX()][joueur1.getY()]=1;
			if(joueur2.gethP()>0) {map[joueur2.getX()][joueur2.getY()]=2;}
			if(joueur3.gethP()>0) {map[joueur3.getX()][joueur3.getY()]=3;}
			if(joueur4.gethP()>0) {map[joueur4.getX()][joueur4.getY()]=4;}
			if(joueur5.gethP()>0) {map[joueur5.getX()][joueur5.getY()]=5;}
			map[0][0]=0;
			for ( int ln = 0; ln < c.getX(); ln++)
			{
				for ( int col = 0; col < c.getY(); col++) 
				{
					if (obstacles[ln][col]==1) {map[ln][col]=9;} //Obstacle haut
					else if (obstacles[ln][col]==2) {map[ln][col]=8;}}} //Obstacle bas
			String direction = saisieString("Droite D | Gauche Q | Haut Z | Bas S | Retour R");
			direction.equalsIgnoreCase(direction); //ne fonctionne pas
			switch(direction) {
			case "S": if(map[j.getX()+1][j.getY()]==0) {
				map[j.getX()][j.getY()]=0;j.setX(j.getX()+1);j.setpM(j.getpM()-1);};break;
			case "Z": if(map[j.getX()-1][j.getY()]==0) {
				map[j.getX()][j.getY()]=0;j.setX(j.getX()-1);j.setpM(j.getpM()-1);};break;
			case "Q": if(map[j.getX()][j.getY()-1]==0) {
				map[j.getX()][j.getY()]=0;j.setY(j.getY()-1);j.setpM(j.getpM()-1);};break;
			case "D": if(map[j.getX()][j.getY()+1]==0) {
				map[j.getX()][j.getY()]=0;j.setY(j.getY()+1);j.setpM(j.getpM()-1);};break;
//			case "R":tour(j,obstacles,c);break;
			case "R":tour(j,obstacles,c);return;
//			default : deplacer(j,obstacles,c);break;
			default : deplacer(j,obstacles,c);return;}
			map[joueur1.getX()][joueur1.getY()]=1;
			map[joueur2.getX()][joueur2.getY()]=2;
			for (int[] ligne : map) {
				System.out.println(Arrays.toString(ligne));
			}
		}
		tour(j,obstacles,c);
	}

	private static void attaquer(Personnage j) {
		List<Attaque> attaques = new ArrayList<Attaque>();	
		Personnage cible = null;
		if (j==joueur1) {attaques=attaque1;}
		else if  (j==joueur2) {attaques=attaque2;}
		afficherAttaques(j);
		int ciblenum=0;
		int choix=saisieInt("")-1;
		if (choix>attaques.size()) {attaquer(j);}
		if(j==joueur1) {
			if (joueur3.gethP()==0) {cible=joueur2;}
			else {  if(joueur4.gethP()==0) {System.out.println(joueur2);System.out.println(joueur3);ciblenum=saisieInt("Cible? (2/3)");}
					else if (joueur5.gethP()==0) {System.out.println(joueur2);System.out.println(joueur3);System.out.println(joueur4);ciblenum=saisieInt("Cible? (2/3/4)");}
					else {System.out.println(joueur2);System.out.println(joueur3);System.out.println(joueur4);System.out.println(joueur5);ciblenum=saisieInt("Cible? (2/3/4/5)");}
				switch (ciblenum) {
					case 2: cible= joueur2;break;
					case 3: cible= joueur3;break;
					case 4: cible= joueur4;break;
					default: attaquer(j);break;
				}
			}
		}
		else if(j==joueur2) {cible=joueur1;}
		Attaque.calculDegat(j,cible, attaques.get(choix));
//		j.setpA(j.getpA()-attaques.get(choix).getpA()); //nouveaux PA deja calcules dans calculDegats()
		if (nombreJoueur == 2) {
		System.out.println("HP Joueur 1 : "+joueur1.gethP()+" | HP Joueur 2 : "+joueur2.gethP());}
		else if (nombreJoueur == 1) {
		System.out.println("HP Joueur 1 : "+joueur1.gethP()+" | HP Ennemi : "+joueur2.gethP());}
		}

		private static void afficherAttaques(Personnage j) {
			List<Attaque> attaques = new ArrayList<Attaque>();
			if (j==joueur1) {attaques=attaque1;}
			else if  (j==joueur2) {attaques=attaque2;}
			for (int i= 0; i<attaques.size();i++) {	
				System.out.println((i+1)+" "+attaques.get(i).getNomAttaque()+" |type: "+attaques.get(i).getType()+" |degats: "+attaques.get(i).getDegats()+" |PA: "+attaques.get(i).getpA()+" |portee: "+attaques.get(i).getRange());
			} //rajouter stat attaque ou intelligence suivant le type d'attaque (physique ou magique) ? Ou git gud?
		}


		public static void afficherCarte(Carte c,int [][] obstacles) {
			int map[][] = new int[c.getX()][c.getY()];
			for ( int ln = 0; ln < c.getX(); ln++)
			{
				for ( int col = 0; col < c.getY(); col++) 
				{
					if (obstacles[ln][col]==1) {map[ln][col]=9;} //Obstacle haut
					else if (obstacles[ln][col]==2) {map[ln][col]=8;} //Obstacle bas
				}	
			}
			map[joueur1.getX()][joueur1.getY()]=1;
			if(joueur2.gethP()>0) {map[joueur2.getX()][joueur2.getY()]=2;}
			if(joueur3.gethP()>0) {map[joueur3.getX()][joueur3.getY()]=3;}
			if(joueur4.gethP()>0) {map[joueur4.getX()][joueur4.getY()]=4;}
			if(joueur5.gethP()>0) {map[joueur5.getX()][joueur5.getY()]=5;}
			for (int[] ligne : map) {
				System.out.println(Arrays.toString(ligne));
			}
			if (joueur3.gethP()==0) {System.out.println(joueur2);}
			else {  if(joueur4.gethP()==0) {System.out.println(joueur2);System.out.println(joueur3);}
				else if (joueur5.gethP()==0) {System.out.println(joueur2);System.out.println(joueur3);System.out.println(joueur4);}
				else {System.out.println(joueur2);System.out.println(joueur3);System.out.println(joueur4);System.out.println(joueur5);}
			}
		}

		public static void afficherCartePlacement(Personnage j,Carte c,int [][] obstacles) {
			int map[][] = new int[c.getX()][c.getY()];
			for ( int ln = 0; ln < c.getX(); ln++)
			{
				for ( int col = 0; col < c.getY(); col++) 
				{
					if (obstacles[ln][col]==1) {map[ln][col]=9;} //Obstacle haut
					else if (obstacles[ln][col]==2) {map[ln][col]=8;} //Obstacle bas
				}	
			}
			if (j==joueur1) {
				map[Math.round((c.getX()/2))-2][3]=1;
				map[Math.round((c.getX()/2))-1][2]=2;
				map[Math.round(c.getX()/2)][2]=3;
				map[Math.round((c.getX()/2))+1][3]=4;
			}
			else if (j==joueur2) {
				map[Math.round((c.getX()/2))-2][c.getY()-3]=1;
				map[Math.round((c.getX()/2))-1][c.getY()-2]=2;
				map[Math.round((c.getX()/2))][c.getY()-2]=3;
				map[Math.round((c.getX()/2))+1][c.getY()-3]=4;
			}
//			for ( int ln = 0; ln < c.getX(); ln++)
//			{
//				for ( int col = 0; col < c.getY(); col++) 
//				{
//					if (obstacles[ln][col]==1) {map[ln][col]=3;} //Obstacle haut
//					else if (obstacles[ln][col]==2) {map[ln][col]=4;} //Obstacle bas
//				}	
//			}
			for (int[] ligne : map) {
				System.out.println(Arrays.toString(ligne));
			}
		}

		private static int[][] creerObstacle(Carte c) {
			int haut = c.getHaut();
			int bas = c.getBas();
			int obstacles[][]=new int[c.getX()][c.getY()];
			Random rand = new Random();
			for ( int h = 1; h <= haut; h++) {
				int x = rand.nextInt(c.getX());
				int y = rand.nextInt(c.getY());
				obstacles[x][y]=1;
			}
			for ( int b = 1; b <= bas; b++) {
				int x = rand.nextInt(c.getX());
				int y = rand.nextInt(c.getY());
				obstacles[x][y]=2;
			}
			obstacles[Math.round((c.getX()/2))-2][3]=0;
			obstacles[Math.round((c.getX()/2))-1][2]=0;
			obstacles[Math.round(c.getX()/2)][2]=0;
			obstacles[Math.round((c.getX()/2))+1][3]=0;
			obstacles[Math.round((c.getX()/2))-2][c.getY()-3]=0;
			obstacles[Math.round((c.getX()/2))-1][c.getY()-2]=0;
			obstacles[Math.round(c.getX()/2)][c.getY()-2]=0;
			obstacles[Math.round((c.getX()/2))+1][c.getY()-3]=0;
			
			return obstacles;
		}

		public static void placer(Personnage j,int[][] obstacles,Carte c) {
			//		MapGenerator.GeneratorMapPlacement(c,obstacles);
			afficherCartePlacement(j,c,obstacles);
			if (j==joueur1) {
				System.out.println("Joueur 1 :");}
			else if (j==joueur2) {
				System.out.println("Joueur 2 :");}
			int choix =saisieInt("Position de depart?(1/2/3/4)");
			int x=0;
			int y=0;
			if (j==joueur1) {
				switch(choix) 
				{
				case 1 :x=Math.round((c.getX()/2)-2);y=3;break; 
				case 2 :x=Math.round((c.getX()/2)-1);y=2 ;break;
				case 3 :x=Math.round(c.getX()/2);y=2 ;break;
				case 4 :x=Math.round((c.getX()/2)+1);y=3 ;break;
				default :placer(j,obstacles,c);break;
				}
				joueur1.setPosition(x, y);
			}
			if (j==joueur2) {
				switch(choix) 
				{
				case 1 :x=Math.round((c.getX()/2)-2);y=c.getY()-3;break;
				case 2 :x=Math.round((c.getX()/2)-1);y=c.getY()-2 ;break;
				case 3 :x=Math.round(c.getX()/2);y=c.getY()-2 ;break;
				case 4 :x=Math.round((c.getX()/2)+1);y=c.getY()-3 ;break;
				default :placer(j,obstacles,c);break;
				}
				joueur2.setPosition(x, y);
			}
		}
		
		public static void placerIa(Personnage j,int[][] obstacles,Carte c,int position) {
			//		MapGenerator.GeneratorMapPlacement(c,obstacles);
			int x=0;
			int y=0;
//			Random rand=new Random();
//			int position=rand.nextInt(3)+1;
			switch(position) 
				{
				case 1 :x=Math.round((c.getX()/2)-2);y=c.getY()-3;break;
				case 2 :x=Math.round((c.getX()/2)-1);y=c.getY()-2 ;break;
				case 3 :x=Math.round(c.getX()/2);y=c.getY()-2 ;break;
				case 4 :x=Math.round((c.getX()/2)+1);y=c.getY()-3 ;break;
				default :placer(j,obstacles,c);break;
				}
			j.setPosition(x, y);
		}

		public static void main(String[] args) {
//			Creation base de donn�es :
			
//			User Martin= new User("martin","martin");
//			User Kyllian= new User("kyllian","kyllian");
//			User Louis= new User("louis","louis");
//			User Admin= new User("admin","admin");
//			Context.get_instance().getDaoUser().save(Martin);
//			Context.get_instance().getDaoUser().save(Kyllian);
//			Context.get_instance().getDaoUser().save(Louis);
//			
//			Context.get_instance().getDaoPerso().save(new Guerrier(0,0));
//			Context.get_instance().getDaoPerso().save(new Magicien(0,0));
//			
//			Context.get_instance().getDaoAttaque().save(cDP);
//			Context.get_instance().getDaoAttaque().save(cDB);
//			Context.get_instance().getDaoAttaque().save(bM);
//			Context.get_instance().getDaoAttaque().save(bDF);
//			
//			Context.get_instance().getDaoObjet().save(baton);
//			Context.get_instance().getDaoObjet().save(baguetteMagique);	
//			
//			Exemple de sauvegarde :
//			attaque1.add(Context.get_instance().getDaoAttaque().findById(2));
//			attaque1.add(Context.get_instance().getDaoAttaque().findById(3));
//			inventaire1.add(Context.get_instance().getDaoObjet().findById(1));
//			User u= Context.get_instance().getDaoUser().findById(6);
//			Personnage p = Context.get_instance().getDaoPerso().findById(2);
//			Sauvegarde s = new Sauvegarde(u,p,attaque1,inventaire1);
//			Context.get_instance().getDaoSauvegarde().save(s);
			
			 
			
			
//			attaque1.add(cDP);
//			attaque2.add(cDP);
//			attaque1.add(cDB);
//			attaque2.add(cDB);
//			attaque1.add(bM);
//			attaque2.add(bM);
//			attaque1.add(bDF);
//			attaque2.add(bDF);
			cartes.add(foret);
			cartes.add(grotte);
			attaque1 = Context.get_instance().getDaoAttaque().findAll();
			attaque2 = Context.get_instance().getDaoAttaque().findAll();
//			jeuSolo();
			menuJeu();
//			Accueil ac = new Accueil();
////			ac.setVisible(true);


//			cartes.add(foret);
			//Accueil ac = new Accueil();
//			Accueil.Accueil().setVisible(true);
			
//			Context.get_instance().getEmf().close();
		} 
	}