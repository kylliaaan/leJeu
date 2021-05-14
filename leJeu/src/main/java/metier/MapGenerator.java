package metier;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MapGenerator extends JPanel {

	
	int WIDTH = 400;
	int HEIGTH = 400;
	BufferedImage image = new BufferedImage(WIDTH,HEIGTH,BufferedImage.TYPE_INT_RGB);
	Graphics2D g  = (Graphics2D) image.getGraphics();
	// g.dispose();
	int tileSize = 32;
	int x = 0,y = 0;
	int map[][];
	

	
	public void map(Carte c) {
		int map[][] = new int[c.getX()][c.getY()];
	}
	
		
	public void draw(Graphics2D g, Carte c)	{

		g.clearRect(tileSize, tileSize, WIDTH, HEIGTH);

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

				g.fillRect((int) x +col * tileSize - 1, (int) y + ln * tileSize - 1, tileSize,tileSize);

			}

		}
	}
	
		
	

	

}

