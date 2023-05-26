package data.models;

import java.util.*;

import data.models.excepcion.AtraccionExcepcion;

public class ProbandoOrdenamiento {

	public static void main(String[] args) {
		
		try {
			Atraccion atraccion1 = new Atraccion("Atraccion 1", 10, 15.f, 4, "Paisaje"); //2
			Atraccion atraccion2 = new Atraccion("Atraccion 2", 8, 12.f, 4, "Aventura"); //3
			Atraccion atraccion3 = new Atraccion("Atraccion 3", 12, 18.f, 4, "Degustacion"); //1
			
			List<Oferta> ofertas = new ArrayList<Oferta>();
			
			ofertas.add(atraccion1);
			ofertas.add(atraccion2);
			ofertas.add(atraccion3);
			
			System.out.println("LISTA ORIGINAL");
			System.out.println("--------------");
			for (Oferta oferta : ofertas) {
				System.out.println(oferta.getNombre());
			}
			
			Ofertador.ordenarListaOfertas(ofertas);
			
			System.out.println("LISTA ORDENADA");
			System.out.println("--------------");
			for (Oferta oferta : ofertas) {
				System.out.println(oferta.getNombre());
			}
			
		} catch (AtraccionExcepcion e) {
			System.out.println("HOLA" + e.getMessage());
		}
		

	}

}
