package interfaces;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.SystemColor;

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
		
		JPanel panelInferiorUsu = new JPanel();
		panelInferiorUsu.setBackground(SystemColor.control);
		add(panelInferiorUsu, BorderLayout.SOUTH);
		
		JButton BotonInicio = new JButton("Iniciar sesi\u00F3n");
		panelInferiorUsu.add(BotonInicio);
		
		JButton BotonRegistro = new JButton("Registrarse");
		panelInferiorUsu.add(BotonRegistro);
		
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
	}
}
