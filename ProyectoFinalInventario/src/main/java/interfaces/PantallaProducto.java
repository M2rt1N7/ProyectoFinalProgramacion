package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PantallaProducto extends JPanel{

	private Ventana ventana;
	
	public PantallaProducto(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentralInv = new JPanel();
		panelCentralInv.setForeground(new Color(51, 51, 0));
		panelCentralInv.setBackground(new Color(0, 51, 0));
		add(panelCentralInv, BorderLayout.CENTER);
		panelCentralInv.setLayout(null);
		
		JButton botonConsultar = new JButton("CONSULTAR INVENTARIO");
		botonConsultar.setForeground(new Color(0, 51, 0));
		botonConsultar.setBackground(new Color(0, 255, 0));
		botonConsultar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonConsultar.setBounds(168, 20, 161, 21);
		panelCentralInv.add(botonConsultar);
		
		JButton botonAñadir = new JButton("A\u00D1ADIR PRODUCTO");
		botonAñadir.setBackground(new Color(0, 255, 0));
		botonAñadir.setForeground(new Color(0, 51, 0));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonAñadir.setBounds(339, 20, 129, 21);
		panelCentralInv.add(botonAñadir);
		
		JButton botonBorrar = new JButton("BORRAR PRODUCTO");
		botonBorrar.setBackground(new Color(0, 255, 0));
		botonBorrar.setForeground(new Color(0, 51, 0));
		botonBorrar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonBorrar.setBounds(478, 20, 129, 21);
		panelCentralInv.add(botonBorrar);
		
		JList listProducto = new JList();
		listProducto.setForeground(new Color(0, 255, 0));
		listProducto.setFont(new Font("Monospaced", Font.PLAIN, 12));
		listProducto.setBackground(new Color(0, 51, 0));
		listProducto.setBounds(24, 64, 685, 241);
		panelCentralInv.add(listProducto);
		
		JPanel panelSuperiorInv = new JPanel();
		panelSuperiorInv.setBackground(new Color(0, 51, 0));
		add(panelSuperiorInv, BorderLayout.NORTH);
		
		JLabel labelProducto = new JLabel("PRODUCTOS");
		labelProducto.setForeground(new Color(0, 255, 0));
		labelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProducto.setBackground(SystemColor.inactiveCaption);
		labelProducto.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperiorInv.add(labelProducto);
	}
}
