package data.models;

import java.util.List;

public class Porcentual extends Promocion {

	private double porcentaje = 0.2;

	public Porcentual(String nombre, double duracion, String tipo, List<Atraccion> atracciones) {

		super(nombre, duracion, tipo, atracciones);

	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	protected void aplicarDescuento() {

		int suma = 0;
		for (Atraccion atraccion : atracciones)
			suma += atraccion.getPrecio();
		
		precioSinDescuento = suma;
		suma *= porcentaje;
		this.precioFinal = suma;
	}

}
