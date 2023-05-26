package data.models;

public abstract class Oferta implements Comparable<Oferta> {

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
	
	@Override
	public int compareTo(Oferta oferta) {
		
		Object ofertaActual = this.getClass();
		Object ofertaNueva = oferta.getClass();
		
		//Una promocion se prioriza sobre una atraccion
		if(ofertaActual == Promocion.class && ofertaNueva == Atraccion.class) {
			return -1;
		}
		
		if(ofertaActual == Atraccion.class && ofertaNueva == Promocion.class) {
			return 1;
		}
		
		//Se prioriza la mayor duracion y costo
		if(this.duracion + this.costo > oferta.duracion + oferta.costo)
			return -1;
		if(this.duracion + this.costo < oferta.duracion + oferta.costo)
			return 1;
		
		return 1;
	}

}
