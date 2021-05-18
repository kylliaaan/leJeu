package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("guerrier")
public class Guerrier extends Personnage
{

	public Guerrier() {}
	
	
    public Guerrier(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA, maxPM);
    }



    public Guerrier(int x, int y){
        super(x, y);
        this.id =1;
        this.hP = 120;
        this.attaque = 20;
        this.intelligence = 5;
        this.pA = 8;
        this.pM = 3;
        this.regenPA = 3 ;
        this.maxPA = 8 ;
        this.maxPM=3;
    }



    @Override
	public String toString() {
		return "Guerrier [HP=" + hP + ", attaque=" + attaque + ", intelligence=" + intelligence + ", PA=" + pA + ", PM=" + pM + ", regeneration PA=" + regenPA + "]";
	}


}