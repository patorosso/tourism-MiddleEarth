package testPackage;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import data.models.Atraccion;
import data.models.Oferta;
import data.models.Ofertador;
import data.models.Promocion;
import data.models.PromocionAbsoluta;
import data.models.PromocionAxB;
import data.models.PromocionPorcentual;
import data.models.Usuario;
import data.models.excepcion.AtraccionExcepcion;
import data.models.excepcion.OfertadorExcepcion;
import data.models.excepcion.UsuarioExcepcion;


class OfertadorTest {
	
	Ofertador ofertador;
	Usuario usuario;
	List<Oferta> ofertas;
	
	@Before
	public void setup() {
		try {
			Oferta oferta1 = new Atraccion("atraccion1", 5, 5, "preferencia1", 1);
			Oferta oferta2 = new Atraccion("atraccion2", 4, 4, "preferencia2", 1);
			ofertas = new ArrayList<Oferta>();
			ofertas.add(oferta1);
			ofertas.add(oferta2);
			this.usuario = new Usuario("test", 10, 10, "preferencia2");
		} catch (AtraccionExcepcion e) {
			fail("no deberia arrojar exception");
		} catch (UsuarioExcepcion e) {
			fail("no deberia arrojar exception");
		}
	}

	@Test
	void creaOfertadorCorrectamente() {
		setup();
		try {
			this.ofertador = new Ofertador(this.ofertas, this.usuario);
		} catch (OfertadorExcepcion e) {
			fail("no deberia arrojar exception");
		}
	}

	@Test
	void comprobarOrdenTest() {
		try {
			creaOfertadorCorrectamente();
			
			List<Oferta> ofertasEsperadas = new ArrayList<>();
			ofertasEsperadas.add(new Atraccion("atraccion2", 5, 5, "tipo 1", 1)); // Esta deberia ser la primera atraccion en aparecer
			ofertasEsperadas.add(new Atraccion("atraccion1", 4, 4, "tipo 2", 1));
			
			List<Oferta> ofertasObtenidas = new ArrayList<>();
			
			while (ofertador.tieneSiguienteOferta()) {
				Oferta oferta = ofertador.siguienteOferta();
				ofertasObtenidas.add(oferta);
			}
			
			assertEquals(ofertasEsperadas, ofertasObtenidas);
		} catch (Exception e) {
			fail("no deberia arrojar exception");
		}
	}
	
	@Test
	void comprobarOrdenCompleto() throws AtraccionExcepcion, UsuarioExcepcion, OfertadorExcepcion {

		Atraccion atraccion1 = new Atraccion("Moria", 4, 4, "Aventura", 1);
		Atraccion atraccion2 = new Atraccion("Mordor", 5, 5, "Aventura", 1);
		Atraccion atraccion3 = new Atraccion("Minas Tirith", 6, 6, "Paisaje", 1);
		Atraccion atraccion4 = new Atraccion("Abismo de Helm ", 7, 7, "Paisaje", 1);
		Atraccion atraccion5 = new Atraccion("La Comarca", 8, 8, "Degustación", 1);
		Atraccion atraccion6 = new Atraccion("Lothlorien", 9, 9, "Degustación", 1);
		Atraccion atraccion7 = new Atraccion("Bosque Negro", 10, 10, "Aventura", 1);
		Atraccion atraccion8 = new Atraccion("Rivendel", 11, 11, "Aventura", 1);

		List<Oferta> ofertaPreferencial1 = new ArrayList<Oferta>();
		List<Oferta> ofertaPreferencial2 = new ArrayList<Oferta>();
		List<Oferta> ofertaAxB = new ArrayList<Oferta>();
		List<Oferta> ofertaPorcentual = new ArrayList<Oferta>();
		
		ofertaPreferencial1.add(atraccion1);
		ofertaPreferencial1.add(atraccion2);
		ofertaPreferencial2.add(atraccion7);
		ofertaPreferencial2.add(atraccion8);
		ofertaAxB.add(atraccion3);
		ofertaAxB.add(atraccion4);
		ofertaPorcentual.add(atraccion5);
		ofertaPorcentual.add(atraccion6);
		
		Promocion promoPreferencial1 = new PromocionAbsoluta(ofertaPreferencial1, 1);
		Promocion promoPreferencial2 = new PromocionAbsoluta(ofertaPreferencial2, 1);
		Promocion promoAxB = new PromocionAxB(ofertaAxB);
		Promocion promoPorcentual = new PromocionPorcentual(ofertaPorcentual, 0.5);	
		
		ofertas = new ArrayList<Oferta>();
		// Insertamos las atracciones en forma desordenada
		this.ofertas.add(atraccion8);
		this.ofertas.add(atraccion7);
		this.ofertas.add(atraccion5);
		this.ofertas.add(atraccion1);
		this.ofertas.add(atraccion2);
		this.ofertas.add(atraccion4);
		this.ofertas.add(atraccion3);
		this.ofertas.add(atraccion6);
		
		// Insertamos las promos en forma desordenada
		this.ofertas.add(promoAxB);
		this.ofertas.add(promoPorcentual);
		this.ofertas.add(promoPreferencial2);
		this.ofertas.add(promoPreferencial1);
		
		this.usuario = new Usuario("Frodo", 1000, 1000, "Aventura");

		
		List<Oferta> ofertasEsperadas = new ArrayList<>();
		
		// Primero deberia ofertar las promos de aventura
		ofertasEsperadas.add(promoPreferencial2);
		ofertasEsperadas.add(promoPreferencial1);

		// Luego atracciones de aventura
		ofertasEsperadas.add(atraccion8);
		ofertasEsperadas.add(atraccion7);
		ofertasEsperadas.add(atraccion2);
		ofertasEsperadas.add(atraccion1);
		
		// Luego promociones en orden de precio descendiente
		ofertasEsperadas.add(promoPorcentual);
		ofertasEsperadas.add(promoAxB);
		
		// Luego atracciones en orden de precio descendiente
		ofertasEsperadas.add(atraccion6);
		ofertasEsperadas.add(atraccion5);
		ofertasEsperadas.add(atraccion4);
		ofertasEsperadas.add(atraccion3);
		
		this.ofertador = new Ofertador(this.ofertas, this.usuario);
		
		List<Oferta> ofertasObtenidas = new ArrayList<>();
		while (this.ofertador.tieneSiguienteOferta()) {
			Oferta oferta = ofertador.siguienteOferta();
			ofertasObtenidas.add(oferta);
		}
		
		assertEquals(ofertasEsperadas, ofertasObtenidas);
	}
	
	@Test
	void noOfertaAtraccionComprada() throws AtraccionExcepcion, UsuarioExcepcion, OfertadorExcepcion {
		this.usuario = new Usuario("Frodo", 1000, 1000, "Paisaje");
		List<Oferta> ofertaAxB = new ArrayList<Oferta>();
		Atraccion atraccion1 = new Atraccion("Minas Tirith", 6, 6, "Paisaje", 2);
		Atraccion atraccion2 = new Atraccion("Abismo de Helm", 7, 7, "Paisaje", 1);
		Atraccion atraccion3 = new Atraccion("Rivendel", 11, 11, "Aventura", 1);
		
		ofertaAxB.add(atraccion1);
		ofertaAxB.add(atraccion2);
		Promocion promoAxB = new PromocionAxB(ofertaAxB);
		
		this.ofertas = new ArrayList<Oferta>();
		this.ofertas.add(promoAxB);
		this.ofertas.add(atraccion1);
		this.ofertas.add(atraccion2);
		this.ofertas.add(atraccion3);

		this.ofertador = new Ofertador(this.ofertas, this.usuario);
		List<Oferta> ofertasEsperadas = new ArrayList<>();
		
		// Esperamos la promo y la atraccion que no esta incluida en la oferta
		ofertasEsperadas.add(promoAxB);
		ofertasEsperadas.add(atraccion3);
		
		List<Oferta> ofertasObtenidas = new ArrayList<>();
		while (this.ofertador.tieneSiguienteOferta()) {
			Oferta oferta = ofertador.siguienteOferta();
			ofertasObtenidas.add(oferta);
			this.usuario.comprar(oferta);
		}
		
		assertEquals(ofertasEsperadas, ofertasObtenidas);
	}
	
	@Test
	void noOfertaAtraccionQueNoPuedeComprar() throws AtraccionExcepcion, UsuarioExcepcion, OfertadorExcepcion {
		// moneda tiempo
		this.usuario = new Usuario("Frodo", 10, 10, "Paisaje");
		List<Oferta> ofertaAxB = new ArrayList<Oferta>();
		Atraccion atraccion1 = new Atraccion("Minas Tirith", 8, 1, "Paisaje", 10);
		Atraccion atraccion2 = new Atraccion("Abismo de Helm", 1, 8, "Paisaje", 10);
		Atraccion atraccion3 = new Atraccion("Lothlorien", 2, 2, "Aventura", 10);
		Atraccion atraccion4 = new Atraccion("Mordor", 4, 1, "Aventura", 10);
		Atraccion atraccion5 = new Atraccion("Moria", 1, 4, "Aventura", 10);
		
		this.ofertas = new ArrayList<Oferta>();
		this.ofertas.add(atraccion1);
		this.ofertas.add(atraccion2);
		this.ofertas.add(atraccion3);
		this.ofertas.add(atraccion4);
		this.ofertas.add(atraccion5);

		this.ofertador = new Ofertador(this.ofertas, this.usuario);
		List<Oferta> ofertasEsperadas = new ArrayList<>();
		
		// Esperamos las primeras 2 atracciones, ya que para las demas se queda sin monedas y tiempo
		ofertasEsperadas.add(atraccion1);
		ofertasEsperadas.add(atraccion2);
		
		List<Oferta> ofertasObtenidas = new ArrayList<>();
		while (this.ofertador.tieneSiguienteOferta()) {
			Oferta oferta = ofertador.siguienteOferta();
			ofertasObtenidas.add(oferta);
			this.usuario.comprar(oferta);
			this.usuario.consumirTiempo(oferta.getDuracion());
			this.usuario.consumirMonedas(oferta.getPrecioConDescuento());
		}
		
		assertEquals(ofertasEsperadas, ofertasObtenidas);
	}
	
	@Test
	void noOfertaAtraccionesSinCupo() throws AtraccionExcepcion, UsuarioExcepcion, OfertadorExcepcion {
		this.usuario = new Usuario("Frodo", 100, 100, "Paisaje");
		Usuario usuario2 = new Usuario("Galadriel", 100, 100, "Paisaje");
		List<Oferta> ofertaAxB = new ArrayList<Oferta>();
		Atraccion atraccion1 = new Atraccion("Minas Tirith", 6, 6, "Paisaje", 2);
		Atraccion atraccion2 = new Atraccion("Abismo de Helm", 7, 7, "Paisaje", 2);
		Atraccion atraccion3 = new Atraccion("Rivendel", 11, 11, "Paisaje", 1);
		
		this.ofertas = new ArrayList<Oferta>();
		this.ofertas.add(atraccion1);
		this.ofertas.add(atraccion2);
		this.ofertas.add(atraccion3);

		this.ofertador = new Ofertador(this.ofertas, this.usuario);
		List<Oferta> ofertasEsperadasUsuario1 = new ArrayList<>();
		
		// Esperamos las 3 atracciones
		ofertasEsperadasUsuario1.add(atraccion3);
		ofertasEsperadasUsuario1.add(atraccion2);
		ofertasEsperadasUsuario1.add(atraccion1);
		
		List<Oferta> ofertasObtenidasUsuario1 = new ArrayList<>();
		while (this.ofertador.tieneSiguienteOferta()) {
			Oferta oferta = ofertador.siguienteOferta();
			ofertasObtenidasUsuario1.add(oferta);
			this.usuario.comprar(oferta);
			oferta.restarCupo();
		}
		
		assertEquals(ofertasEsperadasUsuario1, ofertasObtenidasUsuario1);
		
		//  Segundo User
		this.ofertador = new Ofertador(this.ofertas, usuario2);
		
		// Esperamos las primeras 2 atracciones, que les queda 1 cupo
		List<Oferta> ofertasEsperadasUsuario2 = new ArrayList<>();
		ofertasEsperadasUsuario2.add(atraccion2);
		ofertasEsperadasUsuario2.add(atraccion1);
		
		List<Oferta> ofertasObtenidasUsuario2 = new ArrayList<>();
		while (this.ofertador.tieneSiguienteOferta()) {
			Oferta oferta = ofertador.siguienteOferta();
			ofertasObtenidasUsuario2.add(oferta);
			usuario2.comprar(oferta);
		}
		
		assertEquals(ofertasEsperadasUsuario2, ofertasObtenidasUsuario2);
	}

}