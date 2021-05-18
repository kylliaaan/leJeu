package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("magicien")
public class Magicien extends Personnage 
{

	public Magicien() {}
	
    public Magicien(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) 
    {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA ,maxPM);
    }
    


    public Magicien(int x, int y) 
    {
    	this.id =2;
        this.hP = 80;
        this.attaque = 12;
        this.intelligence = 15;
        this.pA = 9;
        this.pM = 3;
        this.regenPA = 4 ;
        this.maxPA = 9 ;
        this.maxPM=3;
    }


    @Override
	public String toString() {
		return "Magicien [HP=" + hP + ", attaque=" + attaque + ", intelligence=" + intelligence + ", PA=" + pA + ", PM=" + pM + ", regeneration PA=" + regenPA + "]";
	}


}