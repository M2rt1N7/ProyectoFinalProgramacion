package clases;

import java.time.LocalDateTime;
import excepciones.NombreIncorrectoException;

/**
 * Clase que modela el producto
 * @author Fede
 *
 */
public class Producto extends ElementoConNombre {
	/**
	 * indica el codigo del producto
	 */
	private String codigo;
	
	/**
	 * indica el tipo de producto que es
	 */
	private String tipo;
	
	/**
	 * indica si hay existencias de stock o no del producto
	 */
	private short stock;

	/**
	 * Constructor de Producto con sus respectivos campos
	 * @param nombre nombre del producto
	 * @param codigo codigo del producto
	 * @param tipo tipo de producto
	 * @param stock numero de existencias de stock
	 * @throws NombreIncorrectoException excepcion que se lanza cuando el nombre es incorrecto
	 */
	public Producto(String nombre, String codigo, String tipo, short stock) throws NombreIncorrectoException {
		super(nombre);
		this.codigo = codigo;
		this.tipo = tipo;
		this.stock = stock;
	}

	/**
	 * Obtiene el codigo del producto
	 * @return codigo del producto
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Devuelve el codigo del producto
	 * @param codigo Codigo del producto
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el tipo de producto
	 * @return tipo de producto
	 */
	public String getMarca() {
		return tipo;
	}

	/**
	 * Devuelve el tipo de producto
	 * @param marca tipo de producto
	 */
	public void setMarca(String marca) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el número de stock del producto
	 * @return stock del producto
	 */
	public short getStock() {
		return stock;
	}

	/**
	 * Devuelve el numero de stock del producto
	 * @param stock Stock del producto
	 */
	public void setStock(short stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return super.toString() + "  -->  CODE = " + codigo + " | TYPE = " + tipo + " | STOCK = " + stock + "";
	}

	
	
}
