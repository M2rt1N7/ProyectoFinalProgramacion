package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import clases.Usuario;
import excepciones.Contrase�aIncorrectaException;
import excepciones.NombreIncorrectoException;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PantallaInicial extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoContrase�a;
	// Apunta a la ventana que la ha llamado
	private Ventana ventana;

	public PantallaInicial(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(SystemColor.inactiveCaptionBorder);
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Monospaced", Font.PLAIN, 10));
		campoUsuario.setBackground(Color.WHITE);
		campoUsuario.setToolTipText("Introduce tu nombre de usuario");
		campoUsuario.setBounds(419, 58, 110, 20);
		panelCentral.add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelUsuario = new JLabel("USUARIO:");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setForeground(new Color(0, 51, 102));
		labelUsuario.setLabelFor(campoUsuario);
		labelUsuario.setFont(new Font("Monospaced", Font.PLAIN, 20));
		labelUsuario.setBounds(247, 53, 110, 20);
		panelCentral.add(labelUsuario);

		campoContrase�a = new JPasswordField();
		campoContrase�a.setFont(new Font("Monospaced", Font.PLAIN, 10));
		campoContrase�a.setToolTipText("Introduce tu contrase\u00F1a");
		campoContrase�a.setBounds(419, 100, 110, 20);
		panelCentral.add(campoContrase�a);

		JLabel labelContrase�a = new JLabel("CONTRASE\u00D1A:");
		labelContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		labelContrase�a.setForeground(new Color(0, 51, 102));
		labelContrase�a.setFont(new Font("Monospaced", Font.PLAIN, 20));
		labelContrase�a.setLabelFor(campoContrase�a);
		labelContrase�a.setBounds(247, 96, 143, 20);
		panelCentral.add(labelContrase�a);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(SystemColor.activeCaption);
		add(panelInferior, BorderLayout.SOUTH);

		JButton BotonLogin = new JButton("INICIAR SESI\u00D3N");
		BotonLogin.setFont(new Font("Monospaced", Font.PLAIN, 10));
		BotonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Captura los datos del formulario de ingreso
				String usuario = campoUsuario.getText();
				String contrasenia = new String(campoContrase�a.getPassword());
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
						ventana.usuarioLogeado = new Usuario(usuario, contrasenia);
						JOptionPane.showMessageDialog(ventana, "Bienvenido", "Login", JOptionPane.INFORMATION_MESSAGE);
						ventana.irAPantallaProducto();
					}else {
						JOptionPane.showMessageDialog(ventana, "Usuario o contrase�a no validos", "Login", JOptionPane.ERROR_MESSAGE);
					}

					st.close();
					conexion.close();
					
				} catch (SQLException |Contrase�aIncorrectaException | NombreIncorrectoException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		BotonLogin.setForeground(new Color(0, 51, 102));
		BotonLogin.setBackground(new Color(255, 255, 255));
		panelInferior.add(BotonLogin);

		JButton botonRegistro = new JButton("REGISTRARSE");
		botonRegistro.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantallaRegistro();
			}
		});
		botonRegistro.setForeground(new Color(0, 51, 102));
		botonRegistro.setBackground(new Color(255, 255, 255));
		panelInferior.add(botonRegistro);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.inactiveCaption);
		panelSuperior.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		add(panelSuperior, BorderLayout.NORTH);

		JLabel tituloPrincipal = new JLabel("INICIO SESI\u00D3N");
		tituloPrincipal.setForeground(new Color(0, 51, 102));
		tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPrincipal.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperior.add(tituloPrincipal);
	}
}
