package metier;

public class Personnage 
{
	protected int id;
	protected int x;
	protected int y;
	protected int hP; 
	protected int attaque; 
	protected int intelligence; 
	protected int pA; 
	protected int pM;
	protected int regenPA;
	protected int maxPA;



	public Personnage(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	public Personnage(int id, int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA) 
	{
		this.x = x;
		this.y = y;
		this.hP = hP;
		this.attaque = attaque;
		this.intelligence = intelligence;
		this.pA = pA;
		this.pM = pM;
		this.regenPA = regenPA;
		this.maxPA = maxPA;
	}


	public Personnage() {
		// TODO Auto-generated constructor stub
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int gethP() {
		return hP;
	}



	public void sethP(int hP) {
		this.hP = hP;
	}



	public int getAttaque() {
		return attaque;
	}



	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}



	public int getIntelligence() {
		return intelligence;
	}



	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}



	public int getpA() {
		return pA;
	}



	public void setpA(int pA) {
		this.pA = pA;
	}



	public int getpM() {
		return pM;
	}



	public void setpM(int pM) {
		this.pM = pM;
	}
	
	

	public void setPosition(int x,int y) 
	{
		this.x=x;
		this.y=y;
	} 

	public static void seDeplacer()
	{
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegenPA() {
		return regenPA;
	}

	public void setRegenPA(int regenPA) {
		this.regenPA = regenPA;
	}

	public int getMaxPA() {
		return maxPA;
	}

	public void setMaxPA(int maxPA) {
		this.maxPA = maxPA;
	}
	
	
	
}