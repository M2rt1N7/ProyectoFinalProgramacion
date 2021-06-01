package excepciones;

/**
 * Clase que modela una excepcion cuando la contrase�a es incorrecta
 * @author Fede
 *
 */
public class Contrase�aIncorrectaException extends Exception {

	/**
	 * Constructor que recibe un mensaje de excepcion
	 * @param msg mensaje que se lanza cuando hay una excepcion
	 */
	public Contrase�aIncorrectaException(String msg) {
		super(msg);
	}

}
