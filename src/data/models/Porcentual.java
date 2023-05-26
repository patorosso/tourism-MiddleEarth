package data.models;

public class Porcentual extends Promocion{
	
	private int porcentaje;
//	private int costo;
	
	public Porcentual(String nombre, int precio, double duracion, String tipo) {
		
		super(nombre, precio, duracion, tipo);
		
	}
	
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	
//	public int getCosto() {
//		return costo;
//	}
//	public void setCosto(int costo) {
//		this.costo = costo;
//	}
	
	

}
