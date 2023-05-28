package data.models;

import java.util.*;

public class Compra {
	
	private List<Oferta> ofertasCompradas;
	
	public Compra() {

		ofertasCompradas = new ArrayList<Oferta>();
	}
	
	public void comprarOferta(Oferta oferta) {
		ofertasCompradas.add(oferta);
	}
	
	public List<Oferta> getOfertasCompradas(){
		return ofertasCompradas;
	}
}
