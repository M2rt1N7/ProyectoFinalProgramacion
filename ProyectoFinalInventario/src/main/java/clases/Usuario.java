package clases;

import excepciones.Contrase�aIncorrectaException;
import excepciones.NombreIncorrectoException;

public class Usuario extends ElementoConDescripcion {

	private String contrase�a;

	public Usuario(String nombre, String contrase�a) throws Contrase�aIncorrectaException, NombreIncorrectoException {
		super(nombre);
		this.setContrase�a(contrase�a);

	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) throws Contrase�aIncorrectaException {
		if (contrase�a.length() < 8) {
			throw new Contrase�aIncorrectaException("La contrase�a debe tener m�nimo 8 caracteres");
		} else {
			this.contrase�a = contrase�a;
		}

	}

	@Override
	public String toString() {
		return super.toString() + "Usuario [contrase�a=" + contrase�a + "]";
	}

	

}
