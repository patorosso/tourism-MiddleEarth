package data.models;

import java.util.*;

import data.models.excepcion.AtraccionExcepcion;
import data.models.excepcion.UsuarioExcepcion;

public class ProbandoOrdenamiento {

	public static void main(String[] args) {

		try {
			Atraccion atraccion1 = new Atraccion("Atraccion 1", 10, 15.f, 4, "Paisaje"); // 2
			Atraccion atraccion2 = new Atraccion("Atraccion 2", 8, 12.f, 4, "Aventura"); // 3
			Atraccion atraccion3 = new Atraccion("Atraccion 3", 12, 18.f, 4, "Degustacion"); // 1

			List<Oferta> ofertas = new ArrayList<Oferta>();

			ofertas.add(atraccion1);
			ofertas.add(atraccion2);
			ofertas.add(atraccion3);

//			System.out.println("LISTA ORIGINAL");
//			System.out.println("--------------");
//			for (Oferta oferta : ofertas) {
//				System.out.println(oferta.getNombre());
//			}
//			
//			//Ofertador.ordenarListaOfertas(ofertas);
//			
//			System.out.println("LISTA ORDENADA");
//			System.out.println("--------------");
//			for (Oferta oferta : ofertas) {
//				System.out.println(oferta.getNombre());
//			}

			List<Atraccion> atracciones = new ArrayList<Atraccion>();

			Atraccion atraccion4 = new Atraccion("Atraccion 1", 10, 15.f, 4, "Paisaje");
			Atraccion atraccion5 = new Atraccion("Atraccion 5", 8, 12.f, 4, "Aventura");
			Atraccion atraccion6 = new Atraccion("Atraccion 6", 12, 18.f, 4, "Degustacion");

			atracciones.add(atraccion4);
			atracciones.add(atraccion5);
			atracciones.add(atraccion6);

			Promocion promo1 = new Absoluta("Pack aventura", 150, 2.5, "Aventura", atracciones);

			ofertas.add(promo1);

			List<Usuario> usuarios = new ArrayList<Usuario>();

			Usuario user = new Usuario("Frodo", 1125, 1000, "Aventura");

			usuarios.add(user);

			Sistema system = new Sistema(usuarios, ofertas);

			system.ofertarActividades();

			System.out.println("\n\n");
			System.out.println("Resumen:\n\n");
			System.out.println("Monedas del usuario:" + user.getMonedas());
			System.out.println("Tiempo del usuario: " + user.getTiempo());
			for (Oferta oferta : user.getOfertasCompradas()) {
				System.out.println("Nombre de oferta: " + oferta.getNombre() + "\n\n");

				Object ofertaAClasificar = oferta.getClass().getSuperclass();
				if (ofertaAClasificar != Promocion.class) {
					Atraccion atraccionTemporal = (Atraccion) oferta;
					System.out.println("Cupos de la atraccion: " + atraccionTemporal.getCupos() + "\n\n");
				}

			}

		} catch (AtraccionExcepcion e) {
			System.out.println("HOLA" + e.getMessage());
		} catch (UsuarioExcepcion e) {
			System.err.println("Usuario error");
		}

	}

}
