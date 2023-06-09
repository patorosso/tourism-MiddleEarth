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

		try {

			for (Usuario usuario : usuarios) {

				System.out.println("Bienvenido a la Tierra Media");
				System.out.println("----------------------------\n");

				System.out.println("Nombre visitante: " + usuario.getNombre() + "\n");
				Ofertador ofertador = new Ofertador(ofertas, usuario);

				while (ofertador.tieneSiguienteOferta()) {

					Oferta oferta = ofertador.siguienteOferta();
					System.out.println(oferta);

					// Bloque try arroja una exception
					Scanner scanner = new Scanner(System.in);
					String opcion;
					do {
						System.out.println("Acepta sugerencia? Ingrese S o N\n");
						opcion = scanner.nextLine().toUpperCase();
					} while (!opcion.equals("S") && !opcion.equals("N"));

					if (opcion.equals("S")) {
						usuario.comprar(oferta);
						usuario.consumirTiempo(oferta.getDuracion());
						usuario.consumirMonedas(oferta.getPrecioConDescuento());
						oferta.restarCupo(); // Si no tiene cupo, no tiene sentido tenerla en la lista
						System.out.println("\nAceptada!");

					}

					System.out.println("----------------------------\n");

				}

				this.mostrarItinerario(usuario);

				Archivo archivo = new Archivo();

				archivo.guardarItinerario(usuario);

				System.out.println("Presione ENTER para continuar...\n");

				Scanner scanner = new Scanner(System.in);
				scanner.nextLine();

				System.out.println("----------------------------");

			}

			System.out.println("Ya no hay usuarios, el programa ha finalizado.");

		} catch (OfertadorExcepcion e) {
			System.err.println(e.getMessage());
		} catch (UsuarioExcepcion e) {
			System.out.println(e.getMessage());
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
