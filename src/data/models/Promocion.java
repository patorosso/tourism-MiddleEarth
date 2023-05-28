package data.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Promocion extends Oferta {

	protected List<Atraccion> atracciones = new ArrayList<Atraccion>();
	protected int precioTotal;

	public Promocion(String nombre, int precio, double duracion, String tipo, List<Atraccion> atracciones) {
		super(nombre, precio, duracion, tipo);

		this.precioTotal = 0;
		this.atracciones = atracciones;
		for (Atraccion atraccion : this.atracciones) {
			this.precioTotal += atraccion.getPrecio();
		}

	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
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
