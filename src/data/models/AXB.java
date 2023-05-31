package data.models;

import java.util.*;

public class AXB extends Promocion {

	public AXB(String nombre, double duracion, String tipo, List<Atraccion> atracciones) {

		super(nombre, duracion, tipo, atracciones);

	}

	protected void aplicarDescuento() {
		int suma = 0;
		for (int i = 0; i < atracciones.size() - 1; i++)
			suma += atracciones.get(i).getPrecio();

		precioSinDescuento = suma;
		this.precioFinal = suma;
	}

}
