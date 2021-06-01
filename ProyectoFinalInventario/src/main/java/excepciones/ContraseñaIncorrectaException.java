package excepciones;

/**
 * Clase que modela una excepcion cuando la contraseña es incorrecta
 * @author Fede
 *
 */
public class ContraseñaIncorrectaException extends Exception {

	/**
	 * Constructor que recibe un mensaje de excepcion
	 * @param msg mensaje que se lanza cuando hay una excepcion
	 */
	public ContraseñaIncorrectaException(String msg) {
		super(msg);
	}

}
