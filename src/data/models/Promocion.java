package data.models;

import java.util.List;

public abstract class Promocion extends Oferta {

	protected List<Atraccion> atracciones;
	protected int precioSinDescuento;

	public Promocion(String nombre, double duracion, String tipo, List<Atraccion> atracciones) {
		super(nombre, duracion, tipo);

		this.precioSinDescuento = 0;
		this.atracciones = atracciones;
		for (Atraccion atraccion : this.atracciones) {
			this.precioSinDescuento += atraccion.getPrecio();
		}
		aplicarDescuento();

	}

	public int getPrecioSinDescuento() {
		return precioSinDescuento;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	protected abstract void aplicarDescuento();

}
