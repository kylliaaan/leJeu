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
        this.id = 3;
        this.hP = 80;
        this.attaque = 30;
        this.intelligence = 5;
        this.pA = 7;
        this.pM = 5;
        this.regenPA = 3 ;
        this.maxPA = 7 ;
        this.maxPM=5;
    }



    @Override
	public String toString() {
		return "Assassin [HP=" + hP + ", attaque=" + attaque + ", intelligence=" + intelligence + ", PA=" + pA + ", PM=" + pM + ", regeneration PA=" + regenPA + "]";
	}


}