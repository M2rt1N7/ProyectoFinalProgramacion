package clases;

import excepciones.NombreIncorrectoException;

public class CosaConNombre {

	private String nombre;

	
	public CosaConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreIncorrectoException{
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
