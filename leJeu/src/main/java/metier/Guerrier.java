package metier;

public class Guerrier extends Personnage
{

	
	
    public Guerrier(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM) {
        super(id,x, y, hP, attaque, intelligence, pA, pM);
    }


    
    public Guerrier(int x, int y){
        super(x, y);
        this.hP = 100;
        this.attaque = 20;
        this.intelligence = 5;
        this.pA = 8;
        this.pM = 3;
    }



	@Override
	public String toString() {
		return "Guerrier [id=" + id + ", x=" + x + ", y=" + y + ", hP=" + hP + ", attaque=" + attaque
				+ ", intelligence=" + intelligence + ", pA=" + pA + ", pM=" + pM + "]";
	}
    
    
}