package clases;

import enumeraciones.TipoProducto;

public class Producto extends CosaConNombre{

	private String codigo;
	private TipoProducto producto;
	private short stock;
	public Producto(String nombre, String codigo, TipoProducto producto, Short stock) {
		super(nombre);
		this.codigo = codigo;
		this.producto = producto;
		this.stock = stock;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public TipoProducto getProducto() {
		return producto;
	}
	public void setProducto(TipoProducto producto) {
		this.producto = producto;
	}
	public Short getStock() {
		return stock;
	}
	public void setStock(Short stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return super.toString() + "Producto [codigo=" + codigo + ", producto=" + producto + ", stock=" + stock + "]";
	}
	


	
}
