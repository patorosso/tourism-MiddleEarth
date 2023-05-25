package paqueteTP;

public class Promocion {

	private String Nombre;
	private String Incluye;
	private int Beneficio;
	private int valor;
	private String Gratis;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getIncluye() {
		return Incluye;
	}
	public void setIncluye(String incluye) {
		Incluye = incluye;
	}
	public int getBeneficio() {
		return Beneficio;
	}
	public void setBeneficio(int beneficio) {
		Beneficio = beneficio;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getGratis() {
		return Gratis;
	}
	public void setGratis(String gratis) {
		Gratis = gratis;
	}
	@Override
	public String toString() {
		return "Promocion [Nombre=" + Nombre + ", Incluye=" + Incluye + ", Beneficio=" + Beneficio + ", valor=" + valor
				+ ", Gratis=" + Gratis + "]";
	}
	
	
	
	
}
