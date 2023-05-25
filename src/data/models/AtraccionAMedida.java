package data.models;

import java.util.ArrayList;

public class AtraccionAMedida extends Atraccion {

//	private String Nombre;
//	private Double Precio;
//	private int Duracion;
//
//	public String getNombre() {
//		return Nombre;
//	}
//
//	public void setNombre(String nombre) {
//		Nombre = nombre;
//	}
//
//	public Double getPrecio() {
//		return Precio;
//	}
//
//	public void setPrecio(Double precio) {
//		Precio = precio;
//	}
//
//	public int getDuracion() {
//		return Duracion;
//	}
//
//	public void setDuracion(int duracion) {
//		Duracion = duracion;
//	}
//
//	@Override
//	public String toString() {
//		return "AtraccionAMedida [Nombre=" + Nombre + ", Precio=" + Precio + ", Duracion=" + Duracion + "]";
//	}

	public void ofreceAtraccion(ArrayList<Visitante> visitantes, ArrayList<Atraccion> atracciones, String nombre) {

		for (Visitante visitante : visitantes) {
			if(nombre.equals(visitante.getNombre()) ) {
				for (Atraccion atraccion : atracciones) {
					if(visitante.getTipo().equals(atraccion.getTipo()) ) {
						System.out.println(atraccion);
					}
				}
			}						
		}
	}

//	public AtraccionAMedida() {
//
//	}

}
