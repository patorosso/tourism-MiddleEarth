package data.models;

import excepciones.UsuarioExcepcion;

public class Usuario {
	
	private String nombre;
	private int monedas;
	private float tiempo;
	private String preferencia;
	
	public Usuario(String nombre, int monedas, float tiempo, String preferencia) throws UsuarioExcepcion {
		
		//Tal vez sea necesario un throw para cada parametro
		if((nombre == null || nombre == "") || (preferencia == null || preferencia == null))
			throw new UsuarioExcepcion("Sin nombre o preferencia");
		
		if(monedas < 0 || tiempo < 0)
			throw new UsuarioExcepcion("Monedas o tiempo negativo");
		
		this.nombre = nombre;	
		this.monedas = monedas;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
	}

	public String getNombre() {
		return nombre;
	}

	public int getMonedas() {
		return monedas;
	}

	public float getTiempo() {
		return tiempo;
	}

	public String getPreferencia() {
		return preferencia;
	}
	
	public void consumirMonedas(int cant) throws UsuarioExcepcion {
		
		if(cant < 0)
			throw new UsuarioExcepcion("No se puede descontar saldo negativo");
		
		this.monedas -= cant;
	}
	
	public void consumirTiempo(float cant) throws UsuarioExcepcion {
		
		if(cant < 0)
			throw new UsuarioExcepcion("No se puede descontar tiempo negativo");
		
		this.tiempo -= cant;
	}


}
