package main;

import clases.*;
import excepciones.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			Usuario u1 = new Usuario("Frodo", 15, 5, "Aventura");
		}
		catch(UsuarioExcepcion e) {
			System.out.println("[Excepcion capturada] " + e.getMessage());
		}

	}

}
