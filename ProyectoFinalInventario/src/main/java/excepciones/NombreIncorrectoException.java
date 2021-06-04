package excepciones;

/**
 * Clase que modela una excepcion cuando el nombre el incorrecto
 * @author Fede
 *
 */
public class NombreIncorrectoException extends Exception {

	/**
	 * Constructor de NombreIncorrectoException que recibe un mensaje de excepcion
	 * @param msg mensaje que se lanza cuando se produce la excepcion
	 */
	public NombreIncorrectoException(String msg) {
		super(msg);
	}
	
}
