package data.models;

import java.util.ArrayList;
import java.util.List;

public class AXB extends Promocion {

	private ArrayList<Atraccion> gratis = new ArrayList<Atraccion>();

	public AXB(String nombre, int precio, double duracion, String tipo, List<Atraccion> atracciones) {

		super(nombre, precio, duracion, tipo, atracciones);

	}

//	private int costo;
//
//	public int getCosto() {
//		return costo;
//	}
//
//	public void setCosto(int costo) {
//		this.costo = costo;
//	}

}
