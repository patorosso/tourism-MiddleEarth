package data.models;

import java.util.List;

public class Porcentual extends Promocion {

	private int porcentaje;
//	private int costo;

	public Porcentual(String nombre, int precio, double duracion, String tipo, List<Atraccion> atracciones) {

		super(nombre, precio, duracion, tipo, atracciones);

	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

//	public int getCosto() {
//		return costo;
//	}
//	public void setCosto(int costo) {
//		this.costo = costo;
//	}

}
