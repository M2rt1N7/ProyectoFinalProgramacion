package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Producto;
import clases.Usuario;
import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreIncorrectoException;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que modela la interfaz de pantallaAñadir cuya finalidad es la de poder añadir un producto nuevo al inventario
 * @author Fede
 *
 */
public class PantallaAñadir extends JPanel {
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoCodigo;
	private JTextField campoTipo;
	private JTextField campoStock;
	public PantallaAñadir(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorAdd = new JPanel();
		panelSuperiorAdd.setBackground(new Color(153, 0, 0));
		add(panelSuperiorAdd, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("AMMU-NATION INVENTORY S.A.");
		lblNewLabel.setBackground(new Color(153, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperiorAdd.add(lblNewLabel);
		
		JPanel panelInferiorAdd = new JPanel();
		panelInferiorAdd.setBackground(new Color(153, 0, 0));
		add(panelInferiorAdd, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.volverAPantallaProducto();
			}
		});
		btnNewButton.setForeground(new Color(153, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 10));
		panelInferiorAdd.add(btnNewButton);
		
		JButton botonAñadir = new JButton("ADD PRODUCT");
		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = campoNombre.getText();
				String codigo = campoCodigo.getText();
				String tipo = campoTipo.getText();
				Short stock = Short.parseShort(campoStock.getText());
				// Constructor de String que convierte un array en String
					Connection conexion;
					try {
						Producto actual = new Producto(nombre, codigo, tipo, stock);
					// Conexion a MySQL, hay que pegar la dependencia en el pom.xml
					// El primer argumento es la cadena de conexion en String+servidor+puerto,
					// El segundo argumento es la conexion, en este caso root
					// El tercer argumento es la contraseña
						
						conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
								"1018Flutox");
						// Statement realiza las consultas, insert, etc...
					Statement st = conexion.createStatement();
					// executeupdate realiza insert update etc
					// executequery solo realiza consultas
					// Se introduce el insert tal como se hace en MySQL
					st.executeUpdate("insert into producto values('" + nombre + "', '" + codigo + "','" + tipo + "', '" + stock + "')");

					// Hay que cerrar el Statement antes de cerrar la conexion
					st.close();
					// Cierra la conexion
					conexion.close();
					JOptionPane.showMessageDialog(ventana, "Producto registrado", "Usuario",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.setPantallaRegistro(null);
					ventana.volverAPantallaProducto();
						
				} catch (SQLException | NombreIncorrectoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			 
			}
		  
		});
		botonAñadir.setBackground(new Color(255, 255, 255));
		botonAñadir.setForeground(new Color(153, 0, 0));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		panelInferiorAdd.add(botonAñadir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel textNombre = new JLabel("NAME:");
		textNombre.setForeground(new Color(153, 0, 0));
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textNombre.setBounds(229, 208, 78, 16);
		panel.add(textNombre);
		
		campoNombre = new JTextField();
		campoNombre.setForeground(new Color(255, 255, 255));
		campoNombre.setBackground(new Color(153, 0, 0));
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setFont(new Font("Monospaced", Font.PLAIN, 14));
		campoNombre.setBounds(317, 206, 96, 19);
		panel.add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel textCodigo = new JLabel("CODE:");
		textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		textCodigo.setForeground(new Color(153, 0, 0));
		textCodigo.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textCodigo.setBounds(229, 299, 78, 16);
		panel.add(textCodigo);
		
		campoCodigo = new JTextField();
		campoCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		campoCodigo.setForeground(Color.WHITE);
		campoCodigo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		campoCodigo.setColumns(10);
		campoCodigo.setBackground(new Color(153, 0, 0));
		campoCodigo.setBounds(317, 297, 96, 19);
		panel.add(campoCodigo);
		
		JLabel textTipo = new JLabel("TYPE:");
		textTipo.setHorizontalAlignment(SwingConstants.CENTER);
		textTipo.setForeground(new Color(153, 0, 0));
		textTipo.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textTipo.setBounds(431, 208, 78, 16);
		panel.add(textTipo);
		
		campoTipo = new JTextField();
		campoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		campoTipo.setForeground(Color.WHITE);
		campoTipo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		campoTipo.setColumns(10);
		campoTipo.setBackground(new Color(153, 0, 0));
		campoTipo.setBounds(534, 206, 96, 19);
		panel.add(campoTipo);
		
		JLabel textStock = new JLabel("STOCK:");
		textStock.setHorizontalAlignment(SwingConstants.CENTER);
		textStock.setForeground(new Color(153, 0, 0));
		textStock.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textStock.setBounds(431, 299, 78, 16);
		panel.add(textStock);
		
		campoStock = new JTextField();
		campoStock.setHorizontalAlignment(SwingConstants.CENTER);
		campoStock.setForeground(Color.WHITE);
		campoStock.setFont(new Font("Monospaced", Font.PLAIN, 14));
		campoStock.setColumns(10);
		campoStock.setBackground(new Color(153, 0, 0));
		campoStock.setBounds(534, 297, 96, 19);
		panel.add(campoStock);
	}
}
