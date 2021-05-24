package interfaces;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import clases.Usuario;

import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreIncorrectoException;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PantallaUsuario extends JPanel{
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private Ventana ventana;
	
	public PantallaUsuario() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorUsu = new JPanel();
		panelSuperiorUsu.setBackground(SystemColor.activeCaption);
		add(panelSuperiorUsu, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Control del Sistema ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSuperiorUsu.add(lblNewLabel);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.WHITE);
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setBounds(100, 56, 75, 19);
		panelCentral.add(labelUsuario);
		
		JLabel labelContraseña = new JLabel("Contrase\u00F1a:");
		labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraseña.setBounds(81, 106, 113, 25);
		panelCentral.add(labelContraseña);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(244, 60, 96, 19);
		panelCentral.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(244, 113, 96, 19);
		panelCentral.add(campoContraseña);
		
		JPanel panelInferiorUsu = new JPanel();
		panelInferiorUsu.setBackground(SystemColor.control);
		add(panelInferiorUsu, BorderLayout.SOUTH);
		
		JButton BotonInicio = new JButton("Iniciar sesi\u00F3n");
		BotonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Captura los datos del formulario de ingreso
				String usuario = campoUsuario.getText();
				String contrasenia = new String(campoContraseña.getPassword());
				// Valida los datos introducidos con los de la base de datos
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pruebas1dam", "root",
							"1018Flutox");
					Statement st = conexion.createStatement();
					// Cursor que guarda el resultado de la consulta
					ResultSet resultado = st.executeQuery("select * from usuario where nombre='" + usuario
							+ "' and contrasenia='" + contrasenia + "'");
					// Recorre el ResultSet como si fuera un iterator, si solo da un resultado, se puede usar un if
					if (resultado.next()) {
						// Este metodo devuelve el tipo de dato indicandole la columna
						usuario = resultado.getString("nombre");
						contrasenia = resultado.getString("contrasenia");
						//Modifica la variable de ventana
						ventana.usuarioLogeado = new Usuario(usuario,contrasenia);
						JOptionPane.showMessageDialog(ventana, "Bienvenido", "Login", JOptionPane.INFORMATION_MESSAGE);
						ventana.irApantallaProducto();
					}else {
						JOptionPane.showMessageDialog(ventana, "Usuario o contraseña no validos", "Login", JOptionPane.ERROR_MESSAGE);
					}

					st.close();
					conexion.close();
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		panelInferiorUsu.add(BotonInicio);
		
		JButton BotonRegistro = new JButton("Registrarse");
		BotonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irApantallaRegistro();
			}
		});
		panelInferiorUsu.add(BotonRegistro);
		
		
	}
}
