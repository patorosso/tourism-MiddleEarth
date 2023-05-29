package data.models;

import java.util.List;

public class Absoluta extends Promocion {

	private int montoADescontar = 400;

	public Absoluta(String nombre, double duracion, String tipo, List<Atraccion> atracciones) {

		super(nombre, duracion, tipo, atracciones);

	}

	public void aplicarDescuento() {

		int suma = 0;
		for (Atraccion atraccion : atracciones)
			suma += atraccion.getPrecio();

		precioSinDescuento = suma;
		suma -= montoADescontar;
		this.precioFinal = suma;
	}

}
