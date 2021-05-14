package metier;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Carte {
	protected String img;
	protected int x;
	protected int y;
	private int haut;
	private int bas;
	
	@Enumerated(EnumType.STRING)
	private Carte_enum ce;
	
	public Carte() {
		super();
	}

	public Carte(String img, int x, int y, int haut, int bas) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.haut=haut;
		this.bas=bas;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

	@Override
	public String toString() {
		return "Carte [img=" + img + ", x=" + x + ", y=" + y + "]";
	}

	public int getHaut() {
		return haut;
	}

	public void setHaut(int haut) {
		this.haut = haut;
	}

	public int getBas() {
		return bas;
	}

	public void setBas(int bas) {
		this.bas = bas;
	}
	
	
	
}