package data.models;

import java.util.ArrayList;
import java.util.Scanner;

public class AplicacionMovil {

	public void proceso(ArrayList<Visitante> visitantes, ArrayList<Promocion> promociones,
			ArrayList<Atraccion> atracciones) {

//		String nombre = solicitaUsuario();
		String exit = "N";

		for (Visitante visitante : visitantes) {

			System.out.println("Nombre del visitante: " + visitante.getNombre() + "\n");

			for (Promocion promocion : promociones) {
				if (visitante.getTipo().equals(promocion.getNombre())) {
//					System.out.println(promocion + "\n");
					System.out.println("Promocion");
					System.out.println("-Atracciones incluidas: " +"["+ promocion.getIncluye() +"]");
					System.out.println("-Beneficio: " + promocion.getBeneficio());
					System.out.println("-Valor: " + promocion.getValor());
					System.out.println("-Gratis: " + promocion.getGratis() + "\n");

					while (!exit.equals("S")) {

						System.out.println("Acepta sugerencia? Ingrese S o N");

						if (ingresoPorTeclado().equalsIgnoreCase("S") || ingresoPorTeclado().equalsIgnoreCase("N")) {
							exit = "S";
						}

					}

					if (exit.equals("S")) {
						System.out.println("Aceptada");
					}
				}

			}
//		}

			System.out.println("");
			exit = "N";

//		for (Visitante visitante : visitantes) {

			for (Atraccion atraccion : atracciones) {

				if (visitante.getTipo().equals(atraccion.getTipo())) {
//					System.out.println(atraccion);
					System.out.println("Atraccion");
					System.out.println("Nombre: " + "["+atraccion.getNombre()+"]");
					System.out.println("Precio: " + "$"+atraccion.getCosto());
					System.out.println("Duracion: " + atraccion.getTiempo() +" hs" +"\n");
					

					while (!exit.equals("S")) {

						System.out.println("Acepta sugerencia? Ingrese S o N");

						if (ingresoPorTeclado().equalsIgnoreCase("S") || ingresoPorTeclado().equalsIgnoreCase("N")) {
							exit = "S";
						}

					}

					if (exit.equals("S")) {
						System.out.println("Aceptada");
						exit = "N";
					}

				}
			}
//		}
		}
	}

//	public String solicitaUsuario() {
//
//		System.out.println("Nombre del visitante: ");
//		return ingresoPorTeclado();
//	}

	public String ingresoPorTeclado() {

		Scanner entrada = new Scanner(System.in);
		String respuesta = entrada.nextLine();

		return respuesta;
	}

}
