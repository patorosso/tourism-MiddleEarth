package data.models;

public abstract class Oferta {
	
	protected String nombre;
	protected int costo;
	protected float duracion;
	
	public Oferta(String nombre, int costo, float duracion) {
		
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
	}

	
}
