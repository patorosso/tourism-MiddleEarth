package data.models;

import java.util.*;

public class Variedades {
	
	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<String>();
		lista.add("Estrella de la Muerte");
		lista.add("Hoth");
		
//		System.out.println("-Atracciones incluidas: " + lista);
		
		List<Punto> puntos = new ArrayList<Punto>();
		Punto p1 = new Punto(1, 0);
		Punto p2 = new Punto(2, 0);
		Punto p3 = new Punto(3, 0);
		puntos.add(p1);
		puntos.add(p2);
		puntos.add(p3);
		
		System.out.println(puntos);
		
	}
}
