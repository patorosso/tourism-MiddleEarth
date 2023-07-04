package data.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import data.models.excepcion.OfertadorExcepcion;

public class Ofertador implements IteratorOferta {

	private Usuario usuario;
	private List<Oferta> ofertas;
	private int indice;

	public Ofertador(List<Oferta> ofertas, Usuario usuario) throws OfertadorExcepcion {

		if (usuario == null)
			throw new OfertadorExcepcion("No hay usuario");

		if (ofertas.isEmpty())
			throw new OfertadorExcepcion("No hay ofertas");

		this.usuario = usuario;
		this.ofertas = ofertas;
		this.indice = 0;

		ordenarLista(this.ofertas);
	}

	public void eliminarOferta() {
		this.indice--;
		this.ofertas.remove(this.indice);
	}

	private void ordenarLista(List<Oferta> ofertas) {

		Collections.sort(ofertas);
		List<Oferta> ofertasSinPreferencias = new ArrayList<Oferta>();

		Iterator<Oferta> itOferta = ofertas.iterator();
		while (itOferta.hasNext()) {

			Oferta ofertaTemporal = itOferta.next();

			if (ofertaTemporal != null && !ofertaTemporal.getTipo().equals(usuario.getPreferencia())) {
				ofertasSinPreferencias.add(ofertaTemporal);
				itOferta.remove();
			}
		}

		this.ofertas.addAll(ofertasSinPreferencias); // Juntamos ambas listas en la lista ofertas original.
	}

	@Override
	public boolean tieneSiguienteOferta() {

		while (this.indice < this.ofertas.size()) {
			if (this.ofertas.get(indice).hayCupo()
					&& this.usuario.getTiempo() >= this.ofertas.get(this.indice).getDuracion()
					&& this.usuario.getMonedas() >= this.ofertas.get(this.indice).getPrecioConDescuento()
					&& !this.yaComproEstaOferta(this.ofertas.get(this.indice)))
				return true;

			this.indice++;
		}

		return false;
	}

	@Override
	public Oferta siguienteOferta() {

		if (!this.tieneSiguienteOferta())
			return null;

		Oferta oferta = this.ofertas.get(this.indice);
		this.indice++;
		return oferta;
	}

	private boolean yaComproEstaOferta(Oferta oferta) {

		List<Oferta> compras = usuario.getOfertasCompradas();

		if (compras.isEmpty())
			return false;

		for (Oferta compra : compras) {
			if (compra.equals(oferta))
				return true;

		}

		return false;
	}

}
