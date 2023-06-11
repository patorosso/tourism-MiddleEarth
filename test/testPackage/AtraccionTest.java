package testPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import data.models.Atraccion;
import data.models.excepcion.AtraccionExcepcion;

class AtraccionTest {
	
	Atraccion atraccion;

	@Test
	void creaAtraccionCorrectamenteTest() {
		try {
			this.atraccion = new Atraccion("atraccion", 5, 5, "tipo 1", 1);
		} catch (AtraccionExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void comparaCorrectamente() throws AtraccionExcepcion {
		Atraccion atraccion1 = new Atraccion("Moria", 4, 4, "Aventura", 1);
		Atraccion atraccion2 = new Atraccion("Mordor", 5, 5, "Aventura", 1);
		assertEquals(1, atraccion1.compareTo(atraccion2));
		assertEquals(-1, atraccion2.compareTo(atraccion1));
	}
	
	@Test
	void equalsTest() {
		creaAtraccionCorrectamenteTest();
		try {
			Atraccion oferta = new Atraccion("atraccion", 5, 5, "tipo 1", 3);
			Assert.assertTrue(this.atraccion.equals(oferta));
		} catch (AtraccionExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void restaCupoCorrectamente() {
		creaAtraccionCorrectamenteTest();
		this.atraccion.restarCupo();
		Assert.assertFalse(this.atraccion.hayCupo());
	}

}