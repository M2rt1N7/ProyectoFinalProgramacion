package clases;

import excepciones.Contrase�aIncorrectaException;

public class Usuario extends CosaConNombre{
	
	private String contrasenia;

	public Usuario(String nombre, String contrasenia) {
		super(nombre);
		this.contrasenia = contrasenia;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) throws Contrase�aIncorrectaException{
		if (contrasenia.length() < 8) {
			throw new Contrase�aIncorrectaException("La contrase�a debe tener m�nimo 8 caracteres");
		} else {
			this.contrasenia = contrasenia;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Usuario [Contrasenia=" + contrasenia + "]";
	}
	
	
}
