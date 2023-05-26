package data.models;

import java.util.*;
import data.models.excepcion.*;

public class Atraccion extends Oferta {

	private int cupos;
	private final String tipoAtraccion;
	
	private final List<String> listaTipoAtraccion = new ArrayList<String>(Arrays.asList("Aventura", "Degustacion", "Paisaje"));
	
	public Atraccion(String nombre, int costo, float duracion, int cupos, String tipoAtraccion) throws AtraccionExcepcion {
			
		super(nombre, costo, duracion);
		
		if(cupos < 0)
			throw new AtraccionExcepcion("Cupos negativo");
		
		//Tal vez hay que chequear si es nulo
		if(!listaTipoAtraccion.contains(tipoAtraccion))
			throw new AtraccionExcepcion("Tipo de atraccion nula");
				
		this.cupos = cupos;
		this.tipoAtraccion = tipoAtraccion;
		
	}

//	public String getNombre() {
//		return nombre;
//	}
	
	
}
