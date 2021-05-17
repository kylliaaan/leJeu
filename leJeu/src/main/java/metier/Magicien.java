package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("magicien")
public class Magicien extends Personnage 
{

    public Magicien(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) 
    {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA ,maxPM);
    }
    


    public Magicien(int x, int y) 
    {
        this.hP = 70;
        this.attaque = 12;
        this.intelligence = 15;
        this.pA = 10;
        this.pM = 3;
        this.regenPA = 2 ;
        this.maxPA = 10 ;
        this.maxPM=3;
    }


    @Override
	public String toString() {
		return "Magicien [id=" + id + ", x=" + x + ", y=" + y + ", hP=" + hP + ", attaque=" + attaque
				+ ", intelligence=" + intelligence + ", pA=" + pA + ", pM=" + pM + ", regenPA=" + regenPA + ", maxPA="
				+ maxPA + "]";
	}


}