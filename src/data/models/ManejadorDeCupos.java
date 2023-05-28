package data.models;

public class ManejadorDeCupos {

	public static boolean tengoCupoPara(final Oferta oferta) {
		Object ofertaAClasificar;

		ofertaAClasificar = oferta.getClass().getSuperclass();

		if (ofertaAClasificar == Promocion.class) {
			Promocion promoTemporal = (Promocion) oferta;

			for (Atraccion atracciones : promoTemporal.getAtracciones()) {
				if (atracciones.getCupos() == 0)
					return false;
			}
		} else {

			Atraccion atraccionTemporal = (Atraccion) oferta;

			if (atraccionTemporal.getCupos() == 0)
				return false;
		}
		return true;
	}

	public static void restarCupo(final Oferta oferta) {

		Object ofertaAClasificar;

		ofertaAClasificar = oferta.getClass().getSuperclass();

		if (ofertaAClasificar == Promocion.class) {
			Promocion promoTemporal = (Promocion) oferta;

			for (Atraccion atraccion : promoTemporal.getAtracciones()) {
				int cupos = atraccion.getCupos();
				if (cupos > 0)
					atraccion.setCupos(cupos - 1);
			}

		} else {

			Atraccion atraccionTemporal = (Atraccion) oferta;

			int cupos = atraccionTemporal.getCupos();
			if (cupos > 0)
				atraccionTemporal.setCupos(cupos - 1);

		}

	}

}
