package clases;

import excepciones.Contrase�aIncorrectaException;
import excepciones.NombreIncorrectoException;

/**
 * Clase que modela al usuario
 * @author Fede
 *
 */
public class Usuario extends ElementoConNombre {

	/**
	 * contrase�a del usuario
	 */
	private String contrase�a;

	/**
	 * Constructor de Usuario
	 * @param nombre nombre del usuario
	 * @param contrase�a contrase�a del usuario
	 * @throws Contrase�aIncorrectaException excepcion que se lanza cuando la contrase�a es incorrecta
	 * @throws NombreIncorrectoException excepcion que se lanza cuando el nombre es incorrecto
	 */
	public Usuario(String nombre, String contrase�a) throws Contrase�aIncorrectaException, NombreIncorrectoException {
		super(nombre);
		this.setContrase�a(contrase�a);

	}

	/**
	 * Obtiene la contrase�a
	 * @return contrase�a del usuario
	 */
	public String getContrase�a() {
		return contrase�a;
	}

	/**
	 * Devuelve la contrase�a
	 * @param contrase�a contrase�a del usuario
	 * @throws Contrase�aIncorrectaException excepcion que se lanza cuando la contrase�a es incorrecta
	 */
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
