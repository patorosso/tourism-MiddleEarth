package testPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import data.models.Usuario;
import data.models.Atraccion;
import data.models.Oferta;
import data.models.excepcion.AtraccionExcepcion;
import data.models.excepcion.UsuarioExcepcion;

class UsuarioTest {

	Usuario user;

	@Test
	void creaUsuarioCorrectamente() {
		try {
			this.user = new Usuario("test", 10, 10, "preferencia Test");
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	void usuarioRotoTest() {
		String mensajeError = "";
		try {
			this.user = new Usuario("test", 10, 10, "preferencia Test");
		} catch (UsuarioExcepcion e) {
			assertTrue(mensajeError.contains(e.getMessage()));
		}
	}

	@Test
	void consumeCorrectamente() {
		creaUsuarioCorrectamente();
		try {
			this.user.consumirTiempo(5);
			this.user.consumirMonedas(5);
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
		}
		Assert.assertEquals(5, this.user.getMonedas());
		Assert.assertEquals(5.0, user.getTiempo(), 0);
	}

	@Test
	void compraCorrectamente() {
		Atraccion oferta;
		try {
			oferta = new Atraccion("atraccion", 5, 5, "tipo 1", 3);
			List<Oferta> ofertas = new ArrayList<Oferta>();
			ofertas.add(oferta);
			creaUsuarioCorrectamente();
			this.user.comprar(oferta);
			Assert.assertTrue(ofertas.equals(ofertas));
		} catch (AtraccionExcepcion e) {
			e.printStackTrace();
		}

	}
}