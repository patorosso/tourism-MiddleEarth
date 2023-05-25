package archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

import paqueteTP.Visitante;
import paqueteTP.Atraccion;
import paqueteTP.Promocion;

import java.util.Random;

public class Archivo {
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

//	public double[] leerArchivo() {
	public void leerArchivoYListarVisitante(ArrayList<Visitante> visitantes) {

		try {
			File filevisitantes = new File(
					"C:\\\\Users\\\\Administrator\\\\Desktop\\\\Facu 2023\\\\Paradigmas de programacion\\\\Desarrollos\\\\TP\\\\src\\\\archivos de entrada\\\\"
							+ this.nombre + ".in");
			Scanner scvisita = new Scanner(filevisitantes);

			while (scvisita.hasNextLine()) {

				String linea = scvisita.nextLine();
				StringTokenizer atributo = new StringTokenizer(linea, "\t");

				Visitante visitante = new Visitante();

				while (atributo.hasMoreElements()) {
					visitante.setNombre(atributo.nextElement().toString());
					visitante.setTipo(atributo.nextElement().toString());
					visitante.setSaldo(Double.parseDouble(atributo.nextElement().toString()));
					visitante.setTiempo(Integer.parseInt(atributo.nextElement().toString()));

				}
				visitantes.add(visitante);
			}

			scvisita.close();

//			visitantes.forEach(c -> System.out.println(c));

		} catch (Exception e) {
			e.printStackTrace();
		}
//		return visitantes;
	}

	public void leerArchivoYListarAtraccion(ArrayList<Atraccion> atracciones) {

		try {
			File fileatracciones = new File(
					"C:\\\\Users\\\\Administrator\\\\Desktop\\\\Facu 2023\\\\Paradigmas de programacion\\\\Desarrollos\\\\TP\\\\src\\\\archivos de entrada\\\\"
							+ this.nombre + ".in");
			Scanner scatraccion = new Scanner(fileatracciones);

			while (scatraccion.hasNextLine()) {

				String linea = scatraccion.nextLine();
				StringTokenizer atributo = new StringTokenizer(linea, "\t");

//				Visitante visitante = new Visitante();
				Atraccion atraccion = new Atraccion();

				while (atributo.hasMoreElements()) {

					atraccion.setNombre(atributo.nextElement().toString());
					atraccion.setCosto(Integer.parseInt(atributo.nextElement().toString()));
					atraccion.setTiempo(Double.parseDouble(atributo.nextElement().toString()));
					atraccion.setCupo(Integer.parseInt(atributo.nextElement().toString()));
					atraccion.setTipo(atributo.nextElement().toString());
				}
				atracciones.add(atraccion);
			}

			scatraccion.close();

//			visitantes.forEach(c -> System.out.println(c));

		} catch (Exception e) {
			e.printStackTrace();
		}
//		return visitantes;
	}

	public void leerArchivoYListarPromocion(ArrayList<Promocion> promociones) {

		try {
			File filepromociones = new File(
					"C:\\\\Users\\\\Administrator\\\\Desktop\\\\Facu 2023\\\\Paradigmas de programacion\\\\Desarrollos\\\\TP\\\\src\\\\archivos de entrada\\\\"
							+ this.nombre + ".in");
			Scanner scpromocion = new Scanner(filepromociones);

			while (scpromocion.hasNextLine()) {

				String linea = scpromocion.nextLine();
				StringTokenizer atributo = new StringTokenizer(linea, "\t");

//				Visitante visitante = new Visitante();
				Promocion promocion = new Promocion();

				while (atributo.hasMoreElements()) {
					promocion.setNombre(atributo.nextElement().toString());
					promocion.setIncluye(atributo.nextElement().toString());
					promocion.setBeneficio(Integer.parseInt(atributo.nextElement().toString()));
					promocion.setValor(Integer.parseInt(atributo.nextElement().toString()));
					promocion.setGratis(atributo.nextElement().toString());
				}

				promociones.add(promocion);

			}

			scpromocion.close();

//			visitantes.forEach(c -> System.out.println(c));

		} catch (Exception e) {
			e.printStackTrace();
		}
//		return visitantes;
	}

}
