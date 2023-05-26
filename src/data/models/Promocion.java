package data.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Promocion {
	
	private ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	private String nombre;
//	private double costo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public double getCosto() {
//		return costo;
//	}
//	public void setCosto(double costo) {
//		this.costo = costo;
//	}
	
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}
	

}
