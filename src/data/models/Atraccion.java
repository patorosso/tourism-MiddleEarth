package data.models;

import java.util.*;

public class Atraccion extends Oferta {
	
	private int cupos;
	
	public Atraccion(String nombre, int precio, float duracion, String tipo, int cupos) {
		
		this.nombre = nombre;
		this.precioSinDescuento = precio;
		this.duracion = duracion;
		this.tipo = tipo;
		this.cupos = cupos;
	}
	
	@Override
	public List<Oferta> comprar() {
		List<Oferta> ofertas = new ArrayList<Oferta>();
		ofertas.add(this);
		
		return ofertas;
	}
	
	@Override
	public int compareTo(Oferta otraOferta) {
		
		if(otraOferta.esPromocion())
			return 1;
		
		//Tal vez no hagan falta 2 if y pueda resolverse con un return
		if(this.duracion + this.precioSinDescuento > 
		   otraOferta.getDuracion() + otraOferta.getPrecioSinDescuento())
			return -1;
		
		if(this.duracion + this.precioSinDescuento <
		   otraOferta.getDuracion() + otraOferta.getPrecioSinDescuento())
			return 1;
		
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
	Oferta other = (Oferta) obj;
	if(Objects.equals(this.nombre, other.nombre))
		return true;
	
	return false;
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
	public boolean restarCupo() {
		if(this.cupos > 0)
			this.cupos --;	
		
		return this.cupos != 0;
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
	// Tal vez no sea necesario
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
