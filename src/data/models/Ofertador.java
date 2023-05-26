package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Ofertador implements IteratorOferta {

	private Usuario usuario;
	private List<Oferta>  ofertas;
	private int indice;
	

	// Podria ser un singleton

	public Ofertador(Usuario usuario, List<Oferta> ofertas) throws OfertadorExcepcion {
		
		if(usuario == null)
			throw new OfertadorExcepcion("No hay usuario");
		
		if(ofertas.isEmpty())
			throw new OfertadorExcepcion("No hay ofertas");
		
		this.ordenarListaOfertas(ofertas);
		
		this.usuario = usuario;
		this.indice = 0;
		this.ofertas = ofertas;
	}	
	
	public static void ordenarListaOfertas(List<Oferta> ofertas) {
		Collections.sort(ofertas);
	}
	
	
	

	@Override
	public boolean tieneSiguienteOferta() {
		
		
		
		
		return false;
	}
	
	@Override
    public Oferta siguienteOferta() {
		
		if(tieneSiguienteOferta()) {
			Oferta ofertaActual = ofertas.get(indice);
			indice++;	
			return ofertaActual;
		}
		
        return null;
    }

}
