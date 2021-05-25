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

public class PantallaProducto extends JPanel {

	private Ventana ventana;

	public PantallaProducto(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentralInv = new JPanel();
		panelCentralInv.setForeground(new Color(51, 51, 0));
		panelCentralInv.setBackground(new Color(255, 255, 255));
		add(panelCentralInv, BorderLayout.CENTER);
		panelCentralInv.setLayout(null);

		JButton botonConsultar = new JButton("CONSULTAR INVENTARIO");
		botonConsultar.setForeground(new Color(255, 255, 255));
		botonConsultar.setBackground(new Color(153, 0, 0));
		botonConsultar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonConsultar.setBounds(171, 20, 193, 21);
		panelCentralInv.add(botonConsultar);

		JButton botonAñadir = new JButton("A\u00D1ADIR PRODUCTO");
		botonAñadir.setBackground(new Color(153, 0, 0));
		botonAñadir.setForeground(new Color(255, 255, 255));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonAñadir.setBounds(393, 20, 167, 21);
		panelCentralInv.add(botonAñadir);

		JButton botonBorrar = new JButton("BORRAR PRODUCTO");
		botonBorrar.setBackground(new Color(153, 0, 0));
		botonBorrar.setForeground(new Color(255, 255, 255));
		botonBorrar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonBorrar.setBounds(594, 20, 167, 21);
		panelCentralInv.add(botonBorrar);

		JList listProducto = new JList();
		listProducto.setForeground(new Color(255, 255, 255));
		listProducto.setFont(new Font("Monospaced", Font.PLAIN, 12));
		listProducto.setBackground(new Color(153, 0, 0));
		listProducto.setBounds(114, 124, 692, 336);
		panelCentralInv.add(listProducto);

		JPanel panelSuperiorInv = new JPanel();
		panelSuperiorInv.setForeground(new Color(255, 255, 255));
		panelSuperiorInv.setBackground(new Color(153, 0, 0));
		add(panelSuperiorInv, BorderLayout.NORTH);

		JLabel labelProducto = new JLabel("10DaysToDie S.A.");
		labelProducto.setForeground(new Color(255, 255, 255));
		labelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProducto.setBackground(SystemColor.inactiveCaption);
		labelProducto.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperiorInv.add(labelProducto);
	}
}
