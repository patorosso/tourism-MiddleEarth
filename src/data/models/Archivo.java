package data.models;

import data.models.excepcion.AtraccionExcepcion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Random;

public class Archivo {
	private String nombre; // esto es necesario?

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public void generaObjectUsuario(Usuario usuario, String[] strArray) {

		int pos = 0;
		for (int i = 0; i < strArray.length; i++) {

			if (usuario.getNombre() == null && pos == i) {
				usuario.setNombre(strArray[i]);
				pos++;
			}

			if (usuario.getPreferencia() == null && pos == i) {
				usuario.setPreferencia(strArray[i]);
				pos++;
			}

			if (usuario.getMonedas() == 0 && pos == i) {
				usuario.setMonedas(Integer.parseInt(strArray[i].toString()));
				pos++;
			}

			if (usuario.getTiempo() == 0 && pos == i) {
				usuario.setTiempo(Integer.parseInt(strArray[i].toString()));
				pos++;
			}

		}
	}

	public void generaObjectAtraccion(Atraccion atraccion, String[] strArray) {

		int pos = 0;

		try {
			for (int i = 0; i < strArray.length; i++) {

				if (atraccion.getNombre() == null && pos == i) {
					atraccion.setNombre(strArray[i]);
					pos++;
				}

				if (atraccion.getPrecio() == 0 && pos == i) {
					atraccion.setPrecio(Integer.parseInt(strArray[i].toString()));
					pos++;
				}

				if (atraccion.getDuracion() == 0 && pos == i) {
					atraccion.setDuracion(Double.parseDouble(strArray[i].toString()));
					pos++;
				}

				if (atraccion.getCupos() == 0 && pos == i) {
					atraccion.setCupos(Integer.parseInt(strArray[i].toString()));
					pos++;
				}

				if (atraccion.getTipo() == null && pos == i) {
					atraccion.setTipo(strArray[i]);
					pos++;
				}

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (AtraccionExcepcion e) {
			e.printStackTrace();
		}
	}

	// Para cuando este la clase Promocion

//	public void generaObjectPromocion(Promocion promocion, String[] strArray) {
//
//		int pos = 0;
//		for (int i = 0; i < strArray.length; i++) {
//			 
//			if(promocion.getNombre() == null && pos == i) {
//			    promocion.setNombre(strArray[i]);
//				pos ++;
//			}
//			
//			if(promocion.getIncluye() == null && pos == i) {
//			    promocion.setIncluye(strArray[i]);
//				pos ++;
//			}
//			
//			if(promocion.getBeneficio() == 0 && pos == i) {
//			    promocion.setBeneficio(Integer.parseInt(strArray[i].toString()));
//				pos ++;
//			}
//			
//			if(promocion.getValor() == 0 && pos == i) {
//			    promocion.setValor(Integer.parseInt(strArray[i].toString()));
//				pos ++;
//			}
//			
//			if(promocion.getGratis() == null && pos == i) {
//			    promocion.setGratis(strArray[i]);
//				pos ++;
//			}
//			
//		}
//	}

	public void parseStringUsuario(String linea, Usuario usuario) {
		String[] strArray = null;
		strArray = linea.split("	");

		generaObjectUsuario(usuario, strArray);
	}

	public void parseStringAtraccion(String linea, Atraccion atraccion) {
		String[] strArray = null;
		strArray = linea.split("	");

		generaObjectAtraccion(atraccion, strArray);
	}

//	public void parseStringPromocion(String linea, Promocion promocion) {
//		String[] strArray = null;
//		strArray = linea.split("	");
//
//		generaObjectPromocion(strArray, promocion);
//	}

//	public void leerArchivoYListarUsuario(ArrayList<Usuario> usuarios) {
//
//		try {
//			File fileUsuarios = new File(
//					"C:\\\\Users\\\\Administrator\\\\Desktop\\\\Facu 2023\\\\Paradigmas de programacion\\\\Desarrollos\\\\TP\\\\src\\\\archivos de entrada\\\\"
//							+ this.nombre + ".in");
//			Scanner scvisita = new Scanner(fileUsuarios);
//
//			while (scvisita.hasNextLine()) {
//
//				String linea = scvisita.nextLine();		
//				
////				StringTokenizer atributo = new StringTokenizer(linea, "\t");
//
//				Usuario Usuario = new Usuario();
//				parseStringUsuario(linea, Usuario);
//	
////				while (atributo.hasMoreElements()) {
////					Usuario.setNombre(atributo.nextElement().toString());
////					Usuario.setTipo(atributo.nextElement().toString());
////					Usuario.setSaldo(Double.parseDouble(atributo.nextElement().toString()));
////					Usuario.setTiempo(Integer.parseInt(atributo.nextElement().toString()));
//
////				}
//				usuarios.add(Usuario);
//			}
//
//			scvisita.close();
//
////			Usuarios.forEach(c -> System.out.println(c));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		return Usuarios; 
//	}

//	public void leerArchivoYListarAtraccion(ArrayList<Atraccion> atracciones) {
//
//		try {
//			File fileatracciones = new File(
//					"C:\\\\Users\\\\Administrator\\\\Desktop\\\\Facu 2023\\\\Paradigmas de programacion\\\\Desarrollos\\\\TP\\\\src\\\\archivos de entrada\\\\"
//							+ this.nombre + ".in");
//			Scanner scatraccion = new Scanner(fileatracciones);
//
//			while (scatraccion.hasNextLine()) {
//
//				String linea = scatraccion.nextLine();
////				StringTokenizer atributo = new StringTokenizer(linea, "\t");
//
////				Usuario Usuario = new Usuario();
//				Atraccion atraccion = new Atraccion();
//				parseStringAtraccion(linea, atraccion);
//
////				while (atributo.hasMoreElements()) {
////
////					atraccion.setNombre(atributo.nextElement().toString());
////					atraccion.setCosto(Integer.parseInt(atributo.nextElement().toString()));
////					atraccion.setTiempo(Double.parseDouble(atributo.nextElement().toString()));
////					atraccion.setCupo(Integer.parseInt(atributo.nextElement().toString()));
////					atraccion.setTipo(atributo.nextElement().toString());
////				}
//				atracciones.add(atraccion);
//			}
//
//			scatraccion.close();
//
////			Usuarios.forEach(c -> System.out.println(c));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		return Usuarios;
//	}

//	public void leerArchivoYListarPromocion(ArrayList<Promocion> promociones) {
//
//		try {
//			File filepromociones = new File(
//					"C:\\\\Users\\\\Administrator\\\\Desktop\\\\Facu 2023\\\\Paradigmas de programacion\\\\Desarrollos\\\\TP\\\\src\\\\archivos de entrada\\\\"
//							+ this.nombre + ".in");
//			Scanner scpromocion = new Scanner(filepromociones);
//
//			while (scpromocion.hasNextLine()) {
//
//				String linea = scpromocion.nextLine();
//				StringTokenizer atributo = new StringTokenizer(linea, "\t");
//
////				Usuario Usuario = new Usuario();
//				Promocion promocion = new Promocion();
//				parseStringPromocion(linea, promocion);
//
////				while (atributo.hasMoreElements()) {
////					promocion.setNombre(atributo.nextElement().toString());
////					promocion.setIncluye(atributo.nextElement().toString());
////					promocion.setBeneficio(Integer.parseInt(atributo.nextElement().toString()));
////					promocion.setValor(Integer.parseInt(atributo.nextElement().toString()));
////					promocion.setGratis(atributo.nextElement().toString());
////				}
//
//				promociones.add(promocion);
//
//			}
//
//			scpromocion.close();
//
////			Usuarios.forEach(c -> System.out.println(c));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		return Usuarios;
//	}

//	public void guardarArchivo(double[] datos) {
//		FileWriter file = null;
//		PrintWriter printerWriter = null;
//
//		try {
//			file = new FileWriter("casos de prueba/out/" + this.nombre + ".out");
//			printerWriter = new PrintWriter(file);
//
//			for (int i = 0; i < datos.length; i++) {
//				// Imprime los datos y hace un salto de linea
//				printerWriter.println(datos[i]);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (file != null) {
//				try {
//					file.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

}
