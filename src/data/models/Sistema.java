package data.models;

import java.util.Iterator;
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
		System.out.println("------------------------");

		try {

			for (Usuario usuario : usuarios) {

				System.out.println("Nombre visitante: " + usuario.getNombre());
				Ofertador ofertador = new Ofertador(ofertas, usuario);

				while (ofertador.tieneSiguienteOferta()) {

					Oferta oferta = ofertador.siguienteOferta();

					if (oferta.esPromocion()) {
						Promocion promoTemporal = (Promocion) oferta;

						System.out.println("Promocion: " + promoTemporal.getNombre());
						System.out.print("- Atracciones incluidas: [");

						Iterator<Atraccion> itAtraccion = promoTemporal.getAtracciones().iterator();
						Atraccion atraccion;
						while (itAtraccion.hasNext()) {
							atraccion = itAtraccion.next();
							System.out.print(atraccion.getNombre());
							if (itAtraccion.hasNext())
								System.out.print(", ");
						}

						System.out.println("]");

						System.out.print("- Precio original: ");
						System.out.println("$" + promoTemporal.getPrecioSinDescuento());

						System.out.print("- Precio con descuento: ");
						System.out.println("$" + promoTemporal.getPrecio());

						System.out.print("- Duracion: ");
						System.out.println(promoTemporal.getDuracion());

						System.out.print("- Tipo:");
						System.out.println(promoTemporal.getTipo());

						Scanner scanner = new Scanner(System.in);
						char input;
						do {
							System.out.println("Acepta sugerencia? Ingrese S o N");
							input = scanner.next().toUpperCase().charAt(0);
						} while (input != 'S' && input != 'N');

						if (input == 'S') {
							usuario.agregarCompra(oferta);
							usuario.consumirTiempo(oferta.getDuracion());
							usuario.consumirMonedas(oferta.getPrecio());
							ManejadorDeCupos.restarCupo(oferta);
							System.out.println("Aceptada!");
						}

						System.out.println("------------------------");
					} else {

						Atraccion atraccionTemporal = (Atraccion) oferta;
						System.out.println("Atraccion: [" + atraccionTemporal.getNombre() + "]");
						System.out.println("- Precio: $" + atraccionTemporal.getPrecio());
						System.out.println("- Duracion: " + atraccionTemporal.getDuracion());
						System.out.print("- Tipo:");
						System.out.println(atraccionTemporal.getTipo());

						Scanner scanner = new Scanner(System.in);
						char input;
						do {
							System.out.println("Acepta sugerencia? Ingrese S o N");

							input = scanner.next().toUpperCase().charAt(0);
						} while (input != 'S' && input != 'N');

						if (input == 'S') {
							usuario.agregarCompra(oferta);
							usuario.consumirTiempo(oferta.getDuracion());
							usuario.consumirMonedas(oferta.getPrecio());
							ManejadorDeCupos.restarCupo(oferta);
						}

						System.out.println("------------------------");
					}

				}

			}

		} catch (OfertadorExcepcion e) {
			System.err.println("[Error capturado ofertador] " + e.getMessage());
		} catch (UsuarioExcepcion e) {
			System.out.println("[Error capturado usuario]" + e.getMessage());
		}
	}

}
