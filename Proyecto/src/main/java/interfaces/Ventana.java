package interfaces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import clases.Usuario;

public class Ventana extends JFrame{

	
	//Pantallas
	//Variable de la pantalla inicial que estamos diseñando
	private PantallaInicial pantallaInicial;
	//Variable de la pantalla de producto
	private PantallaProducto pantallaProducto;
	private PantallaUsuario pantallaUsuario;
	private PantallaRegistro pantallaRegistro;
	//Para que haya persistencia en toda las ventanas
	protected Usuario usuarioLogeado;
	
	/**
	 * Constructor de la ventana
	 */
	public Ventana() {
		this.setLocationRelativeTo(null);
		//Establece el tamaño por defecto de la ventana
		this.setSize(500, 500);
		//Establece El titulo de la ventana
		this.setTitle("Programa de prueba de Interfaces Gráficas");
		//Establece si es modificable el tamaño o no, por defecto es true
		this.setResizable(false);
		//Establece si la pantalla puede pasar a segundo plano, por defecto es false
		this.setAlwaysOnTop(false);
		//Imagen de icono
		try {
			//Lee la imagen
			BufferedImage icono=ImageIO.read(new File("icono.png"));
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
	 * Método que dirige a la pantalla de usuario
	 */
	public void irAPantallaUsuario() {
		//Si entra lo inicializa para que no de null pointer
		if(this.pantallaUsuario==null) {
			this.pantallaUsuario=new PantallaUsuario();
		}
		//Oculta la pantalla anterior, hace la comprobacion para comprobar que no de null pinter
		if(this.pantallaInicial!=null) {
			this.pantallaInicial.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaUsuario);
		//Hace visible la pantalla
		this.pantallaUsuario.setVisible(true);
	}
	
	/**
	 * Método que dirige a la pantalla de producto
	 */
	
	public void irApantallaProducto() {
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
	
	/**
	 * Método que regresa a la pantalla de usuario
	 */
	
	public void volverAPantallaUsuario() {
		
		//Oculta la pantalla anterior
		if(this.pantallaUsuario==null) {
			this.pantallaUsuario=new PantallaUsuario();
		}
		if(this.pantallaRegistro!=null) {
			this.pantallaRegistro.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaUsuario);
		//Hace visible la pantalla
		this.pantallaUsuario.setVisible(true);
	}
	
	/**
	 * Método que dirige a la pantalla de registro
	 */
	
	public void irApantallaRegistro() {
		//Si entra lo inicializa para que no de null pointer
		if(this.pantallaRegistro==null) {
			this.pantallaRegistro=new PantallaRegistro(this);
		}
		//Oculta la pantalla anterior, hace la comprobacion para comprobar que no de null pinter
		if(this.pantallaUsuario!=null) {
			this.pantallaUsuario.setVisible(false);
		}
		
		//Asigna la pantalla a la ventana
		this.setContentPane(this.pantallaRegistro);
		//Hace visible la pantalla
		this.pantallaRegistro.setVisible(true);
	}
	
	
		
	}


