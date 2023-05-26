package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Atraccion extends Oferta {

	private int cupos;
	private final String tipoAtraccion;
	
	private static final List<String> LISTA_TIPO_ATRACCION = new ArrayList<String>(
			Arrays.asList("Aventura", "Degustacion", "Paisaje"));

	public Atraccion(String nombre, int costo, float duracion, int cupos, String tipoAtraccion)
			throws AtraccionExcepcion {

		super(nombre, costo, duracion);

		if (cupos < 0)
			throw new AtraccionExcepcion("Cupos negativo");
		
		if(!LISTA_TIPO_ATRACCION.contains(tipoAtraccion)) {
			throw new AtraccionExcepcion("La atraccion no es valida.");
		}

		this.cupos = cupos;
		this.tipoAtraccion = tipoAtraccion;

	}

	public static boolean validarAtraccion(String tipoAtraccion) {
		return LISTA_TIPO_ATRACCION.contains(tipoAtraccion);

	}

//	public String getNombre() {
//		return nombre;
//	}
	
	
}
