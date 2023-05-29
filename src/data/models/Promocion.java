package data.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Promocion extends Oferta {

	protected List<Atraccion> atracciones = new ArrayList<Atraccion>();
	protected int precioSinDescuento;

	public Promocion(String nombre, double duracion, String tipo, List<Atraccion> atracciones) {
		super(nombre, duracion, tipo);

		this.precioSinDescuento = 0;
		this.atracciones = atracciones;
		for (Atraccion atraccion : this.atracciones) {
			this.precioSinDescuento += atraccion.getPrecio();
		}

	}

	public int getPrecioSinDescuento() {
		return precioSinDescuento;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public abstract void aplicarDescuento();

}
