package clases;

public abstract class Oferta {
	
	private String nombre;
	private int costo;
	private float duracion;
	
	public Oferta(String nombre, int costo, float duracion) {
		
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
	}
	
	
}
