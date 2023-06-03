package data.models;

import java.util.*;

public abstract class Oferta implements Comparable<Oferta> {

	protected String nombre;
	protected int precioSinDescuento;
	protected double duracion;
	protected String tipo;

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	public abstract boolean equals(Object obj);

	public abstract int compareTo(Oferta otraOferta);

	protected abstract boolean esPromocion();

	public abstract boolean hayCupo();

	public abstract boolean restarCupo();

	public abstract String toString();

	public abstract String getNombre();

	public abstract int getPrecioSinDescuento();

	public abstract int getPrecioConDescuento();

	public abstract double getDuracion();

	public abstract String getTipo();

}
