package data.models;

import java.util.*;

public class Pruebas {
	
	public static void main(String[] args) {
		
		List<Oferta> ofertas = new ArrayList<Oferta>();
		
		Atraccion a1 = new Atraccion("Atraccion 1", 5, 3, "Aventura", 5); //3
		Atraccion a2 = new Atraccion("Atraccion 2", 25, 3, "Aventura", 5); //1
		Atraccion a3 = new Atraccion("Atraccion 3", 15, 3, "Aventura", 5); //2
		
		ofertas.add(a1);
		ofertas.add(a2);
		ofertas.add(a3);
		
		List<Oferta> atracciones = new ArrayList<Oferta>();
		
		Atraccion a4 = new Atraccion("Atraccion 4", 25, 3, "Aventura", 5);
		Atraccion a5 = new Atraccion("Atraccion 5", 25, 3, "Aventura", 5);
		Atraccion a6 = new Atraccion("Atraccion 6", 25, 3, "Aventura", 5);
		
		atracciones.add(a4);
		atracciones.add(a5);
		atracciones.add(a6);
		
		PromocionPorcentual p1 = new PromocionPorcentual(atracciones, 0.2);
		
		ofertas.add(p1);
		
		Collections.sort(ofertas);
		
		for(Oferta oferta : ofertas)
			System.out.println(oferta);
		
		
		
	}
}
