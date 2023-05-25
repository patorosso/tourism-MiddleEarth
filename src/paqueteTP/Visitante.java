package paqueteTP;

public class Visitante {
	
	private String Nombre;	
	private String Tipo;	
	private Double Saldo; 	
	private int Tiempo;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public Double getSaldo() {
		return Saldo;
	}
	public void setSaldo(Double saldo) {
		Saldo = saldo;
	}
	public int getTiempo() {
		return Tiempo;
	}
	public void setTiempo(int tiempo) {
		Tiempo = tiempo;
	}
	@Override
	public String toString() {
		return "Visitante [Nombre=" + Nombre + ", Tipo=" + Tipo + ", Saldo=" + Saldo + ", Tiempo=" + Tiempo + "]";
	}
//	public Visitante(String nombre, String tipo, Double saldo, int tiempo) {
//		super();
//		Nombre = nombre;
//		Tipo = tipo;
//		Saldo = saldo;
//		Tiempo = tiempo;
//	}
	
	
	


}
