package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class PantallaProducto extends JPanel{

	private Ventana ventana;
	
	public PantallaProducto(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentralInv = new JPanel();
		panelCentralInv.setBackground(SystemColor.inactiveCaptionBorder);
		add(panelCentralInv, BorderLayout.CENTER);
		panelCentralInv.setLayout(null);
		
		JButton botonConsultar = new JButton("CONSULTAR INVENTARIO");
		botonConsultar.setForeground(new Color(0, 51, 102));
		botonConsultar.setBackground(SystemColor.activeCaption);
		botonConsultar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonConsultar.setBounds(143, 20, 161, 21);
		panelCentralInv.add(botonConsultar);
		
		JButton botonAñadir = new JButton("A\u00D1ADIR PRODUCTO");
		botonAñadir.setForeground(new Color(0, 51, 102));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonAñadir.setBounds(339, 20, 129, 21);
		panelCentralInv.add(botonAñadir);
		
		JButton botonBorrar = new JButton("BORRAR PRODUCTO");
		botonBorrar.setForeground(new Color(0, 51, 102));
		botonBorrar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonBorrar.setBounds(500, 20, 129, 21);
		panelCentralInv.add(botonBorrar);
		
		JList listProducto = new JList();
		listProducto.setFont(new Font("Monospaced", Font.PLAIN, 12));
		listProducto.setBackground(SystemColor.inactiveCaptionBorder);
		listProducto.setBounds(32, 68, 685, 241);
		panelCentralInv.add(listProducto);
		
		JPanel panelSuperiorInv = new JPanel();
		panelSuperiorInv.setBackground(SystemColor.inactiveCaption);
		add(panelSuperiorInv, BorderLayout.NORTH);
		
		JLabel labelProducto = new JLabel("PRODUCTOS");
		labelProducto.setBackground(SystemColor.inactiveCaption);
		labelProducto.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperiorInv.add(labelProducto);
	}
}
