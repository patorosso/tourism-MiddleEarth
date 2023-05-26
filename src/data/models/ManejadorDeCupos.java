package data.models;

import java.util.ArrayList;
import java.util.List;

public class ManejadorDeCupos {
	
	private ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	public boolean tengoCupoPara(final Oferta oferta) {
		final Atraccion atraccion = buscarOferta(oferta);
		
		if (atraccion != null) {
			return atraccion.getCupos() > 0;
		}
		
		return false; 
	}
	
	public void restarCupo(final Oferta oferta) {
		final Atraccion atraccion = buscarOferta(oferta);
		
		if (atraccion != null) {
			final int cupos = atraccion.getCupos();
			if (cupos > 0) {
				atraccion.setCupos(cupos - 1);
			}
		}
	}
	
	private Atraccion buscarOferta(final Oferta oferta) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(oferta.getNombre())) {
				return atraccion;
			}
		}
		
		return null;
	}
	
}
