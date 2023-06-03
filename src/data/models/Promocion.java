package data.models;

import java.util.*;

public abstract class Promocion extends Oferta {

	protected List<Oferta> ofertas;
	protected int precioConDescuento;
	protected int precioUltimaAtraccion;

	public Promocion(List<Oferta> ofertas) {

		this.ofertas = ofertas;
		this.nombre = "";

		// Tal vez no sea la mejor manera
		for (Oferta oferta : this.ofertas) {
			this.nombre += oferta.getNombre() + ", ";
			this.precioSinDescuento += oferta.getPrecioSinDescuento();
			this.duracion += oferta.getDuracion();
			this.tipo = oferta.getTipo();
			this.precioUltimaAtraccion = oferta.getPrecioSinDescuento();
		}

		this.nombre = this.nombre.substring(0, this.nombre.length() - 2);
	}

	
	@Override
	public boolean equals(Object obj) {
		Oferta other = (Oferta) obj;

		return this.ofertas.contains(other);
	}

	@Override
	public int compareTo(Oferta otraOferta) {

		if (!otraOferta.esPromocion())
			return -1;

		if (this.duracion + this.precioConDescuento > otraOferta.getDuracion() + otraOferta.getPrecioConDescuento())
			return -1;

		if (this.duracion + this.precioConDescuento < otraOferta.getDuracion() + otraOferta.getPrecioConDescuento())
			return 1;

		return 0;
	}

	@Override
	public boolean esPromocion() {
		return true;
	}

	@Override
	public boolean hayCupo() {
		for (Oferta oferta : ofertas)
			if (!oferta.hayCupo())
				return false;

		return true;
	}

	@Override
	public boolean restarCupo() {
		for (Oferta oferta : ofertas) {
			if (!oferta.restarCupo())
				return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Promocion\n" + "-Atracciones incluidas: [" + this.nombre + "]\n" + "-Duracion: " + this.duracion + "\n"
				+ "-Precio original: " + this.precioSinDescuento + "\n" + "-Precio con descuento: "
				+ this.precioConDescuento + "\n";
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int getPrecioSinDescuento() {
		return this.precioSinDescuento;
	}

	public int getPrecioConDescuento() {
		return this.precioConDescuento;
	}

	@Override
	public double getDuracion() {
		return this.duracion;
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

	public List<Oferta> getOfertas() {
		return this.ofertas;
	}

}
