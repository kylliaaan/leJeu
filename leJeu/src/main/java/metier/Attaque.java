package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attaque 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	protected int range;
	protected String nomAttaque;
	protected String type;
	@Column(name="point_Attaque")
	protected int pA;
	protected int degats;

	static Attaque cDP = new Attaque(1, "coup_de_poing", "physique", 1, 5);
	static Attaque cDB = new Attaque(1, "coup_de_baton", "physique", 2, 10);
	static Attaque bM = new Attaque(5, "baguette_magique", "magique",1, 5);
	static Attaque bDF = new Attaque(8, "boule_de_feu", "magique", 4, 25);
		
	public Attaque() {}

	public Attaque(int range, String nomAttaque, String type, int pA , int degats)
	{
		this.range = range;
		this.nomAttaque = nomAttaque;
		this.type = type;
		this.pA = pA;
		this.degats = degats;
	}



	public int getDegats() {
		return degats;
	}



	public void setDegats(int degats) {
		this.degats = degats;
	}



	public int getRange() {
		return range;
	}



	public void setRange(int range) {
		this.range = range;
	}



	public String getNomAttaque() {
		return nomAttaque;
	}



	public void setNomAttaque(String nomAttaque) {
		this.nomAttaque = nomAttaque;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getpA() {
		return pA;
	}



	public void setpA(int pA) {
		this.pA = pA;
	}



	public static void calculDegat(Personnage p1, Personnage p2, String nomAttaque)
	{
		int x1 = p1.getX(); // position A => x et y 
		int y1 = p1.getY();

		int x2 = p2.getX(); // position B => x et y 
		int y2 = p2.getY();

		int dist = (int) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)); 

		if (nomAttaque.equals("coup de poing")) 			
		{ 
			if(p1.getpA()>=cDP.getpA())
			{
				p1.setpA(p1.getpA()-cDP.getpA()); //L'attaquant perd ses points d'attaque même si la cible est hors de portée

				if(dist<=cDP.getRange())
				{
					int degats = p1.getAttaque() + cDP.getDegats(); //degat = stat 'Attaque' du perso + les 'degats' de l'attaque
					p2.sethP(p2.gethP()-degats);
					System.out.println("La victime a reçu "+degats+" dégats. Il lui reste "+p2.gethP()+" HP.");
				}
				else{System.out.println("Vous êtes hors de portée ! Ce n'est pas très efficace...");}
			}
			else {System.out.println("Points d'attaque insuffisants");}
		}

		else if(nomAttaque.equals("coup de baton"))
		{
			if(p1.getpA()>= cDB.getpA())
			{
				p1.setpA(p1.getpA()-cDB.getpA());

				if(dist<=cDB.getRange())
				{
					int degats = p1.getAttaque() + cDB.getDegats();
					p2.sethP(p2.gethP()-degats);
					System.out.println("La victime a reçu "+degats+" dégats. Il lui reste "+p2.gethP()+" HP.");
				}
				else{System.out.println("Vous êtes hors de portée ! Ce n'est pas très efficace...");}
			}
			else {System.out.println("Points d'attaque insuffisants");}
		}

		else if(nomAttaque.equals("baguette magique"))
		{

			if(p1.getpA()>= bM.getpA())
			{
				p1.setpA(p1.getpA()-bM.getpA());

				if(dist<=bM.getRange())
				{
					int degats = p1.getAttaque() + bM.getDegats();
					p2.sethP(p2.gethP()-degats);
					System.out.println("La victime a reçu "+degats+" dégats. Il lui reste "+p2.gethP()+" HP.");
				}
				else{System.out.println("Vous êtes hors de portée ! Ce n'est pas très efficace...");}
			}
			else {System.out.println("Points d'attaque insuffisants");}
		}

		else if (nomAttaque.equals("boule de feu"))
		{
			if(p1.getpA()>= bDF.getpA())
			{
				p1.setpA(p1.getpA()-bDF.getpA());
			
				if(dist<=bDF.getRange())
				{
					int degats = p1.getAttaque() + bDF.getDegats();
					p2.sethP(p2.gethP()-degats);
					System.out.println("La victime a reçu "+degats+" dégats. Il lui reste "+p2.gethP()+" HP.");
				}
				else{System.out.println("Vous êtes hors de portée ! Ce n'est pas très efficace...");}
			}
			else {System.out.println("Points d'attaque insuffisants");}
		}
	}

	@Override
	public String toString() {
		return "Attaque [id=" + id + ", range=" + range + ", nomAttaque=" + nomAttaque + ", type=" + type + ", pA=" + pA
				+ ", degats=" + degats + "]";
	}

}