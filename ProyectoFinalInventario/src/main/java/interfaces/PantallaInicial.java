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
import excepciones.ContraseñaIncorrectaException;
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
	private JPasswordField campoContraseña;
	// Apunta a la ventana que la ha llamado
	private Ventana ventana;

	public PantallaInicial(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setForeground(new Color(51, 51, 0));
		panelCentral.setBackground(new Color(255, 255, 255));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		campoUsuario = new JTextField();
		campoUsuario.setForeground(new Color(255, 255, 255));
		campoUsuario.setFont(new Font("Monospaced", Font.BOLD, 14));
		campoUsuario.setBackground(new Color(153, 0, 0));
		campoUsuario.setToolTipText("Introduce tu nombre de usuario");
		campoUsuario.setBounds(479, 330, 110, 20);
		panelCentral.add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelUsuario = new JLabel("USER:");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setForeground(new Color(153, 0, 0));
		labelUsuario.setLabelFor(campoUsuario);
		labelUsuario.setFont(new Font("Monospaced", Font.PLAIN, 20));
		labelUsuario.setBounds(338, 326, 88, 20);
		panelCentral.add(labelUsuario);

		campoContraseña = new JPasswordField();
		campoContraseña.setBackground(new Color(153, 0, 0));
		campoContraseña.setForeground(new Color(255, 255, 255));
		campoContraseña.setFont(new Font("Monospaced", Font.BOLD, 14));
		campoContraseña.setToolTipText("Introduce tu contrase\u00F1a");
		campoContraseña.setBounds(479, 371, 110, 20);
		panelCentral.add(campoContraseña);

		JLabel labelContraseña = new JLabel("PASSWORD:");
		labelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraseña.setForeground(new Color(153, 0, 0));
		labelContraseña.setFont(new Font("Monospaced", Font.PLAIN, 20));
		labelContraseña.setLabelFor(campoContraseña);
		labelContraseña.setBounds(315, 367, 143, 20);
		panelCentral.add(labelContraseña);
		
		JLabel lblNewLabel = new JLabel("| | |  AMMU-NATi  N  | | |");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Magneto", Font.BOLD, 40));
		lblNewLabel.setBounds(138, 181, 647, 40);
		panelCentral.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory");
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(580, 218, 136, 21);
		panelCentral.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Fede\\Desktop\\ProyectoFinalInventario\\imagenes\\objetivoarma.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(572, 173, 56, 48);
		panelCentral.add(lblNewLabel_2);

		JPanel panelInferior = new JPanel();
		panelInferior.setForeground(new Color(0, 0, 0));
		panelInferior.setBackground(new Color(153, 0, 0));
		add(panelInferior, BorderLayout.SOUTH);

		JButton BotonLogin = new JButton("LOG IN");
		BotonLogin.setFont(new Font("Monospaced", Font.PLAIN, 10));
		BotonLogin.addActionListener(new ActionListener() {
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
					// Recorre el ResultSet como si fuera un iterator, si solo da un resultado, se
					// puede usar un if
					if (resultado.next()) {
						// Este metodo devuelve el tipo de dato indicandole la columna
						usuario = resultado.getString("nombre");
						contrasenia = resultado.getString("contrasenia");
						// Modifica la variable de ventana
						ventana.usuarioLogeado = new Usuario(usuario, contrasenia);
						JOptionPane.showMessageDialog(ventana, " Welcome Sir! ", "usuario", JOptionPane.INFORMATION_MESSAGE);
						ventana.irAPantallaProducto();
					} else {
						JOptionPane.showMessageDialog(ventana, "ERROR: invalid username or password", "Login",
								JOptionPane.ERROR_MESSAGE);
					}

					st.close();
					conexion.close();

				} catch (SQLException | ContraseñaIncorrectaException | NombreIncorrectoException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		BotonLogin.setForeground(new Color(255, 255, 255));
		BotonLogin.setBackground(new Color(153, 0, 0));
		panelInferior.add(BotonLogin);

		JButton botonRegistro = new JButton("CHECK IN");
		botonRegistro.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantallaRegistro();
			}
		});
		botonRegistro.setForeground(new Color(255, 255, 255));
		botonRegistro.setBackground(new Color(153, 0, 0));
		panelInferior.add(botonRegistro);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(153, 0, 0));
		panelSuperior.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		add(panelSuperior, BorderLayout.NORTH);

		JLabel tituloPrincipal = new JLabel("AMMU-NATION INVENTORY S.A.");
		tituloPrincipal.setForeground(new Color(255, 255, 255));
		tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPrincipal.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperior.add(tituloPrincipal);
	}
}
