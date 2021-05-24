package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class PantallaProducto extends JPanel{
	private Ventana ventana;
	
	public PantallaProducto(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentralInv = new JPanel();
		panelCentralInv.setBackground(Color.WHITE);
		add(panelCentralInv, BorderLayout.CENTER);
		panelCentralInv.setLayout(null);
		
		JButton botonConsultar = new JButton("Consultar Inventario");
		botonConsultar.setBounds(32, 20, 125, 21);
		panelCentralInv.add(botonConsultar);
		
		JButton botonAñadir = new JButton("A\u00F1adir Producto");
		botonAñadir.setBounds(179, 20, 105, 21);
		panelCentralInv.add(botonAñadir);
		
		JButton botonBorrar = new JButton("Borrar Producto");
		botonBorrar.setBounds(301, 20, 105, 21);
		panelCentralInv.add(botonBorrar);
		
		JPanel panelSuperiorInv = new JPanel();
		panelSuperiorInv.setBackground(SystemColor.activeCaption);
		add(panelSuperiorInv, BorderLayout.NORTH);
		
		JLabel labelProducto = new JLabel("PRODUCTOS");
		labelProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSuperiorInv.add(labelProducto);
	}
}
