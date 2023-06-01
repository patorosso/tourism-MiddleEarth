package data.models;

import java.util.*;

public abstract class Promocion implements Oferta {
	
	protected List<Oferta> ofertas = new ArrayList<Oferta>();
	protected String nombre;
	protected int precioSinDescuento;
	protected int precioConDescuento;
	protected float duracion;
	protected String tipo;
	protected int precioUltimaAtraccion;
	
	public Promocion(List<Oferta> ofertas) {
		
		this.ofertas = ofertas;
		this.nombre = "";
		this.precioSinDescuento = 0;
		this.precioConDescuento = 0;
		this.duracion = 0;
		this.tipo = "";
		this.precioUltimaAtraccion = 0;
		
		for(Oferta oferta : this.ofertas) {
			this.nombre += oferta.getNombre() + ",";
			this.precioSinDescuento += oferta.getPrecioSinDescuento();
			this.duracion += oferta.getDuracion();
			this.tipo = oferta.getTipo();
			this.precioUltimaAtraccion = oferta.getPrecioSinDescuento();
		}
		
		this.nombre = this.nombre.substring(0, this.nombre.length()-1);
	}
	
	@Override
	public int compareTo(Oferta otraOferta) {
		
		if(!otraOferta.esPromocion())
			return -1;
		
		if(this.duracion + this.precioConDescuento > 
		   otraOferta.getDuracion() + otraOferta.getPrecioConDescuento())
			return -1;
		
		if(this.duracion + this.precioConDescuento <
		   otraOferta.getDuracion() + otraOferta.getPrecioConDescuento())
			return 1;
		
		return 0;
	}
	
	@Override
	public boolean esPromocion() {
		return true;
	}
	
	@Override
	public boolean hayCupo() {
		for(Oferta oferta : ofertas)
			if(!oferta.hayCupo())
				return false;
		
		return true;
	}

	@Override
	public void restarCupo() {
		for(Oferta oferta : ofertas)
			oferta.restarCupo();
	}
	
	@Override
 	public String toString() {
		return "Promocion\n" + 
			   "-Atracciones incluidas: [" + this.nombre + "]\n" + 
			   "-Duracion: " + this.duracion + "\n" +
			   "-Precio original: " + this.precioSinDescuento + "\n" + 
			   "-Precio con descuento: " + this.precioConDescuento + "\n";
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
	public float getDuracion() {
		return this.duracion;
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

	public List<Oferta> getOfertas(){
		return this.ofertas;
	}
	
}
