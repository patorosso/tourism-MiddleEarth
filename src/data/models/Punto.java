package data.models;

public class Punto {
	
	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + this.x + ";" + this.y + ")";
	}
}
