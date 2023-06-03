package data.models;

import java.util.List;
import java.util.Scanner;

import data.models.excepcion.OfertadorExcepcion;
import data.models.excepcion.UsuarioExcepcion;

public class Sistema {

	private List<Usuario> usuarios;
	private List<Oferta> ofertas; // Desordenada, se lee directamente del archivo

	public Sistema(List<Usuario> usuarios, List<Oferta> ofertas) {
		this.usuarios = usuarios;
		this.ofertas = ofertas;
	}

	public void ofertarActividades() {

		System.out.println("Bienvenido a la Tierra Media");
		System.out.println("----------------------------\n");

		try {

			// ABRIR UN ARCHIVO DE RESUMEN
			for (Usuario usuario : usuarios) {

				System.out.println("Nombre visitante: " + usuario.getNombre() + "\n");
				Ofertador ofertador = new Ofertador(ofertas, usuario);

				while (ofertador.tieneSiguienteOferta()) {

					Oferta oferta = ofertador.siguienteOferta();
					System.out.println(oferta);

					// Bloque try arroja una exception
					Scanner scanner = new Scanner(System.in);
					char opcion;
					do {
						System.out.println("Acepta sugerencia? Ingrese S o N");
						opcion = scanner.next().toUpperCase().charAt(0);
					} while (opcion != 'S' && opcion != 'N');

					if (opcion == 'S') {
						usuario.comprar(oferta);
						usuario.consumirTiempo(oferta.getDuracion());
						usuario.consumirMonedas(oferta.getPrecioConDescuento());
						if (!oferta.restarCupo())
							ofertador.eliminarOferta();
						System.out.println("Aceptada!");

					}

					System.out.println("----------------------------\n\n\n");

				}

				this.mostrarItinerario(usuario);
				
				Archivo archivo = new Archivo();
				
				archivo.guardarItinerario(usuario);

				System.out.println("Presione cualquier tecla para continuar...\n\n");

				Scanner scanner = new Scanner(System.in);
				char opcion;

				opcion = scanner.next().toUpperCase().charAt(0);

				System.out.print("\033[H\033[2J");
				System.out.flush();
				
				

			}

			System.out.println("FIN PROGRAMA");

		} catch (OfertadorExcepcion e) {
			System.err.println("[Error capturado ofertador] " + e.getMessage());
		} catch (UsuarioExcepcion e) {
			System.out.println("[Error capturado usuario]" + e.getMessage());
		}

	}

	private void mostrarItinerario(Usuario usuario) {

		System.out.println("ITINERARIO");
		System.out.println("----------\n");

		String nombre = "";
		int precio = 0;
		double duracion = 0;

		for (Oferta oferta : usuario.getOfertasCompradas()) {

			nombre += oferta + "\n";
			precio += oferta.getPrecioConDescuento();
			duracion += oferta.getDuracion();

		}

		System.out.println("Ofertas compradas: \n" + nombre);
		System.out.println("--------------------\n");
		System.out.println("TOTAL:\n");
		System.out.println("Precio total: " + precio);
		System.out.println("Duracion total: " + duracion);

		System.out.println("--------------------\n");

	}

}
