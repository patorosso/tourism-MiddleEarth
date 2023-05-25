package main;

import java.util.ArrayList;
import java.util.Scanner;

import data.models.AplicacionMovil;
import data.models.Atraccion;
import data.models.Promocion;
import data.models.TpResolucion;
import data.models.Visitante;

public class TpMain {

	public static void main(String[] args) {
		
		AplicacionMovil aplicacion = new AplicacionMovil();

		ArrayList<Visitante> visitantes = new ArrayList<Visitante>();

		TpResolucion resolucion_visita = new TpResolucion();
		resolucion_visita.resolverVisitante("disponibilidad_usuario", visitantes);
		
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		TpResolucion resolucion_promocion = new TpResolucion();
		resolucion_promocion.resolverPromocion("promociones", promociones);
		
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		TpResolucion resolucion_atraccion = new TpResolucion();
		resolucion_atraccion.resolverAtraccion("atracciones", atracciones);
		
		aplicacion.proceso(visitantes, promociones, atracciones);
		

	}

}
