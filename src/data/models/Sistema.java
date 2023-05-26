package data.models;

import java.util.List;

import data.models.excepcion.OfertadorExcepcion;

public class Sistema {

	private Usuario usuario;
	private List<Oferta> ofertas; //desordenada, la que lei de los archivos
	
	
	public Sistema(Usuario usuario, List<Oferta> ofertas) {
		this.usuario = usuario;
		this.ofertas = ofertas;
	}
	
	public void ofertarActividades(){
		try {
			Ofertador ofertador = new Ofertador(usuario,ofertas);
			ofertador.ofertar();
			
		} catch (OfertadorExcepcion e) {
			System.err.println("[Error capturado] " + e.getMessage());
		}
	}

}
