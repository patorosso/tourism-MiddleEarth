package data.models;

import data.models.excepcion.*;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private int monedas;
	private double tiempo;
	private String preferencia;
	private List<Oferta> ofertasCompradas;

	public Usuario(String nombre, int monedas, double tiempo, String preferencia) throws UsuarioExcepcion {

		// Tal vez sea necesario un throw para cada parametro, para especificar cada
		// mensaje.
		if ((nombre == null || nombre == "") || (preferencia == null || preferencia == null))
			throw new UsuarioExcepcion("Sin nombre o preferencia");

		if (monedas < 0 || tiempo < 0)
			throw new UsuarioExcepcion("Monedas o tiempo negativo");

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
	
	public void agregarCompra(Oferta oferta) {
		ofertasCompradas.add(oferta);
	}

//	@Override
//	public void comprarOferta(Oferta oferta) {
//
//	}

}
