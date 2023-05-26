package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Ofertador {

	private Usuario usuario;
	private List<Oferta> ofertasPreferencias;
	private List<Oferta> ofertasNoPreferencias;

	// Podria ser un singleton

	public Ofertador(Usuario usuario, List<Oferta> ofertas) throws OfertadorExcepcion {

		if (usuario == null)
			throw new OfertadorExcepcion("No hay usuario");

		if (ofertas.isEmpty())
			throw new OfertadorExcepcion("No hay ofertas");

		this.usuario = usuario;
		this.ofertasPreferencias = ofertas;

		this.ordenarListaOfertas(this.ofertasPreferencias);
		this.dividirListas(this.ofertasPreferencias, this.ofertasNoPreferencias, this.usuario);

	}

	private void ordenarListaOfertas(List<Oferta> ofertas) {
		Collections.sort(ofertas);
	}

	private void dividirListas(List<Oferta> ofertasPreferencias, List<Oferta> ofertasNoPreferencias, Usuario usuario) {

		ofertasNoPreferencias = new ArrayList<Oferta>();
		// Se deberia crear un iterador propio
		Iterator<Oferta> itOferta = ofertasPreferencias.iterator();

		while (itOferta.hasNext()) {

			Oferta ofertaTemporal = itOferta.next();

			if (ofertaTemporal != null && !ofertaTemporal.getTipo().equals(usuario.getPreferencia())) {

				ofertasNoPreferencias.add(ofertaTemporal);
				itOferta.remove();

			}
		}
	}

	public void ofertar() {
		Object ofertaAClasificar;

		System.out.println("Bienvenido " + usuario.getNombre());
		for (Oferta oferta : ofertasPreferencias) {

			// Puede ser absoluta, axb o porcentual, pero las trato mas facil como
			// Promocion.
			ofertaAClasificar = oferta.getClass().getSuperclass();

			if (ofertaAClasificar == Promocion.class) {
				Promocion promoTemporal = (Promocion) oferta;

				System.out.println("Promocion: " + promoTemporal.getNombre());
				System.out.print("- Atracciones incluidas: [ ");

				for (Atraccion atracciones : promoTemporal.getAtracciones()) {
					System.out.print(atracciones.getNombre() + ", ");

				}
				System.out.println("]");

				System.out.print("- Precio original: ");
				System.out.println("$" + promoTemporal.getPrecio());

				System.out.print("- Duracion: ");
				System.out.println(promoTemporal.getDuracion());
				
				
				
				//Lógica ¿acepta sugerencia?


				System.out.println("");
				System.out.println("------------------------");
			} else {

				Atraccion atraccionTemporal = (Atraccion) oferta;
				System.out.println("Atraccion: " + atraccionTemporal.getNombre());

			}

		}
	}

}

//if ((ofertaAClasificar == Absoluta.class) || (ofertaAClasificar == AXB.class)
//		|| (ofertaAClasificar == Porcentual.class))
