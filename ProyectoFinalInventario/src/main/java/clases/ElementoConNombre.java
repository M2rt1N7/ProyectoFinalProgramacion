package clases;

import excepciones.NombreIncorrectoException;
/**
 * Superclase que da nombre a un usuario o producto 
 * @author Fede
 *
 */
public class ElementoConNombre {

	/**
	 * Nombre del elemento
	 */
	private String nombre;
	
	
	/**
	 * Constructor de la excepcion 
	 * @param nombre nombre del elemento
	 * @throws NombreIncorrectoException la excepcion que se lanza cuando el nombre es incorrecto
	 */
	public ElementoConNombre(String nombre) throws NombreIncorrectoException {
		super();
		this.setNombre(nombre);
	
	}

	/**
	 * Obtiene el nombre del elemento
	 * @return nombre del elemento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el nombre del elemento 
	 * @param nombre nombre del elemento
	 * @throws NombreIncorrectoException la excepcion que se lanza cuando el nombre es incorrecto
	 */
	public void setNombre(String nombre) throws NombreIncorrectoException {
		if(nombre.isEmpty()) {
			throw new NombreIncorrectoException("El Nombre no puede estar vacío");
		}else {
			this.nombre = nombre;
		}
		
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
