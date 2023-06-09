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
	void comparaCorrectamente() {
		// TODO
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
