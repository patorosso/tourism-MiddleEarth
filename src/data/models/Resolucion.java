package data.models;

import java.util.ArrayList;

import data.models.archivo.Archivo;

public class Resolucion {
	public void resolverVisitante(String nombreArchivo) {

		ArrayList<Visitante> visitantes = new ArrayList<Visitante>();

		Archivo archivo = new Archivo(nombreArchivo);
		archivo.leerArchivoYListarVisitante(visitantes);

//		Atracciones
//		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

	}

	public void resolverAtraccion(String nombreArchivo) {

//		ArrayList<Visitante> visitantes = new ArrayList<Visitante>();

		Archivo archivo = new Archivo(nombreArchivo);
//		archivo.leerArchivoYListar(visitantes);

//		Atracciones
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

	}
}
