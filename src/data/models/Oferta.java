package data.models;

public abstract class Oferta {

	protected String nombre;
	protected int costo;
	protected double duracion;

	public Oferta(String nombre, int costo, double duracion) {

		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

}
