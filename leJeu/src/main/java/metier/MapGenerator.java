package metier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MapGenerator extends JPanel {


	public static void GeneratorMap() {
		
		int WIDTH = 400;
		int HEIGTH = 400;
		BufferedImage image = new BufferedImage(WIDTH,HEIGTH,BufferedImage.TYPE_INT_RGB);
		Graphics2D g;
		g = (Graphics2D) image.getGraphics();
		g.dispose();
		int mapWidth = 20;
		int mapHeigth = 20;
		int tileSize = 32;
		int[][] map;
		map =new int [][] {
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},		
				{0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
				
				
		
		for ( int ln = 0; ln < mapHeigth; ln++)
		{
			
			for ( int col = 0; col < mapWidth; col++) 
			{
				int rc = map[ln][col];

				switch (rc){
				case 0:
					g.setColor(Color.BLACK);
				    break;
				case 1:
					g.setColor(Color.WHITE);
				   break;
				}
				
				g.fillRect(col * tileSize - 1, ln * tileSize - 1, tileSize,tileSize);
				
			}
			
		}
		
		
		   
	}
	
	

	

}

