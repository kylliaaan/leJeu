package metier;

import java.util.Random;

public class Fantome extends Personnage
{



    public Fantome(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA, maxPM);
    }

    public Fantome(){}

    public Fantome(int x, int y){
        super(x, y);
        this.hP = 30;
        this.attaque = 5;
        this.intelligence = 5;
        this.pA = 1;
        this.pM = 3;
        this.regenPA = 1 ;
        this.maxPA = 1 ;
        this.maxPM=3;
    }



    @Override
    public String toString() {
        return "Fantome [hP=" + hP + ", attaque=" + attaque + ", intelligence=" + intelligence + ", pA=" + pA + ", pM="
                + pM + ", regenPA=" + regenPA + "]";
    }
    
    public static void tourFantome(Personnage j, Personnage cible, int[][] obstacles, Carte carte) {
		int distanceX = Math.abs(j.getX()-cible.getX());
		int distanceX2 = Math.abs((j.getX()+1)-cible.getX());
		int distanceY = Math.abs(j.getY()-cible.getY());
		int distanceY2 = Math.abs((j.getY()+1)-cible.getY());
		int distance = distanceX+distanceY;
		while (distance > 1 && j.getpM()>0) {
			distanceX = Math.abs(j.getX()-cible.getX());
			distanceX2 = Math.abs((j.getX()+1)-cible.getX());
			distanceY = Math.abs(j.getY()-cible.getY());
			distanceY2 = Math.abs((j.getY()+1)-cible.getY());
			distance = distanceX+distanceY;
			if (distanceX>=distanceY) {
				if (distanceX>distanceX2) {
					j.setX(j.getX()+1);
					j.setpM(j.getpM()-1);
				}
				else {
					j.setX(j.getX()-1);
					j.setpM(j.getpM()-1);
				}
			}
			else {
				if (distanceY>distanceY2) {
					j.setY(j.getY()+1);
					j.setpM(j.getpM()-1);
				}
				else {
					j.setY(j.getY()-1);
					j.setpM(j.getpM()-1);
				}
			}
		}
		if (distance==1 && j.getpA()>0) {
			System.out.println("Coup de poing");
			j.setpA(j.getpA()-1);
			Random rand = new Random();
			int proba = rand.nextInt(10);
			if (proba>=2) {
				System.out.println("-5hp");
				cible.sethP(cible.gethP()-j.getAttaque());
			}
			else {
				System.out.println("Vous esquivez");
			}	
		}
	}


}