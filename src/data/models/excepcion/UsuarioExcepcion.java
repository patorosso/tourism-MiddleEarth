package data.models.excepcion;

public class UsuarioExcepcion extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public UsuarioExcepcion(String s) {
		super(s);
	}
}
