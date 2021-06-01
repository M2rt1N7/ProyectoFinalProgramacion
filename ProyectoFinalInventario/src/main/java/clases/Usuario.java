package clases;

import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreIncorrectoException;

/**
 * Clase que modela al usuario
 * @author Fede
 *
 */
public class Usuario extends ElementoConNombre {

	/**
	 * contraseña del usuario
	 */
	private String contraseña;

	/**
	 * Constructor de Usuario
	 * @param nombre nombre del usuario
	 * @param contraseña contraseña del usuario
	 * @throws ContraseñaIncorrectaException excepcion que se lanza cuando la contraseña es incorrecta
	 * @throws NombreIncorrectoException excepcion que se lanza cuando el nombre es incorrecto
	 */
	public Usuario(String nombre, String contraseña) throws ContraseñaIncorrectaException, NombreIncorrectoException {
		super(nombre);
		this.setContraseña(contraseña);

	}

	/**
	 * Obtiene la contraseña
	 * @return contraseña del usuario
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Devuelve la contraseña
	 * @param contraseña contraseña del usuario
	 * @throws ContraseñaIncorrectaException excepcion que se lanza cuando la contraseña es incorrecta
	 */
	public void setContraseña(String contraseña) throws ContraseñaIncorrectaException {
		if (contraseña.length() < 8) {
			throw new ContraseñaIncorrectaException("La contraseña debe tener mínimo 8 caracteres");
		} else {
			this.contraseña = contraseña;
		}

	}

	@Override
	public String toString() {
		return super.toString() + "Usuario [contraseña=" + contraseña + "]";
	}

	

}
