package clases;

import java.time.LocalDateTime;

import enumeraciones.TipoProducto;
import excepciones.NombreIncorrectoException;

public class Objeto extends ElementoConDescripcion {

	private String codigo;
	private TipoProducto marca;
	private short stock;

	public Objeto(String nombre, String codigo, TipoProducto marca, short stock) throws NombreIncorrectoException {
		super(nombre);
		this.codigo = codigo;
		this.marca = marca;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoProducto getMarca() {
		return marca;
	}

	public void setMarca(TipoProducto marca) {
		this.marca = marca;
	}

	public short getStock() {
		return stock;
	}

	public void setStock(short stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return super.toString() + "Objeto [codigo=" + codigo + ", marca=" + marca + ", stock=" + stock + "]";
	}

	
	
}
