package metier;

import java.util.Random;

public class Gobelin extends Personnage
{



    public Gobelin(int id,int x, int y, int hP, int attaque, int intelligence, int pA, int pM, int regenPA, int maxPA, int maxPM) {
        super(id,x, y, hP, attaque, intelligence, pA, pM, regenPA, maxPA, maxPM);
}

    public Gobelin(){
	    this.hP = 50;
	    this.attaque = 5;
	    this.intelligence = 5;
	    this.pA = 3;
	    this.pM = 3;
	    this.regenPA = 1 ;
	    this.maxPA = 3 ;
	    this.maxPM=3;}
	    
    public Gobelin(int x, int y){
        super(x, y);
}



    @Override
    public String toString() {
        return "Gobelin [hP=" + hP + ", attaque=" + attaque + ", intelligence=" + intelligence + ", pA=" + pA + ", pM="
                + pM + ", regenPA=" + regenPA + "]";
    }
    
    public static void tourGobelin(Personnage j, Personnage cible, int[][] obstacles, Carte carte) {
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
		if (distance >1) {
			while (distance >1 && j.getpM()>0) {
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
				else if(obstacles[pos3x][pos3y]==0) {j.setX(pos3x);j.setY(pos3y);}
				else if(obstacles[pos4x][pos4y]==0) {j.setX(pos4x);j.setY(pos4y);}
				else {System.out.println("Peut pas bouger");return;}
				j.setpM(j.getpM()-1);
				distanceX = cible.getX()-j.getX();
				distanceY = cible.getY()-j.getY();
				distance = Math.abs(distanceX)+Math.abs(distanceY);
			}
		}
		if (distance==1 && j.getpA()>0) {
			System.out.println("Coup de poing");
			j.setpA(j.getpA()-1);
			Random rand2 = new Random();
			int proba = rand2.nextInt(10);
			System.out.println(proba);
			if (proba>=1) {
				System.out.println("-"+j.getAttaque()+"hp");
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
			System.out.println(proba);
			if (proba>=3) {
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
			else if(obstacles[pos3x][pos3y]==0) {j.setX(pos3x);j.setY(pos3y);}
			else if(obstacles[pos4x][pos4y]==0) {j.setX(pos4x);j.setY(pos4y);}
			else {System.out.println("Peut pas bouger");return;}
			j.setpM(j.getpM()-1);
			distanceX = cible.getX()-j.getX();
			distanceY = cible.getY()-j.getY();
			distance = Math.abs(distanceX)+Math.abs(distanceY);
		}
	}
}

//if (Math.abs(distanceX)>Math.abs(distanceY)) {
//if (distanceX>0) {
//	if(obstacles[j.getX()+1][j.getY()]==0) {
//		j.setX(j.getX()+1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceY>0) {
//		if(obstacles[j.getX()][j.getY()+1]==0) {
//		j.setY(j.getY()+1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceY<=0 && obstacles[j.getX()][j.getY()-1]==0) {
//		j.setY(j.getY()-1);
//		j.setpM(j.getpM()-1);}	
//}
//else if (distanceX<0){
//	if(obstacles[j.getX()-1][j.getY()]==0) {
//		j.setX(j.getX()-1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceY>0 && obstacles[j.getX()][j.getY()+1]==0) {
//		j.setY(j.getY()+1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceY<=0 && obstacles[j.getX()][j.getY()-1]==0) {
//		j.setY(j.getY()-1);
//		j.setpM(j.getpM()-1);}	
//}
//}
//if (Math.abs(distanceY)>=Math.abs(distanceX)) {
//if (distanceY>0) {
//	if(obstacles[j.getX()][j.getY()+1]==0) {
//		j.setY(j.getY()+1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceX>0 && obstacles[j.getX()+1][j.getY()]==0) {
//		j.setX(j.getX()+1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceX<=0 && obstacles[j.getX()-1][j.getY()]==0) {
//		j.setX(j.getX()-1);
//		j.setpM(j.getpM()-1);}	
//}
//else if (distanceY<0){
//	if(obstacles[j.getX()][j.getY()-1]==0) {
//		j.setY(j.getY()-1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceX>0 && obstacles[j.getX()+1][j.getY()]==0) {
//		j.setX(j.getX()+1);
//		j.setpM(j.getpM()-1);}
//	else if (distanceX<=0 && obstacles[j.getX()-1][j.getY()]==0) {
//		j.setX(j.getX()-1);
//		j.setpM(j.getpM()-1);}	
//}
//}