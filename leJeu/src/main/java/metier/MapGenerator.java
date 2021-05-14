package metier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MapGenerator extends JPanel {


	public static void GeneratorMap(Carte c,int obstacles[][]) {
		
		int WIDTH = 400;
		int HEIGTH = 400;
		BufferedImage image = new BufferedImage(WIDTH,HEIGTH,BufferedImage.TYPE_INT_RGB);
		Graphics2D g;
		g = (Graphics2D) image.getGraphics();
		g.dispose();
		int tileSize = 32;
		int map[][] = new int[c.getX()][c.getY()];	
		for ( int ln = 0; ln < c.getX(); ln++)
		{
			
			for ( int col = 0; col < c.getY(); col++) 
			{
				int rc = map[ln][col];
				if (obstacles[ln][col]==1) {rc=3;} //Obstacle haut
				else if (obstacles[ln][col]==2) {rc=4;} //Obstacle bas
				switch (rc){
				case 0:
					g.setColor(Color.GREEN);break; //Case vide
				case 1:
					g.setColor(Color.BLUE);break; //Joueur 1
				case 2:
					g.setColor(Color.RED);break; //Joueur 2
				case 3:
					g.setColor(Color.BLACK);break; //Obstacle haut
				case 4:
					g.setColor(Color.GRAY);break; //Obstacle bas
				}
				
				g.fillRect(col * tileSize - 1, ln * tileSize - 1, tileSize,tileSize);
				
			}
			
		}
		
	}
	
public static void GeneratorMapPlacement(Carte c,int obstacles[][]) {
		
		int WIDTH = 400;
		int HEIGTH = 400;
		BufferedImage image = new BufferedImage(WIDTH,HEIGTH,BufferedImage.TYPE_INT_RGB);
		Graphics2D g;
		g = (Graphics2D) image.getGraphics();
		g.dispose();
		int tileSize = 32;
		int map[][] = new int[c.getX()][c.getY()];	
	//Placement des positions de départ pour choix
		map[Math.round(c.getX()/2)][2]=1;
		map[Math.round((c.getX()/2)-1)][2]=1;
		map[Math.round((c.getX()/2)+1)][3]=1;
		map[Math.round((c.getX()/2)-2)][3]=1;
		map[Math.round(c.getX()/2)][c.getY()-2]=2;
		map[Math.round((c.getX()/2)-1)][c.getY()-2]=2;
		map[Math.round((c.getX()/2)+1)][c.getY()-3]=2;
		map[Math.round((c.getX()/2)-2)][c.getY()-3]=2;
		for ( int ln = 0; ln < c.getX(); ln++)
		{
			for ( int col = 0; col < c.getY(); col++) 
			{
				int rc = map[ln][col];
				if (obstacles[ln][col]==1) {rc=3;} //Obstacle haut
				else if (obstacles[ln][col]==2) {rc=4;} //Obstacle bas
				switch (rc){
				case 0:
					g.setColor(Color.GREEN);break; //Case vide
				case 1:
					g.setColor(Color.BLUE);break; //Joueur 1
				case 2:
					g.setColor(Color.RED);break; //Joueur 2
				case 3:
					g.setColor(Color.BLACK);break; //Obstacle haut
				case 4:
					g.setColor(Color.GRAY);break; //Obstacle bas
				}
				
				g.fillRect(col * tileSize - 1, ln * tileSize - 1, tileSize,tileSize);
				
			}
			
		}
		
	}

	

}

