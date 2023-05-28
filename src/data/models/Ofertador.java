package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Ofertador implements IteratorOferta {

	private Usuario usuario;
	private List<Oferta> ofertasPreferencias;
	private List<Oferta> ofertasNoPreferencias;
	private int indice;

	public Ofertador(Usuario usuario, List<Oferta> ofertas) throws OfertadorExcepcion {

		if (usuario == null)
			throw new OfertadorExcepcion("No hay usuario");

		if (ofertas.isEmpty())
			throw new OfertadorExcepcion("No hay ofertas");

		this.usuario = usuario;
		this.ofertasPreferencias = ofertas;
		this.ofertasNoPreferencias = new ArrayList<Oferta>();
		this.indice = 0;

		Collections.sort(ofertas); // this.ordenarListaOfertas(this.ofertasPreferencias) era una sola línea
		this.dividirListas(this.ofertasPreferencias, this.ofertasNoPreferencias, this.usuario);
		ofertasPreferencias.addAll(ofertasNoPreferencias);

	}

	private void dividirListas(List<Oferta> ofertasPreferencias, List<Oferta> ofertasNoPreferencias, Usuario usuario) {

		// ¿Se deberia crear un iterador propio?
		Iterator<Oferta> itOferta = ofertasPreferencias.iterator();
		while (itOferta.hasNext()) {

			Oferta ofertaTemporal = itOferta.next();

			if (ofertaTemporal != null && !ofertaTemporal.getTipo().equals(usuario.getPreferencia())) {
				ofertasNoPreferencias.add(ofertaTemporal);
				itOferta.remove();
			}
		}
	}

	@Override
	public boolean tieneSiguienteOferta() {

		if (this.indice == this.ofertasPreferencias.size())
			return false;
		if (usuario.getTiempo() < this.ofertasPreferencias.get(this.indice).getDuracion())
			return false;
		if (usuario.getMonedas() < this.ofertasPreferencias.get(this.indice).getPrecio())
			return false;
		if (!ManejadorDeCupos.tengoCupoPara(this.ofertasPreferencias.get(this.indice)))
			return false;
		if (this.usuario.getOfertasCompradas() != null
				&& this.usuario.getOfertasCompradas().contains(this.ofertasPreferencias.get(this.indice)))
			return false;

		return true;
	}

	@Override
	public Oferta siguienteOferta() {

		if (!this.tieneSiguienteOferta())
			return null; // NoSuchElementException quiza devolver

		Oferta oferta = this.ofertasPreferencias.get(this.indice);
		this.indice++;
		return oferta;
	}

}
