package metier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="classe_de_perso")
public class Personnage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name="Position_x",nullable=false)
	protected int x;
	@Column(name="Position_y",nullable=false)
	protected int y;
	@Column(nullable=false)
	protected int hP; 
	@Column(nullable=false)
	protected int attaque; 
	@Column(nullable=false)
	protected int intelligence;
	@Column(name="Points_action",nullable=false)
	protected int pA; 
	@Column(name="Points_mouvement",nullable=false)
	protected int pM;
	@Column(name="Régén_pt_action",nullable=false)
	protected int regenPA;
	@Column(name="Max_pt_action",nullable=false)
	protected int maxPA;
	protected int maxPM;



	public Personnage(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	public Personnage(int id, int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) 
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
		this.maxPM= maxPM;
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

	public int getMaxPM() {
		return maxPM;
	}

	public void setMaxPM(int maxPM) {
		this.maxPM = maxPM;
	}
	
	
	
}