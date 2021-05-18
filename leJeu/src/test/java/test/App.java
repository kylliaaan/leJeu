package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import menuPrincipal.Accueil;
import metier.Attaque;
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
	static List<Attaque> attaque1 = new ArrayList();
	static List<Attaque> attaque2 = new ArrayList();
	static List<Objet> inventaire1 = new ArrayList();
	static List<Objet> inventaire2 = new ArrayList();
	static List<Carte> cartes = new ArrayList();
	static Carte foret= new Carte("foret",10,10,10,10);
	static Attaque cDP = new Attaque(1, "coup de poing", "physique", 1, 5);
	static Attaque cDB = new Attaque(1, "coup de baton", "physique", 2, 10);
	static Attaque bM = new Attaque(5, "baguette magique", "magique",1, 5);
	static Attaque bDF = new Attaque(8, "boule de feu", "magique", 4, 25);
	static Objet baton = new Objet("baton",0,10,0,1,0);
	static Objet baguetteMagique = new Objet("baguette magique",0,0,10,2,0);
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
		System.out.println("2 - Nouveau compte");
		System.out.println("3 - Quitter");
		System.out.println("Choisir un menu");

		int choix= saisieInt("");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : nouveauCompte();break;
		case 3 : Context.get_instance().getEmf().close();System.exit(0);break;
		default : menuPrincipal();break;
		}
	}



	public static void seConnecter() {
		String login = saisieString("Saisir votre nom d'utilisateur");
		String password = saisieString("Saisir votre mot de passe");
		User user = Context.get_instance().getDaoUser().checkConnect(login, password);
		if(user instanceof User)
		{
			//			String msg=login+" s'est connecte le : "+LocalDateTime.now()+"\n";
			//			ecrireFichier("connect.txt",msg);
			menuJeu();
		}
		else 
		{
			//			String msg=login+" erreur de connexion le : "+LocalDateTime.now()+"\n";
			//			ecrireFichier("errorConnect.txt",msg);
			//			System.out.println("Identifiants invalides");
			System.out.println("\nIdentifiants invalides.\n");
			menuPrincipal();
		}
	}

	private static void nouveauCompte() {
		String login = saisieString("Choisissez un nom d'utilisateur");
		String password = saisieString("Choisissez un mot de passe");

		User newUser = new User(login,password);
		Context.get_instance().getDaoUser().save(newUser);
		menuPrincipal();
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
		System.out.println("2 - Mage");
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
			System.out.println("Non");
			choixPerso(perso);
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
		for (int niveau=1;niveau <= cartes.size() ;niveau++) {
			System.out.println("Niveau "+niveau);
			combatSolo(niveau);
		}


	}

	private static void combatSolo(int niveau) {
		Carte carte = cartes.get(niveau-1);
		int obstacles[][]=creerObstacle(carte);
		placer(joueur1, obstacles, carte);
		joueur2=new Gobelin();
		placerIa(joueur2,obstacles,carte);
		int alt=1;
		//		MapGenerator.GeneratorMap(carte,obstacles);
		while (joueur1.gethP()>0&&joueur2.gethP()>0) {
			afficherCarte(carte,obstacles);
			System.out.println("HP joueur:"+joueur1.gethP()+"|HP ennemi:"+joueur2.gethP());
			if (alt==1) {
				System.out.println("Joueur 1 :");
				joueur1.setpM(joueur1.getMaxPM());
				joueur1.setpA(joueur1.getpA()+joueur1.getRegenPA());
				if (joueur1.getpA()>joueur1.getMaxPA()) {joueur1.setpA(joueur1.getMaxPA());}
				tour(joueur1,obstacles,carte);
				alt=2;
			}
			else {
				System.out.println("Tour de l'enemi");
				joueur2.setpM(joueur2.getMaxPM());
				joueur2.setpA(joueur2.getpA()+joueur2.getRegenPA());
				if (joueur2.getpA()>joueur2.getMaxPA()) {joueur2.setpA(joueur2.getMaxPA());}
				Gobelin.tourGobelin(joueur2,joueur1, obstacles,carte);
				alt=1;
			}
		}
		if(joueur1.gethP()>0) {System.out.println("Vous avez terminine le niveau "+niveau+"!");}
		else {System.out.println("Vous avez perdu!");menuJeu();}
	}

	public static void jeuOnline() {
		System.out.println("On a pas de online tu t'es cru sur Fortnite?");
		menuJeu();
	}

	public static void jeuMulti(Carte carte) {
		int obstacles[][]=creerObstacle(carte);
		placer(joueur1,obstacles,carte);
		placer(joueur2,obstacles,carte);
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
				vainqueur=1;
			}
			else if(joueur2.gethP()<=0&&joueur1.gethP()>0) {
				vainqueur=2;
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
			map[joueur2.getX()][joueur2.getY()]=2;
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
		int choix=saisieInt("")-1;
		if(j==joueur1) {cible=joueur2;}
		else if(j==joueur2) {cible=joueur1;}
		Attaque.calculDegat(j,cible, attaques.get(choix));
//		j.setpA(j.getpA()-attaques.get(choix).getpA()); //nouveaux PA d�j� calcul�s dans calculDegats()
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
			map[joueur2.getX()][joueur2.getY()]=2;
			for (int[] ligne : map) {
				System.out.println(Arrays.toString(ligne));
			}
		}

		public static void afficherCartePlacement(Personnage j,Carte c,int [][] obstacles) {
			int map[][] = new int[c.getX()][c.getY()];
			for ( int ln = 0; ln < c.getX(); ln++) //pas d'obstacle sur les 4 positions de d�part
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
			}
			j.setPosition(x, y);
		}
		
		public static void placerIa(Personnage j,int[][] obstacles,Carte c) {
			//		MapGenerator.GeneratorMapPlacement(c,obstacles);
			int x=0;
			int y=0;
			Random rand=new Random();
			int choix=rand.nextInt(3)+1;
			switch(choix) 
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
			/* Creation base de donn�es :
			
			User Martin= new User("martin","martin");
			User Kyllian= new User("kyllian","kyllian");
			User Louis= new User("louis","louis");
			Context.get_instance().getDaoUser().save(Martin);
			Context.get_instance().getDaoUser().save(Kyllian);
			Context.get_instance().getDaoUser().save(Louis);
			
			Context.get_instance().getDaoPerso().save(new Guerrier(0,0));
			Context.get_instance().getDaoPerso().save(new Magicien(0,0));
			
			Context.get_instance().getDaoAttaque().save(cDP);
			Context.get_instance().getDaoAttaque().save(cDB);
			Context.get_instance().getDaoAttaque().save(bM);
			Context.get_instance().getDaoAttaque().save(bDF);
			
			Context.get_instance().getDaoObjet().save(baton);
			Context.get_instance().getDaoObjet().save(baguetteMagique);	
			
//			Exemple de sauvegarde :
//			attaque1.add(Context.get_instance().getDaoAttaque().findById(2));
//			attaque1.add(Context.get_instance().getDaoAttaque().findById(3));
//			inventaire1.add(Context.get_instance().getDaoObjet().findById(1));
//			User u= Context.get_instance().getDaoUser().findById(6);
//			Personnage p = Context.get_instance().getDaoPerso().findById(2);
//			Sauvegarde s = new Sauvegarde(u,p,attaque1,inventaire1);
//			Context.get_instance().getDaoSauvegarde().save(s);
			
			 */
			
			
			attaque1.add(cDP);
			attaque2.add(cDP);
			attaque1.add(cDB);
			attaque2.add(cDB);
			attaque1.add(bM);
			attaque2.add(bM);
			attaque1.add(bDF);
			attaque2.add(bDF);
			cartes.add(foret);
//			attaque1 = Context.get_instance().getDaoAttaque().findAll();
//			attaque2 = Context.get_instance().getDaoAttaque().findAll();
//			jeuSolo();
			menuPrincipal();
//			Accueil ac = new Accueil();
//			ac.setVisible(true);


//			cartes.add(foret);
			Accueil ac = new Accueil();
			Accueil.Accueil().setVisible(true);

//			Context.get_instance().getEmf().close();
		} 
	}