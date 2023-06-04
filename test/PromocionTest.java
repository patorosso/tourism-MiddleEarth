import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import data.models.Atraccion;
import data.models.Oferta;
import data.models.Promocion;
import data.models.PromocionAbsoluta;
import data.models.excepcion.AtraccionExcepcion;

class PromocionTest {
	
	Promocion promocion;

	@Test
	void creaPromocionCorrectamente() {
		try {
			List<Oferta> ofertas = new ArrayList<Oferta>();
			Oferta oferta1 = new Atraccion("atraccion1", 5, 5, "tipo 1", 1);
			Oferta oferta2 = new Atraccion("atraccion2", 4, 4, "tipo 2", 1);
			ofertas.add(oferta1);
			ofertas.add(oferta2);
			this.promocion = new PromocionAbsoluta(ofertas, 1);
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
		creaPromocionCorrectamente();
		try {
			Atraccion oferta1 = new Atraccion("atraccion1", 5, 5, "tipo 1", 3);
			Atraccion oferta3 = new Atraccion("atraccion3", 5, 5, "tipo 1", 3);
			Assert.assertTrue(this.promocion.equals(oferta1));
			Assert.assertFalse(this.promocion.equals(oferta3));
		} catch (AtraccionExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void restaCupoCorrectamente() {
		creaPromocionCorrectamente();
		this.promocion.restarCupo();
		Assert.assertFalse(this.promocion.hayCupo());
	}

}
