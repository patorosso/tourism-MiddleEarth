package data.models;

import java.util.*;

import data.models.excepcion.AtraccionExcepcion;

import java.io.*;

public class Archivo {

	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public void leerArchivo() {
		Scanner scanner = null;

		try {

			File file = new File("resources/in/" + this.nombre + ".in");
			scanner = new Scanner(file);

			if (this.nombre.equals("Usuarios")) {
				this.parsearUsuario(scanner);
			} else if (this.nombre.equals("Atracciones")) {
				this.parsearAtraccion(scanner);
			} else if (this.nombre.equals("Promociones")) {
				this.parsearPromocion(scanner);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			scanner.close();
		}
	}

	private void parsearUsuario(Scanner scanner) {
		System.out.println("USUARIO");
	}

	private List<Atraccion> parsearAtraccion(Scanner scanner) {
		
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		
		while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split("\t");

            String nombreAtraccion = values[0];
            int precioFinal = Integer.parseInt(values[1]);
            double duracion = Double.parseDouble(values[2]);
            int cupos = Integer.parseInt(values[3]);
            String tipo = values[4];
            
            try {
            	Atraccion atraccion = new Atraccion(nombreAtraccion, precioFinal, 
            										duracion, cupos, tipo);
            	
            	atracciones.add(atraccion);
            	
            } catch (AtraccionExcepcion e) {
            	System.out.println("Error");
            }
            
        }
		
		return atracciones;
	}

	private void parsearPromocion(Scanner scanner) {
		System.out.println("PROMOCION");
	}
}
