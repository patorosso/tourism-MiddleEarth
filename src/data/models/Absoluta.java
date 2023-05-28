package data.models;

import java.util.List;

public class Absoluta extends Promocion {

	private int precioPromo;

	private int costo;

	public Absoluta(String nombre, int precio, double duracion, String tipo, List<Atraccion> atracciones) {

		super(nombre, precio, duracion, tipo, atracciones);

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
