package data.models;

import java.util.*;

public class PromocionAxB extends Promocion {

	public PromocionAxB(List<Oferta> ofertas) {
		
		super(ofertas);
		this.precioConDescuento = this.precioSinDescuento - this.precioUltimaAtraccion;
	}

}
