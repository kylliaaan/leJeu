package metier;



public class Attaque 
{
	protected int range;
	protected String nomAttaque;
	protected String type;
	protected int pA;
	protected int degats;
	
	static Attaque cAC = new Attaque(1, "coup de poing", "physique", 1, 5);
	static Attaque bDF = new Attaque(2, "boule de feu", "physique", 2, 10);
	
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



	public static void calculDegat(Personnage joueur1, Personnage joueur2, String nomAttaque)
	{
		
		if (joueur1.getpA()>= cAC.getpA() && nomAttaque.equals("coup de poing"))
		
		{
		int degats = joueur1.getAttaque()+ cAC.getDegats() ; 
		int hPVictime = joueur2.gethP() ;
		hPVictime -= degats;
		System.out.println("Tu as reçus "+degats+" de dégats");
		joueur2.sethP(hPVictime);
		joueur1.setpA(joueur1.getpA()-cAC.getpA());
		}
		else {System.out.println("PA insuffisant");}
		
	}

	public static void calculDegat2(Personnage joueur1, Personnage joueur2, String nomAttaque)
	{

		int pXj1 = joueur1.getX(); // position A => x et y 
		int pYj1 = joueur1.getY();

		int pXj2 = joueur2.getX(); // position B => x et y 
		int pYj2 = joueur2.getY();

		int valX = pXj2-pXj1;
		int valY = pYj2-pYj1;

		int val = (int) (Math.pow(valX,2)) + (int) (Math.pow(valY,2));

		int dP12 = (int) Math.sqrt(val); 
	
		if ((joueur1.getpA()>= bDF.getpA()) && nomAttaque.equals("boule de feu"))

		{
			if (bDF.getRange() >= dP12)
			{
				int degats = joueur1.getAttaque() + bDF.getDegats(); 
				int hPVictime = joueur2.gethP() ;
				hPVictime -= degats;
				System.out.println("Tu as reçus "+degats+" de dégats");
				joueur2.sethP(hPVictime);
				joueur1.setpA(joueur1.getpA()-bDF.getpA());
			} else {System.out.println("Attaque invalide");}
		} else {System.out.println("PA insuffisant");}
		
	}

	

	
}