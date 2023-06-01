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

			for (Usuario usuario : usuarios) {

				System.out.println("Nombre visitante: " + usuario.getNombre() + "\n");
				Ofertador ofertador = new Ofertador(ofertas, usuario);

				while (ofertador.tieneSiguienteOferta()) {

					Oferta oferta = ofertador.siguienteOferta();
					System.out.println(oferta);

					//Bloque try arroja una exception
					Scanner scanner = new Scanner(System.in);
					char opcion;
					do {
						System.out.println("Acepta sugerencia? Ingrese S o N");
						opcion = scanner.next().toUpperCase().charAt(0);
					} while (opcion != 'S' && opcion != 'N');

					if (opcion == 'S') {
						usuario.agregarCompra(oferta);
						usuario.consumirTiempo(oferta.getDuracion());
						usuario.consumirMonedas(oferta.getPrecio());
						oferta.restarCupo();
						System.out.println("Aceptada!");
					}

					System.out.println("----------------------------\n");

				}

			}

		} catch (OfertadorExcepcion e) {
			System.err.println("[Error capturado ofertador] " + e.getMessage());
		} catch (UsuarioExcepcion e) {
			System.out.println("[Error capturado usuario]" + e.getMessage());
		}
	}

}
