import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import data.models.Atraccion;
import data.models.Oferta;
import data.models.Ofertador;
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
			e.printStackTrace();
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	void creaOfertadorCorrectamente() {
		setup();
		try {
			this.ofertador = new Ofertador(this.ofertas, this.usuario);
		} catch (OfertadorExcepcion e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
	@Test
	void comprobarOrdenTestComplejo() {
		// TODO - Probar con mas atracciones y promociones
	}

}
