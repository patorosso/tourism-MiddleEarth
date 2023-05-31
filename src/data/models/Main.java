package data.models;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		List<Oferta> ofertas = new ArrayList<Oferta>();
		
		Archivo a1 = new Archivo("Usuarios");
		Archivo a2 = new Archivo("Atracciones");
		Archivo a3 = new Archivo("Promociones");
		
		//a1.leerArchivo();
		a2.leerArchivo();
		//a3.leerArchivo();

	}

}
