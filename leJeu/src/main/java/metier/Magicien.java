
package metier;

public class Magicien extends Personnage 
{

    public Magicien(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM) 
    {
    	super(id,x, y, hP, attaque, intelligence, pA, pM);
    }
    

    public Magicien(int x, int y) 
    {
        this.hP = 70;
        this.attaque = 12;
        this.intelligence = 15;
        this.pA = 10;
        this.pM = 4;
    }


	@Override
	public String toString() {
		return "Magicien [id=" + id + ", x=" + x + ", y=" + y + ", hP=" + hP + ", attaque=" + attaque
				+ ", intelligence=" + intelligence + ", pA=" + pA + ", pM=" + pM + "]";
	}

    
}