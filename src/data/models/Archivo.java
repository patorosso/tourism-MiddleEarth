package data.models;

import java.util.*;

import data.models.excepcion.AtraccionExcepcion;
import data.models.excepcion.UsuarioExcepcion;

import java.io.*;

public class Archivo {

	public Archivo() {

	}

	public List<Usuario> leerArchivoUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		Scanner scanner = null;

		try {
			File file = new File("resources/in/Usuarios.in");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Usuario usuario = this.parsearUsuario(linea);
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return usuarios;
	}

	public List<Atraccion> leerArchivoAtracciones() {
		List<Atraccion> atracciones = new ArrayList<>();
		Scanner scanner = null;

		try {
			File file = new File("resources/in/Atracciones.in");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Atraccion atraccion = this.parsearAtraccion(linea);
				atracciones.add(atraccion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return atracciones;
	}

	public List<Promocion> leerArchivoPromociones() {
		List<Promocion> promociones = new ArrayList<>();
		Scanner scanner = null;

		try {
			File file = new File("resources/in/Promociones.in");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Promocion promocion = this.parsearPromocion(linea);
				promociones.add(promocion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return promociones;
	}

	private Usuario parsearUsuario(String linea) {

		String[] atributos = linea.split("\t");

		String nombre = atributos[0];
		String preferencia = atributos[1];
		int monedas = Integer.parseInt(atributos[2]);
		double tiempo = Double.parseDouble(atributos[3]);

		Usuario usuario = null;
		try {
			usuario = new Usuario(nombre, monedas, tiempo, preferencia);
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
		}
		return usuario;

	}

	private Atraccion parsearAtraccion(String linea) {

		String[] atributos = linea.split("\t");

		String nombre = atributos[0];
		int precio = Integer.parseInt(atributos[1]);
		double duracion = Double.parseDouble(atributos[2]);
		int cupos = Integer.parseInt(atributos[3]);
		String tipo = atributos[4];

		Atraccion atraccion = null;
		try {
			atraccion = new Atraccion(nombre, precio, duracion, tipo, cupos);
		} catch (AtraccionExcepcion e) {
			e.printStackTrace();
		}
		return atraccion;

	}

	private Promocion parsearPromocion(String linea) {

		String[] atributos = linea.split("!");

		String tipoPromocion = atributos[0];

		List<Oferta> ofertas = new ArrayList<Oferta>();

		int indice = 1;
		while (!atributos[indice].equals("|")) {
			Atraccion atraccion = this.parsearAtraccion(atributos[indice]);
			ofertas.add(atraccion);
			indice++;
		}
		
		indice ++;

	Promocion promocion = null;

	switch(tipoPromocion)
	{
		case "%":
			double porcentaje = Double.parseDouble(atributos[indice]);
			promocion = new PromocionPorcentual(ofertas, porcentaje);
			break;
		case "$":
			int monto = Integer.parseInt(atributos[indice]);
			promocion = new PromocionAbsoluta(ofertas, monto);
			break;
		case "&":
			promocion = new PromocionAxB(ofertas);
			break;

		}

	return promocion;

}

}
