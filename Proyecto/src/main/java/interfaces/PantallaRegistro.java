package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class PantallaRegistro extends JPanel{
	private JTextField FieldNombreRe;
	private JPasswordField passwordContraseñaRe;
	private Ventana ventana;
	
	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorRe = new JPanel();
		panelSuperiorRe.setBackground(SystemColor.activeCaption);
		add(panelSuperiorRe, BorderLayout.NORTH);
		
		JLabel labelRegistro = new JLabel("Registrar Usuario");
		labelRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSuperiorRe.add(labelRegistro);
		
		JPanel panelInferiorRe = new JPanel();
		panelInferiorRe.setBackground(SystemColor.control);
		add(panelInferiorRe, BorderLayout.SOUTH);
		
		JButton botonVolver = new JButton("volver");
		panelInferiorRe.add(botonVolver);
		
		JButton botonRegistroRe = new JButton("registrarse");
		panelInferiorRe.add(botonRegistroRe);
		
		JPanel panelCentralRe = new JPanel();
		panelCentralRe.setBackground(SystemColor.window);
		add(panelCentralRe, BorderLayout.CENTER);
		panelCentralRe.setLayout(null);
		
		JLabel LabelNombreRe = new JLabel("Nombre Usuario :");
		LabelNombreRe.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNombreRe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LabelNombreRe.setBounds(65, 41, 158, 25);
		panelCentralRe.add(LabelNombreRe);
		
		FieldNombreRe = new JTextField();
		FieldNombreRe.setBounds(246, 48, 96, 19);
		panelCentralRe.add(FieldNombreRe);
		FieldNombreRe.setColumns(10);
		
		JLabel LabelContraseñaRe = new JLabel("Contrase\u00F1a :");
		LabelContraseñaRe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LabelContraseñaRe.setHorizontalAlignment(SwingConstants.CENTER);
		LabelContraseñaRe.setBounds(75, 80, 104, 25);
		panelCentralRe.add(LabelContraseñaRe);
		
		passwordContraseñaRe = new JPasswordField();
		passwordContraseñaRe.setBounds(246, 86, 96, 19);
		panelCentralRe.add(passwordContraseñaRe);
	}
}
