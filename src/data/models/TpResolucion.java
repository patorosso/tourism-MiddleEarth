package data.models;

import java.util.ArrayList;

import data.models.archivo.Archivo;

public class TpResolucion {

	public void resolverVisitante(String nombreArchivo, ArrayList<Visitante> visitantes) {

		Archivo archivo = new Archivo(nombreArchivo);
		archivo.leerArchivoYListarVisitante(visitantes);

//		
//		archivo.guardarArchivoEjercicio01(datos_fin);
	}

	public void resolverAtraccion(String nombreArchivo, ArrayList<Atraccion> atracciones) {

		Archivo archivo = new Archivo(nombreArchivo);
		archivo.leerArchivoYListarAtraccion(atracciones);

//		
//		archivo.guardarArchivoEjercicio01(datos_fin);
	}
	
	public void resolverPromocion(String nombreArchivo, ArrayList<Promocion> promociones) {

		Archivo archivo = new Archivo(nombreArchivo);
		archivo.leerArchivoYListarPromocion(promociones);

//		
//		archivo.guardarArchivoEjercicio01(datos_fin);
	}

}
