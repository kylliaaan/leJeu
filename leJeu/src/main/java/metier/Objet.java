package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Objet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	protected String nomObjet;
	@Column(nullable=false)
	protected int hP;
	@Column(nullable=false)
	protected int attaque;
	@Column(nullable=false)
	protected int intelligence;
	@Column(name="point_action",nullable=false)
	protected int pA;
	@Column(name="point_mouvement",nullable=false)
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