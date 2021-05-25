package clases;

import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreIncorrectoException;

public class Usuario extends ElementoConDescripcion {

	private String contraseña;

	public Usuario(String nombre, String contraseña) throws ContraseñaIncorrectaException, NombreIncorrectoException {
		super(nombre);
		this.setContraseña(contraseña);

	}

	public String getContraseña() {
		return contraseña;
	}

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
