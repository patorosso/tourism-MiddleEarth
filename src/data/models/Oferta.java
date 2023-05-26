package data.models;

public abstract class Oferta implements Comparable<Oferta> {

	protected String nombre;
	protected int precio;
	protected double duracion;
	protected String tipo;
	
	
	public Oferta(String nombre, int precio, double duracion, String tipo) {

		this.nombre = nombre;
		this.precio = precio;
		this.duracion = duracion;
		this.tipo = tipo;
	}
	
	@Override
	public int compareTo(Oferta oferta) {
		
		Object ofertaActual = this.getClass();
		Object ofertaNueva = oferta.getClass();
		
		//Las preferencias se priorizan
		
		//Una promocion se prioriza sobre una atraccion
		if(ofertaActual == Promocion.class && ofertaNueva == Atraccion.class) {
			return -1;
		}
		
		if(ofertaActual == Atraccion.class && ofertaNueva == Promocion.class) {
			return 1;
		}
		
		//Se prioriza la mayor duracion y costo
		if(this.duracion + this.precio > oferta.duracion + oferta.precio)
			return -1;
		if(this.duracion + this.precio < oferta.duracion + oferta.precio)
			return 1;
		
		return 0;		
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPrecio() {
		return precio;
	}
	
	public double getDuracion() {
		return duracion;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(int costo) {
		this.precio = costo;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

}
