package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Atraccion extends Oferta {

	private int cupos;

	//pasar a ofertas
	private static final List<String> LISTA_TIPOS = new ArrayList<String>(
			Arrays.asList("Aventura", "Degustacion", "Paisaje"));

	public Atraccion(String nombre, int precio, float duracion, int cupos, String tipo) throws AtraccionExcepcion {

		super(nombre, precio, duracion, tipo);

		if (cupos < 0)
			throw new AtraccionExcepcion("Cupos negativo");

		if (!LISTA_TIPOS.contains(tipo)) {
			throw new AtraccionExcepcion("La atraccion no es valida.");
		}

		this.cupos = cupos;

	}

	public static boolean validarAtraccion(String tipo) {
		return LISTA_TIPOS.contains(tipo);

	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) throws AtraccionExcepcion {
		if (!LISTA_TIPOS.contains(tipo))
			throw new AtraccionExcepcion("La atraccion no es valida.");

		this.tipo = tipo;
	}

}
