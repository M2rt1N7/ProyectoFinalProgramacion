package clases;

import java.time.LocalDateTime;
import excepciones.NombreIncorrectoException;

public class Producto extends ElementoConNombre {

	private String codigo;
	private String tipo;
	private short stock;

	public Producto(String nombre, String codigo, String tipo, short stock) throws NombreIncorrectoException {
		super(nombre);
		this.codigo = codigo;
		this.tipo = tipo;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return tipo;
	}

	public void setMarca(String marca) {
		this.tipo = tipo;
	}

	public short getStock() {
		return stock;
	}

	public void setStock(short stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return super.toString() + "  -->  CODE = " + codigo + " | TYPE = " + tipo + " | STOCK = " + stock + "";
	}

	
	
}
