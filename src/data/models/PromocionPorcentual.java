package data.models;

import java.util.*;

public class PromocionPorcentual extends Promocion {

	private double porcentaje;
	
	public PromocionPorcentual(List<Oferta> ofertas, double porcentaje) {
		
		super(ofertas);
		this.porcentaje = porcentaje;
		
		//Tal vez debería haber un método para aplicar el descuento
		this.precioConDescuento = this.precioSinDescuento - (int)(this.precioSinDescuento * this.porcentaje);
	}
	
}
