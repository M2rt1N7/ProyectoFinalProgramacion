package interfaces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import clases.Usuario;

public class Ventana extends JFrame {
	
	//Pantallas
	//Variable de la pantalla inicial que estamos diseñando
	private PantallaInicial pantallaInicial;
	//Variable de la pantalla de registro
	private PantallaRegistro pantallaRegistro;
	private PantallaProducto pantallaProducto;
	private PantallaAñadir pantallaAñadir;
	//Para que haya persistencia en toda las ventanas
	protected Usuario usuarioLogeado;
	/**
	 * Constructor de la ventana
	 */
	public Ventana() {
		this.setLocationRelativeTo(null);
		//Establece el tamaño por defecto de la ventana
		this.setSize(900, 600);
		//Establece El titulo de la ventana
		this.setTitle("Proyecto Final 1ºDAM - Inventario - Federico Martin Muñoz");
		//Establece si es modificable el tamaño o no, por defecto es true
		this.setResizable(false);
		//Establece si la pantalla puede pasar a segundo plano, por defecto es false
		this.setAlwaysOnTop(false);
		//Imagen de icono
		try {
			//Lee la imagen
			BufferedImage icono=ImageIO.read(new File("imagenes/grenade.png"));
			//Establece la imagen como imagen de icono
			this.setIconImage(icono);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		//Al cerrar la ventana cierra el programa y libera memoria
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//Establece la posicion que ocupara la ventana en pantalla al abrirla
		this.setLocation(400, 200);
		
		
		//Inicializa la pantalla que hemos diseñado
		pantallaInicial=new PantallaInicial(this);
		//Asigna la pantalla que hemos diseñado a al ventana
		this.setContentPane(pantallaInicial);
		
		//Hace que la ventana sea visible, esta en false por defecto
		this.setVisible(true);
	}
	
	
	/**
	 * Método que dirige a la pantalla de registro
	 */
	public void irAPantallaRegistro() {
		//Si entra lo inicializa para que no de null pointer
		if(this.pantallaRegistro==null) {
			this.pantallaRegistro=new PantallaRegistro(this);
		}
		//Oculta la pantalla anterior, hace la comprobacion para comprobar que no de null pinter
		if(this.pantallaInicial!=null) {
			this.pantallaInicial.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaRegistro);
		//Hace visible la pantalla
		this.pantallaRegistro.setVisible(true);
	}
	
	public void volver() {
		
		//Oculta la pantalla anterior
		if(this.pantallaInicial==null) {
			this.pantallaInicial=new PantallaInicial(this);
		}
		if(this.pantallaRegistro!=null) {
			this.pantallaRegistro.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaInicial);
		//Hace visible la pantalla
		this.pantallaInicial.setVisible(true);
	}
	
	public void volverDesdeProducto() {
		
		//Oculta la pantalla anterior
		if(this.pantallaInicial==null) {
			this.pantallaInicial=new PantallaInicial(this);
		}
		if(this.pantallaProducto!=null) {
			this.pantallaProducto.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaInicial);
		//Hace visible la pantalla
		this.pantallaInicial.setVisible(true);
	}
	
	/**
	 * Método que dirige a la pantalla de registro
	 */
	public void irAPantallaProducto() {
		//Si entra lo inicializa para que no de null pointer
		if(this.pantallaProducto==null) {
			this.pantallaProducto=new PantallaProducto(this);
		}
		//Oculta la pantalla anterior, hace la comprobacion para comprobar que no de null pinter
		if(this.pantallaInicial!=null) {
			this.pantallaInicial.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaProducto);
		//Hace visible la pantalla
		this.pantallaProducto.setVisible(true);
	}
	
	public void irAPantallaAñadir() {
		//Si entra lo inicializa para que no de null pointer
		if(this.pantallaAñadir==null) {
			this.pantallaAñadir=new PantallaAñadir(this);
		}
		//Oculta la pantalla anterior, hace la comprobacion para comprobar que no de null pinter
		if(this.pantallaProducto!=null) {
			this.pantallaProducto.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaAñadir);
		//Hace visible la pantalla
		this.pantallaAñadir.setVisible(true);
	}
	
	public void volverAPantallaProducto() {
		this.pantallaProducto.setVisible(false);
		this.pantallaProducto = null;
		//Oculta la pantalla anterior
		if(this.pantallaProducto==null) {
			this.pantallaProducto=new PantallaProducto(this);
		}
		if(this.pantallaAñadir!=null) {
			this.pantallaAñadir.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaProducto);
		//Hace visible la pantalla
		this.pantallaProducto.setVisible(true);
	}


	public void setPantallaRegistro(PantallaRegistro pantallaRegistro) {
		this.pantallaRegistro = pantallaRegistro;
	}
	
	
	
}
