package metier;

import java.util.Random;

public class Bandit extends Personnage
{



    public Bandit(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA, maxPM);
}

    public Bandit(){
    	this.id = 20;
	    this.hP = 50;
	    this.attaque = 10;
	    this.intelligence = 10;
	    this.pA = 3;
	    this.pM = 3;
	    this.regenPA = 1 ;
	    this.maxPA = 3 ;
	    this.maxPM=3;}
	    
    public Bandit(int x, int y){
        super(x, y);}
    


    @Override
    public String toString() {
        return "Bandit [hP=" + hP + ", pA=" + pA + ", pM=" + pM + "]";
    }
    
    public static void tourBandit(Personnage j, Personnage cible, int[][] obstacles, Carte carte) {
    	int distanceX = cible.getX()-j.getX();
		int distanceY = cible.getY()-j.getY();
		int distance = Math.abs(distanceX)+Math.abs(distanceY);
		int pos1x = 0 ;
		int pos1y = 0 ;
		int pos2x = 0 ;
		int pos2y = 0 ;
		int pos3x = 0 ;
		int pos3y = 0 ;
		int pos4x = 0 ;
		int pos4y = 0 ;
		if (distance > 3) {
			while (distance >3 && j.getpM()>0) {
				if (Math.abs(distanceX)>=Math.abs(distanceY)) {
					if (distanceX>=0) {
						pos1x=j.getX()+1;
						pos1y=j.getY();
						pos3x=j.getX()-1;
						pos3y=j.getY();
						if(distanceY>=0) {
							pos2x=j.getX();
							pos2y=j.getY()+1;
							pos4x=j.getX();
							pos4y=j.getY()-1;
						}
						else {
							pos2x=j.getX();
							pos2y=j.getY()-1;
							pos4x=j.getX();
							pos4y=j.getY()+1;
						}
					}
					else {
						pos1x=j.getX()-1;
						pos1y=j.getY();
						pos3x=j.getX()+1;
						pos3y=j.getY();
						if(distanceY>=0) {
							pos2x=j.getX();
							pos2y=j.getY()+1;
							pos4x=j.getX();
							pos4y=j.getY()-1;
						}
						else {
							pos2x=j.getX();
							pos2y=j.getY()-1;
							pos4x=j.getX();
							pos4y=j.getY()+1;
						}
					}
				}
				else {
					if (distanceY>=0) {
						pos1x=j.getX();
						pos1y=j.getY()+1;
						pos3x=j.getX();
						pos3y=j.getY()-1;
						if(distanceX>=0) {
							pos2x=j.getX()+1;
							pos2y=j.getY();
							pos4x=j.getX()-1;
							pos4y=j.getY();
						}
						else {
							pos2x=j.getX()-1;
							pos2y=j.getY();
							pos4x=j.getX()+1;
							pos4y=j.getY();
						}
					}
					else {
						pos1x=j.getX();
						pos1y=j.getY()-1;
						pos3x=j.getX();
						pos3y=j.getY()+1;
						if(distanceX>=0) {
							pos2x=j.getX()+1;
							pos2y=j.getY();
							pos4x=j.getX()-1;
							pos4y=j.getY();
						}
						else {
							pos2x=j.getX()-1;
							pos2y=j.getY();
							pos4x=j.getX()+1;
							pos4y=j.getY();
						}
					}
				}
				if(obstacles[pos1x][pos1y]==0) {j.setX(pos1x);j.setY(pos1y);}
				else if(obstacles[pos2x][pos2y]==0) {j.setX(pos2x);j.setY(pos2y);}
				else if(obstacles[pos4x][pos4y]==0) {j.setX(pos4x);j.setY(pos4y);}
				else if(obstacles[pos3x][pos3y]==0) {j.setX(pos3x);j.setY(pos3y);}
				else {System.out.println("Peut pas bouger");return;}
				j.setpM(j.getpM()-1);
				distanceX = cible.getX()-j.getX();
				distanceY = cible.getY()-j.getY();
				distance = Math.abs(distanceX)+Math.abs(distanceY);
			}
		}
		if (distance==1 && j.getpA()>0) {
			System.out.println("Dague empoisonnée");
			j.setpA(j.getpA()-1);
			Random rand2 = new Random();
			int proba = rand2.nextInt(10);
			if (proba>=4) {
				System.out.println("-"+j.getAttaque()+j.getIntelligence()/2+"hp");
//				System.out.println("Vous êtes empoisonné ("+j.getIntelligence()/2+" dégats par tour");
				cible.sethP(cible.gethP()-j.getAttaque());
			}
			else {
				System.out.println("Vous esquivez");
			}	
		}
		else if (distance<=3) {
			System.out.println("Jet de couteau");
			j.setpA(j.getpA()-2);
			Random rand2 = new Random();
			int proba = rand2.nextInt(10);
			if (proba>=1) {
				System.out.println("-"+j.getIntelligence()+"hp");
				cible.sethP(cible.gethP()-j.getAttaque());
			}
			else {
				System.out.println("Vous esquivez");
			}
		}
		while (j.getpM()>0) {
			if (Math.abs(distanceX)>=Math.abs(distanceY)) {
				if (distanceX>=0) {
					pos4x=j.getX()+1;
					pos4y=j.getY();
					pos2x=j.getX()-1;
					pos2y=j.getY();
					if(distanceY>=0) {
						pos3x=j.getX();
						pos3y=j.getY()+1;
						pos1x=j.getX();
						pos1y=j.getY()-1;
					}
					else {
						pos3x=j.getX();
						pos3y=j.getY()-1;
						pos1x=j.getX();
						pos1y=j.getY()+1;
					}
				}
				else {
					pos4x=j.getX()-1;
					pos4y=j.getY();
					pos2x=j.getX()+1;
					pos2y=j.getY();
					if(distanceY>=0) {
						pos3x=j.getX();
						pos3y=j.getY()+1;
						pos1x=j.getX();
						pos1y=j.getY()-1;
					}
					else {
						pos3x=j.getX();
						pos3y=j.getY()-1;
						pos1x=j.getX();
						pos1y=j.getY()+1;
					}
				}
			}
			else {
				if (distanceY>=0) {
					pos4x=j.getX();
					pos4y=j.getY()+1;
					pos2x=j.getX();
					pos2y=j.getY()-1;
					if(distanceX>=0) {
						pos3x=j.getX()+1;
						pos3y=j.getY();
						pos1x=j.getX()-1;
						pos1y=j.getY();
					}
					else {
						pos3x=j.getX()-1;
						pos3y=j.getY();
						pos1x=j.getX()+1;
						pos1y=j.getY();
					}
				}
				else {
					pos4x=j.getX();
					pos4y=j.getY()-1;
					pos2x=j.getX();
					pos2y=j.getY()+1;
					if(distanceX>=0) {
						pos3x=j.getX()+1;
						pos3y=j.getY();
						pos1x=j.getX()-1;
						pos1y=j.getY();
					}
					else {
						pos3x=j.getX()-1;
						pos3y=j.getY();
						pos1x=j.getX()+1;
						pos1y=j.getY();
					}
				}
			}
			if(obstacles[pos1x][pos1y]==0) {j.setX(pos1x);j.setY(pos1y);}
			else if(obstacles[pos2x][pos2y]==0) {j.setX(pos2x);j.setY(pos2y);}
			else if(obstacles[pos4x][pos4y]==0) {j.setX(pos4x);j.setY(pos4y);}
			else if(obstacles[pos3x][pos3y]==0) {j.setX(pos3x);j.setY(pos3y);}
			else {System.out.println("Peut pas bouger");return;}
			j.setpM(j.getpM()-1);
			distanceX = cible.getX()-j.getX();
			distanceY = cible.getY()-j.getY();
			distance = Math.abs(distanceX)+Math.abs(distanceY);
		}
	}
}