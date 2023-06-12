package data.models;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	private double porcentaje;

	public PromocionPorcentual(List<Oferta> ofertas, double porcentaje) {

		super(ofertas);
		this.porcentaje = porcentaje;

		this.precioConDescuento = this.precioSinDescuento - (int) (this.precioSinDescuento * this.porcentaje);
	}

}
