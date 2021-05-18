package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Assassin")
public class Assassin extends Personnage
{

	public Assassin() {}
	
	
    public Assassin(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA, maxPM);
    }



    public Assassin(int x, int y){
        super(x, y);
        this.hP = 85;
        this.attaque = 30;
        this.intelligence = 5;
        this.pA = 6;
        this.pM = 5;
        this.regenPA = 1 ;
        this.maxPA = 10 ;
        this.maxPM=7;
    }



    @Override
	public String toString() {
		return "Guerrier [id=" + id + ", x=" + x + ", y=" + y + ", hP=" + hP + ", attaque=" + attaque
				+ ", intelligence=" + intelligence + ", pA=" + pA + ", pM=" + pM + ", regenPA=" + regenPA + ", maxPA="
				+ maxPA + "]";
	}


}