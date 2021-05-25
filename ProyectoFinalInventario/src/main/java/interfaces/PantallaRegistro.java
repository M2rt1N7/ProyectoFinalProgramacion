package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.event.ChangeListener;

import clases.Usuario;

import javax.swing.event.ChangeEvent;
import excepciones.Contrase�aIncorrectaException;
import excepciones.NombreIncorrectoException;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class PantallaRegistro extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoContrase�a;
	private Ventana ventana;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(0, 51, 0));
		panelSuperior.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		add(panelSuperior, BorderLayout.NORTH);

		JLabel titulo = new JLabel("REGISTRAR USUARIO");
		titulo.setForeground(new Color(0, 255, 0));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperior.add(titulo);

		final JPanel panelCentral = new JPanel();
		panelCentral.setToolTipText("Introduce el nombre de usuario");
		panelCentral.setBackground(new Color(0, 51, 0));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		campoUsuario = new JTextField();
		campoUsuario.setBackground(new Color(51, 204, 51));
		campoUsuario.setForeground(new Color(0, 51, 0));
		campoUsuario.setFont(new Font("Monospaced", Font.PLAIN, 10));
		campoUsuario.setBounds(458, 78, 114, 19);
		panelCentral.add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelUsuario = new JLabel("NOMBRE USUARIO:");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setForeground(new Color(0, 255, 0));
		labelUsuario.setFont(new Font("Monospaced", Font.PLAIN, 20));
		labelUsuario.setBounds(221, 79, 197, 17);
		panelCentral.add(labelUsuario);

		JLabel labelContrase�a = new JLabel("CONTRASE\u00D1A:");
		labelContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		labelContrase�a.setForeground(new Color(0, 255, 0));
		labelContrase�a.setFont(new Font("Monospaced", Font.PLAIN, 20));
		labelContrase�a.setBounds(221, 121, 151, 19);
		panelCentral.add(labelContrase�a);

		campoContrase�a = new JPasswordField();
		campoContrase�a.setBackground(new Color(51, 204, 51));
		campoContrase�a.setForeground(new Color(0, 51, 0));
		campoContrase�a.setToolTipText("Introduce la contrase\u00F1a");
		campoContrase�a.setFont(new Font("Monospaced", Font.PLAIN, 10));
		campoContrase�a.setBounds(458, 121, 114, 19);
		panelCentral.add(campoContrase�a);

		// Grupo de botones para que solo funcione uno a la vez
		ButtonGroup grupoGenero = new ButtonGroup();

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(0, 51, 0));
		add(panelInferior, BorderLayout.SOUTH);

		JButton botonVolver = new JButton("VOLVER");
		botonVolver.setBackground(new Color(51, 204, 51));
		botonVolver.setForeground(new Color(0, 51, 0));
		botonVolver.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.volver();
			}
		});
		panelInferior.add(botonVolver);

		// Hay que tener cuidado con el orden de las funciones, no reconoce lo que esta
		// fuera del ambito por debajo
		final JButton botonRegistro = new JButton("REGISTRARSE");
		botonRegistro.setBackground(new Color(0, 51, 0));
		botonRegistro.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonRegistro.setForeground(new Color(51, 204, 51));
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = campoUsuario.getText();
				// Constructor de String que convierte un array en String
				String contrasenia = new String(campoContrase�a.getPassword());

				try {
					Usuario actual = new Usuario(nombreUsuario, contrasenia);
					// Conexion a MySQL, hay que pegar la dependencia en el pom.xml
					// El primer argumento es la cadena de conexion en String+servidor+puerto,
					// El segundo argumento es la conexion, en este caso root
					// El tercer argumento es la contrase�a
					Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pruebas1dam", "root",
							"1018Flutox");
					// Statement realiza las consultas, insert, etc...
					Statement st = conexion.createStatement();
					// executeupdate realiza insert update etc
					// executequery solo realiza consultas
					// Se introduce el insert tal como se hace en MySQL
					st.executeUpdate("insert into usuario values('" + nombreUsuario + "', '" + contrasenia + "'");

					// Hay que cerrar el Statement antes de cerrar la conexion
					st.close();
					// Cierra la conexion
					conexion.close();
					JOptionPane.showMessageDialog(ventana, "Usuario registrado", "Usuario",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.volver();
				} catch (Contrase�aIncorrectaException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					campoContrase�a.setBackground(new Color(255, 220, 220));
				} catch (NombreIncorrectoException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					campoUsuario.setBackground(new Color(255, 220, 220));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//botonRegistro.setBackground(new Color(200, 0, 0));
				//botonRegistro.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonRegistro.setBackground(null);
				botonRegistro.setForeground(null);
			}
		});
		panelInferior.add(botonRegistro);
	}
}
