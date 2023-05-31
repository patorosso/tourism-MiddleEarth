package data.models;

import java.util.List;

public class Absoluta extends Promocion {

	private int montoADescontar;

	public Absoluta(String nombre, double duracion, String tipo, List<Atraccion> atracciones) {

		super(nombre, duracion, tipo, atracciones);

	}

	protected void aplicarDescuento() {

		int suma = 0;
		for (Atraccion atraccion : atracciones)
			suma += atraccion.getPrecio();
		
		montoADescontar  = 15;

		precioSinDescuento = suma;
		suma -= montoADescontar;
		this.precioFinal = suma;
	}

}
