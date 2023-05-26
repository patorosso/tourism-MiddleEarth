package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Ofertador implements IteratorOferta {

	private List<Usuario> usuarios;
	private List<Oferta>  ofertas;
	private int indice;
	

	// Podria ser un singleton

	public Ofertador(List<Usuario> usuarios, List<Oferta> ofertas) throws OfertadorExcepcion {
		
		if(usuarios.isEmpty())
			throw new OfertadorExcepcion("No hay usuarios");
		
		if(ofertas.isEmpty())
			throw new OfertadorExcepcion("No hay ofertas");
		
		this.usuarios = usuarios;
		this.ofertas = ofertas;
		this.indice = 0;
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
