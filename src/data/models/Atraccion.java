package data.models;

public class Atraccion implements Oferta {
	
	private String nombre;
	private int precioSinDescuento;
	private float duracion;
	private String tipo;
	private int cupos;
	
	public Atraccion(String nombre, int precio, float duracion, String tipo, int cupos) {
		
		this.nombre = nombre;
		this.precioSinDescuento = precio;
		this.duracion = duracion;
		this.tipo = tipo;
		this.cupos = cupos;
	}
	
	@Override
	public int compareTo(Oferta otraOferta) {
		
		if(otraOferta.esPromocion())
			return 1;
		
		if(this.duracion + this.precioSinDescuento > 
		   otraOferta.getDuracion() + otraOferta.getPrecioSinDescuento())
			return -1;
		
		if(this.duracion + this.precioSinDescuento <
		   otraOferta.getDuracion() + otraOferta.getPrecioSinDescuento())
			return 1;
		
		return 0;
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
		if(this.cupos > 0)
			this.cupos --;	
	}
	
	@Override
	public String toString() {
		return "Atraccion\n" + 
			   "Nombre: [" + this.nombre + "]\n" +
			   "-Precio: " + this.precioSinDescuento + "\n" + 
			   "-Duracion: " + this.duracion + "\n";
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
	public float getDuracion() {
		return this.duracion;
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

	public int getCupos() {
		return this.cupos;
	}

}
