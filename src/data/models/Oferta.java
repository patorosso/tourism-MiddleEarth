package data.models;

public interface Oferta extends Comparable<Oferta> {
	
	int compareTo(Oferta otraOferta);
	boolean esPromocion();
	
	boolean hayCupo();
	void restarCupo();
	
	String toString();
	
	String getNombre();
	int getPrecioSinDescuento();
	int getPrecioConDescuento();
	float getDuracion();
	String getTipo();
}
