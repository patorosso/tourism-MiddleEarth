package data.models;

import data.models.excepcion.AtraccionExcepcion;

public class Atraccion extends Oferta {

	private int cupos;

	public Atraccion(String nombre, int precio, double duracion, String tipo, int cupos) throws AtraccionExcepcion {

		this.nombre = nombre;
		this.precioSinDescuento = precio;
		if (duracion < 0)
			throw new AtraccionExcepcion("Error");
		this.duracion = duracion;
		this.tipo = tipo;
		this.cupos = cupos;
	}

	@Override
	public int compareTo(Oferta otraOferta) {

		if (otraOferta.esPromocion())
			return 1;

		if (this.duracion + this.precioSinDescuento > otraOferta.getDuracion() + otraOferta.getPrecioSinDescuento())
			return -1;

		if (this.duracion + this.precioSinDescuento < otraOferta.getDuracion() + otraOferta.getPrecioSinDescuento())
			return 1;

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		Oferta other = (Oferta) obj;

		return this.nombre.equals(other.nombre);
	}

	@Override
	public boolean esPromocion() {
		return false;
	}

	@Override
	public boolean hayCupo() {
		return this.cupos > 0;
	}

	@Override
	public void restarCupo() {
		if (this.cupos > 0)
			this.cupos--;
	}

	@Override
	public String toString() {
		return "Atraccion\n" + "Nombre: [" + this.nombre + "]\n" + "-Precio: " + this.precioSinDescuento + "\n"
				+ "-Duracion: " + this.duracion + "\n";
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int getPrecioSinDescuento() {
		return this.precioSinDescuento;
	}

	@Override
	public int getPrecioConDescuento() {
		return this.precioSinDescuento;
	}

	@Override
	public double getDuracion() {
		return this.duracion;
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

}
