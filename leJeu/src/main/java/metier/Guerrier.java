package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("guerrier")
public class Guerrier extends Personnage
{

	public Guerrier() {}
	
	
    public Guerrier(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA) {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA);
    }



    public Guerrier(int x, int y){
        super(x, y);
        this.hP = 100;
        this.attaque = 20;
        this.intelligence = 5;
        this.pA = 8;
        this.pM = 4;
        this.regenPA = 1 ;
        this.maxPA = 10 ;
        this.maxPM=4;
    }



    @Override
	public String toString() {
		return "Guerrier [id=" + id + ", x=" + x + ", y=" + y + ", hP=" + hP + ", attaque=" + attaque
				+ ", intelligence=" + intelligence + ", pA=" + pA + ", pM=" + pM + ", regenPA=" + regenPA + ", maxPA="
				+ maxPA + "]";
	}


}