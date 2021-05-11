package metier;

public class Carte {
	protected String img;
	protected int x;
	protected int y;
	
	public Carte() {
		super();
	}

	public Carte(String img, int x, int y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
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
	
	
	
}