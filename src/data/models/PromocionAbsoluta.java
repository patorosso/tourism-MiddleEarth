package data.models;

import java.util.*;

public class PromocionAbsoluta extends Promocion {

	private int monto;
	
	public PromocionAbsoluta(List<Oferta> ofertas, int monto) {
		
		super(ofertas);
		this.monto = monto;
		this.precioConDescuento = this.precioSinDescuento - this.monto;
	}

}
