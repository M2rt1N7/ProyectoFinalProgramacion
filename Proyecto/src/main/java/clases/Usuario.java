package clases;

import excepciones.ContraseñaIncorrectaException;

public class Usuario extends CosaConNombre{
	
	private String contrasenia;

	public Usuario(String nombre, String contrasenia) {
		super(nombre);
		this.contrasenia = contrasenia;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) throws ContraseñaIncorrectaException{
		if (contrasenia.length() < 8) {
			throw new ContraseñaIncorrectaException("La contraseña debe tener mínimo 8 caracteres");
		} else {
			this.contrasenia = contrasenia;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Usuario [Contrasenia=" + contrasenia + "]";
	}
	
	
}
