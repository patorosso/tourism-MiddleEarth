package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import data.models.Atraccion;
import data.models.Resolucion;
import data.models.Visitante;

public class Main {

	public static void main(String[] args) {
		
		Resolucion resolucion = new Resolucion();
		resolucion.resolverVisitante("disponibilidad_usuario");
		
//		ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
//
//		String path1 = "C:\\Users\\Administrator\\Desktop\\Facu 2023\\Paradigmas de programacion\\Desarrollos\\TP\\src\\archivos de entrada\\disponibilidad_usuario.in";
//
//		File filevisitantes = new File(path1);
//
//		try {
//			Scanner scvisita = new Scanner(filevisitantes);
//
//			while (scvisita.hasNextLine()) {
//
//				String linea = scvisita.nextLine();
//				StringTokenizer atributo = new StringTokenizer(linea, "\t");
//
//				Visitante visitante = new Visitante();
//
//				while (atributo.hasMoreElements()) {
//
//					visitante.setNombre(atributo.nextElement().toString());
//					visitante.setTipo(atributo.nextElement().toString());
//					visitante.setSaldo(Double.parseDouble(atributo.nextElement().toString()));
//					visitante.setTiempo(Integer.parseInt(atributo.nextElement().toString()));
//
//				}
//
//				visitantes.add(visitante);
//
//			}
//
//			scvisita.close();
//
////			visitantes.forEach(c -> System.out.println(c));
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
//		
//		
////		Atracciones
//		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
//		
//		String path2 = "C:\\Users\\Administrator\\Desktop\\Facu 2023\\Paradigmas de programacion\\Desarrollos\\TP\\src\\archivos de entrada\\atracciones.in";
//		File fileatracciones = new File(path2);
//		
//		File file = new File(path2);
//
//		try {
//			Scanner sc = new Scanner(file);
//
//			while (sc.hasNextLine()) {
//
//				String linea = sc.nextLine();
//				StringTokenizer atributo = new StringTokenizer(linea, "\t");
//
//				Atraccion atraccion = new Atraccion();
//
//				while (atributo.hasMoreElements()) {
//
//					atraccion.setNombre(atributo.nextElement().toString());
//					atraccion.setCosto(Integer.parseInt(atributo.nextElement().toString()));
//					atraccion.setTiempo(Double.parseDouble(atributo.nextElement().toString()));
//					atraccion.setCupo(Integer.parseInt(atributo.nextElement().toString()));
//					atraccion.setTipo(atributo.nextElement().toString());
//
//				}
//
//				atracciones.add(atraccion);
//
//			}
//
//			sc.close();
//
////			atracciones.forEach(c -> System.out.println(c));
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
//		
//		
////		Ofrece atracciones a paritr del visitante ingresado por teclado:		
//		
//		Scanner entrada = new Scanner(System.in);
//		System.out.println("Nombre del visitante: ");
//		String nombre = entrada.nextLine();
//		
////		AtraccionAMedida ofrece = new AtraccionAMedida();
////		
////		ofrece.ofreceAtraccion(visitantes, atracciones, nombre);
//		
//		for (Visitante visitante : visitantes) {
//			if(nombre.equals(visitante.getNombre()) ) {
//				for (Atraccion atraccion : atracciones) {
//					if(visitante.getTipo().equals(atraccion.getTipo()) ) {
//						System.out.println(atraccion);
//					}
//				}
//			}						
//		}

	}

}
