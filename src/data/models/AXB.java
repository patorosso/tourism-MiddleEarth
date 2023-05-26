package data.models;

import java.util.ArrayList;

public class AXB extends Promocion{
	
	private ArrayList<Atraccion> gratis = new ArrayList<Atraccion>();
	
	public AXB (String nombre, int precio, double duracion, String tipo) {
		
		super(nombre, precio, duracion, tipo);
		
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
