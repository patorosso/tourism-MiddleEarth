package data.models;

public class Absoluta extends Promocion{
	
	private int precioPromo;
	
	private int costo;
	
	public Absoluta (String nombre, int precio, double duracion, String tipo) {
		
		super(nombre, precio, duracion, tipo);
		
	}

	public int getPrecioPromo() {
		return precioPromo;
	}

	public void setPrecioPromo(int precioPromo) {
		this.precioPromo = precioPromo;
	}

//	public int getCosto() {
//		return costo;
//	}
//
//	public void setCosto(int costo) {
//		this.costo = costo;
//	}
	
	

}
