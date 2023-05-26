package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Ofertador {

	private Usuario usuario;
	private List<Oferta>  ofertasPreferencias;
	private List<Oferta>  ofertasNoPreferencias;
	private int indice;
	

	// Podria ser un singleton

	public Ofertador(Usuario usuario, List<Oferta> ofertas) throws OfertadorExcepcion {
		
		if(usuario == null)
			throw new OfertadorExcepcion("No hay usuario");
		
		if(ofertas.isEmpty())
			throw new OfertadorExcepcion("No hay ofertas");
		
		this.usuario = usuario;
		this.ofertasPreferencias = ofertas;
		this.indice = 0;
		
		this.ordenarListaOfertas(this.ofertasPreferencias);
		this.dividirListas(this.ofertasPreferencias, this.ofertasNoPreferencias, this.usuario);
		
	}	
	
	private void ordenarListaOfertas(List<Oferta> ofertas) {
		Collections.sort(ofertas);
	}
	
	private void dividirListas(List<Oferta> ofertasPreferencias, 
							   List<Oferta> ofertasNoPreferencias, Usuario usuario) {
		
		//Se deberia crear un iterador propio
		Iterator<Oferta> itOferta = ofertasPreferencias.iterator();
		
		while(itOferta.hasNext()) {
			
			Oferta ofertaTemporal = itOferta.next();
			
			if(!ofertaTemporal.getTipo().equals(usuario.getPreferencia())){
				ofertasNoPreferencias.add(ofertaTemporal);
				itOferta.remove();
			}
		}
	}
	
	
	

//	@Override
//	public boolean tieneSiguienteOferta() {
//		
//		
//		
//		
//		return false;
//	}
//	
//	@Override
//    public Oferta siguienteOferta() {
//		
//		if(tieneSiguienteOferta()) {
//			Oferta ofertaActual = ofertasPreferencias.get(indice);
//			indice++;	
//			return ofertaActual;
//		}
//		
//        return null;
//    }

}
