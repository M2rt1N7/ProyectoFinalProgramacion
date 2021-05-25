package clases;

import java.time.LocalDateTime;

import enumeraciones.TipoProducto;
import excepciones.NombreIncorrectoException;

public class Producto extends ElementoConDescripcion {

	private String codigo;
	private TipoProducto tipo;
	private short stock;

	public Producto(String nombre, String codigo, TipoProducto tipo, short stock) throws NombreIncorrectoException {
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

	public TipoProducto getMarca() {
		return tipo;
	}

	public void setMarca(TipoProducto marca) {
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
		return super.toString() + "Objeto [codigo=" + codigo + ", tipo=" + tipo + ", stock=" + stock + "]";
	}

	
	
}
