package data.models;

public class Atraccion {
	
	private String Nombre;
	private double Costo;
	private double Tiempo;
	private int Cupo;	
	private String Tipo;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getCosto() {
		return Costo;
	}
	public void setCosto(int costo) {
		Costo = costo;
	}
	public double getTiempo() {
		return Tiempo;
	}
	public void setTiempo(double tiempo) {
		Tiempo = tiempo;
	}
	public int getCupo() {
		return Cupo;
	}
	public void setCupo(int cupo) {
		Cupo = cupo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	@Override
	public String toString() {
		return "Atraccion [Nombre=" + Nombre + ", Costo=" + Costo + ", Tiempo=" + Tiempo + ", Cupo=" + Cupo + ", Tipo="
				+ Tipo + "]";
	}
	
	

}
