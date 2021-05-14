package metier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MapGenerator extends JPanel {


	public static void GeneratorMap(Carte c) {
		
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

				switch (rc){
				case 0:
					g.setColor(Color.GREEN);break;
				case 1:
					g.setColor(Color.BLUE);break;
				case 2:
					g.setColor(Color.RED);break;
				}
				
				g.fillRect(col * tileSize - 1, ln * tileSize - 1, tileSize,tileSize);
				
			}
			
		}
		
		
		   
	}
	
	

	

}

