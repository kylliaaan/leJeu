package frame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class NewCarte extends Canvas implements Runnable{

	public static final int WIDTH = 160;
	public static final int HEIGTH = WIDTH/12*9;
	public static final int scale = 8;
		
	private JFrame frame;
	
	
	public boolean running = false;
	public int tickCount = 0;
	
	public static final int mapWIDTH = 20;
	public static final int mapHEIGTH = 20;
	static int x = 0;
	static int y = 0;
	static int tilesize=32;
		
	static int[][] map =  {
			{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
			{8,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
			{8,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
			{8,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
			{8,0,0,0,8,8,8,8,8,0,0,0,8,8,8,8,0,0,0,8},
			{8,0,0,0,0,0,0,0,0,0,0,0,8,0,0,8,0,0,0,8},
			{8,0,0,0,0,0,0,0,0,0,0,8,8,0,0,8,0,0,0,8},
			{8,0,0,0,1,0,0,0,0,0,0,0,0,0,0,8,0,0,0,8},
			{8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,8},
			{8,0,0,0,0,8,0,0,0,0,0,0,0,0,0,8,8,8,8,8},
			{8,0,0,0,0,8,0,0,8,0,0,0,0,0,0,0,0,0,0,8},
			{8,0,0,0,0,0,0,0,8,0,0,0,0,0,0,4,0,0,0,8},
			{8,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,8},
			{8,0,0,0,0,8,0,0,8,0,0,0,0,0,0,0,0,0,0,8},
			{8,8,8,8,8,8,0,0,8,0,0,0,0,0,0,0,2,0,0,8},
			{8,0,0,0,0,0,0,0,8,8,8,8,8,0,0,0,0,0,0,8},
			{8,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,8},
			{8,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,8},
			{8,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,8},
			{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}
			};
	
	
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGTH, BufferedImage.TYPE_INT_RGB);
	private int[] pixels =((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	
	public NewCarte() {
		
		Canvas canvas = new Canvas();
				
		canvas.setMinimumSize(new Dimension(WIDTH * scale, HEIGHT * scale ));
		canvas.setMaximumSize(new Dimension(WIDTH * scale, HEIGHT * scale ));
		canvas.setPreferredSize(new Dimension(WIDTH * scale, HEIGHT * scale ));
		//canvas.setFocusable(false);
		
		frame = new JFrame("A la recherche du Sopra");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(400, 200, 652, 672);
		frame.getContentPane().setLayout(new BorderLayout());
		
		frame.getContentPane().add(this,BorderLayout.CENTER);
		
		/* JPanel jpanel = new JPanel();
		jpanel.setBounds(400, 200, 740, 672);
		jpanel.setLayout(null);
		jpanel.add(canvas,BorderLayout.CENTER);
		
		frame.add(jpanel); 
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(287, 567, 89, 28);
		jpanel.add(btnNewButton); */
		
			
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
				
	}
	
	public synchronized void stop() {
		
		running = false;
	}
	
	public void run() {
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while(running) // gestion du rafraichissement
		{
			long now = System.nanoTime();
			delta += (now-lastTime)/nsPerTick;
			lastTime = now ;
			boolean shouldRender = true;
			while (delta >=1) {

				ticks++;
				tick();
				delta-= 1;
				shouldRender = true;
			}
			try {
			Thread.sleep(2);}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender) {
			frames++;
			render();
			}

			if (System.currentTimeMillis() - lastTimer > 1000) 
			{
				lastTimer += 1000;
				frames = 0;
				ticks = 0;
			}
			
		}
		
	}

	public void tick() {
		tickCount++;
		
		 for (int i = 0 ; i<pixels.length; i++) {
			
			pixels[i] = i;
		} 
		
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null ) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH, HEIGTH, null);

		/*g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		*/
				
		for ( int ln = 0; ln < mapWIDTH; ln++)
		{

			for ( int col = 0; col < mapHEIGTH; col++) 
			{
				int rc = map[ln][col];
				
				switch (rc){
				case 0:
					g.setColor(Color.WHITE);break; //Case vide
				case 1:
					g.setColor(Color.BLUE);break; //Joueur 1
				case 2:
					g.setColor(Color.RED);break; //Joueur 2
				case 8:
					g.setColor(Color.GRAY);break; //Obstacle haut
				case 4:
					g.setColor(Color.BLACK);break; //Obstacle bas
				}

				g.fillRect((int) x +col * tilesize - 1, (int) y + ln * tilesize - 1, tilesize,tilesize);

			}

		}
		g.dispose();
		bs.show();
		
	}
	
	/* public static void main(String[] args) {
	
		new NewCarte().start();
	}*/
	
}