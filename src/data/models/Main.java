package data.models;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Archivo archivo = new Archivo();
		
		List<Oferta> ofertas = new ArrayList<Oferta>();
		List<Usuario> usuarios = archivo.leerArchivoUsuarios();
		List<Atraccion> atracciones = archivo.leerArchivoAtracciones();
		List<Promocion> promociones = archivo.leerArchivoPromociones(atracciones);
		
		ofertas.addAll(atracciones);
		ofertas.addAll(promociones);
		
		Sistema sistema = new Sistema(usuarios, ofertas);
		sistema.ofertarActividades();
	}

}
