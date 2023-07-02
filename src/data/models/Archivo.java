package data.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.models.excepcion.AtraccionExcepcion;
import data.models.excepcion.UsuarioExcepcion;

public class Archivo {

	public static List<Usuario> leerArchivoUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		Scanner scanner = null;

		try {
			File file = new File("resources/in/Usuarios.in");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Usuario usuario = Archivo.parsearUsuario(linea);
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

	public static List<Atraccion> leerArchivoAtracciones() {
		List<Atraccion> atracciones = new ArrayList<>();
		Scanner scanner = null;

		try {
			File file = new File("resources/in/Atracciones.in");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Atraccion atraccion = Archivo.parsearAtraccion(linea);
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

	public static List<Promocion> leerArchivoPromociones(List<Atraccion> atracciones) {
		List<Promocion> promociones = new ArrayList<>();
		Scanner scanner = null;

		try {
			File file = new File("resources/in/Promociones.in");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Promocion promocion = Archivo.parsearPromocion(linea, atracciones);
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

	private static Usuario parsearUsuario(String linea) {

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

	private static Atraccion parsearAtraccion(String linea) {

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

	private static Promocion parsearPromocion(String linea, List<Atraccion> atracciones) {

		String[] atributos = linea.split("!");

		String tipoPromocion = atributos[0];

		List<Oferta> ofertas = new ArrayList<Oferta>();

		int indice = 1;
		while (!atributos[indice].equals("|")) {
			Atraccion atraccion = null;
			for (Atraccion atr : atracciones) {
				if(atr.getNombre().equals(atributos[indice]))
					atraccion = atr;
			}
			ofertas.add(atraccion);
			indice++;
		}

		indice++;

		Promocion promocion = null;

		switch (tipoPromocion) {
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

	public static void guardarItinerario(Usuario usuario) {

		FileWriter archivo = null;
		PrintWriter printerWriter = null;

		try {
			archivo = new FileWriter("resources/out/" + usuario.getNombre() + ".out");
			printerWriter = new PrintWriter(archivo);

			printerWriter.println(usuario);

			String nombre = "";
			int precio = 0;
			double duracion = 0;

			for (Oferta oferta : usuario.getOfertasCompradas()) {

				nombre += oferta + "\n";
				precio += oferta.getPrecioConDescuento();
				duracion += oferta.getDuracion();

			}

			printerWriter.println("Ofertas compradas: \n" + nombre);
			printerWriter.println("--------------------\n");
			printerWriter.println("TOTAL:\n");
			printerWriter.println("Precio total: " + precio);
			printerWriter.println("Duracion total: " + duracion);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
