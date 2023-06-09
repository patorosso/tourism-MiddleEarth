package data.models;

import java.util.ArrayList;
import java.util.List;

import data.models.excepcion.UsuarioExcepcion;

public class Usuario {

	private String nombre;
	private int monedas;
	private double tiempo;
	private String preferencia;
	private List<Oferta> ofertasCompradas;

	public Usuario(String nombre, int monedas, double tiempo, String preferencia) throws UsuarioExcepcion {

		if (nombre == null || nombre == "")
			throw new UsuarioExcepcion("Usuario sin nombre.");
		if (preferencia == null || preferencia == "")
			throw new UsuarioExcepcion("Usuario sin preferencia.");
		if (monedas < 0)
			throw new UsuarioExcepcion("La cantidad de monedas del usuario debe ser positiva.");
		if (tiempo < 0)
			throw new UsuarioExcepcion("El tiempo disponible del usuario debe ser positivo.");

		this.nombre = nombre;
		this.monedas = monedas;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
		this.ofertasCompradas = new ArrayList<Oferta>();
	}

	public void consumirMonedas(int cant) throws UsuarioExcepcion {

		if (cant < 0)
			throw new UsuarioExcepcion("No se puede descontar saldo negativo");

		this.monedas -= cant;
	}

	public void consumirTiempo(double cant) throws UsuarioExcepcion {

		if (cant < 0)
			throw new UsuarioExcepcion("No se puede descontar tiempo negativo");

		this.tiempo -= cant;
	}

	@Override
	public String toString() {
		return "Usuario: \n" + "Nombre: " + this.nombre + "\n" + "Monedas: " + this.monedas + "\n" + "Tiempo: "
				+ this.tiempo + "\n" + "Preferencia: " + this.preferencia + "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public int getMonedas() {
		return monedas;
	}

	public double getTiempo() {
		return tiempo;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public List<Oferta> getOfertasCompradas() {
		return ofertasCompradas;
	}

	public void comprar(Oferta oferta) {
		this.ofertasCompradas.add(oferta);
	}

}
