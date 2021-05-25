package clases;

import excepciones.NombreIncorrectoException;

public class ElementoConDescripcion {

	private String nombre;
	
	
	
	public ElementoConDescripcion(String nombre) throws NombreIncorrectoException {
		super();
		this.setNombre(nombre);
	
	}


	public String getNombre() {
		return nombre;
	}


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
