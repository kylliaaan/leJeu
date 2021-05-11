package metier;

public class Objet {
	protected String nomObjet;
	protected int hP;
	protected int attaque;
	protected int intelligence;
	protected int pA;
	protected int pM;
	
	static Objet baton = new Objet("baton",0,10,0,1,0);
	static Objet baguetteMagique = new Objet("baguette magique",0,0,10,2,0);
	
	public Objet() {
		super();
	}

	public Objet(String nomObjet, int hP, int attaque, int intelligence, int pA, int pM) {
		super();
		this.nomObjet = nomObjet;
		this.hP = hP;
		this.attaque = attaque;
		this.intelligence = intelligence;
		this.pA = pA;
		this.pM = pM;
	}

	public String getNomObjet() {
		return nomObjet;
	}

	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
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

	@Override
	public String toString() {
		return "Objet [nomObjet=" + nomObjet + ", HP=" + hP + ", attaque=" + attaque + ", intelligence=" + intelligence
				+ ", points d'attaque=" + pA + "]";
	}
}