package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Producto;
import clases.Usuario;
import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreIncorrectoException;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PantallaAñadir extends JPanel {
	private Ventana ventana;
	private JTextField textNombre;
	private JTextField textCodigo;
	private JTextField textTipo;
	private JTextField textStock;
	public PantallaAñadir(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorAdd = new JPanel();
		panelSuperiorAdd.setBackground(new Color(153, 0, 0));
		add(panelSuperiorAdd, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("AMMU-NATION INVENTORY S.A.");
		lblNewLabel.setBackground(new Color(153, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperiorAdd.add(lblNewLabel);
		
		JPanel panelInferiorAdd = new JPanel();
		panelInferiorAdd.setBackground(new Color(153, 0, 0));
		add(panelInferiorAdd, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.volverAPantallaProducto();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 10));
		panelInferiorAdd.add(btnNewButton);
		
		JButton botonAñadir = new JButton("ADD PRODUCT");
		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		botonAñadir.setBackground(new Color(153, 0, 0));
		botonAñadir.setForeground(new Color(255, 255, 255));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		panelInferiorAdd.add(botonAñadir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel campoNombre = new JLabel("NAME:");
		campoNombre.setForeground(new Color(153, 0, 0));
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setFont(new Font("Monospaced", Font.PLAIN, 13));
		campoNombre.setBounds(229, 208, 78, 16);
		panel.add(campoNombre);
		
		textNombre = new JTextField();
		textNombre.setForeground(new Color(255, 255, 255));
		textNombre.setBackground(new Color(153, 0, 0));
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textNombre.setBounds(317, 206, 96, 19);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel campoCodigo = new JLabel("CODE:");
		campoCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		campoCodigo.setForeground(new Color(153, 0, 0));
		campoCodigo.setFont(new Font("Monospaced", Font.PLAIN, 13));
		campoCodigo.setBounds(229, 299, 78, 16);
		panel.add(campoCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		textCodigo.setForeground(Color.WHITE);
		textCodigo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textCodigo.setColumns(10);
		textCodigo.setBackground(new Color(153, 0, 0));
		textCodigo.setBounds(317, 297, 96, 19);
		panel.add(textCodigo);
		
		JLabel campoTipo = new JLabel("TYPE:");
		campoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		campoTipo.setForeground(new Color(153, 0, 0));
		campoTipo.setFont(new Font("Monospaced", Font.PLAIN, 13));
		campoTipo.setBounds(431, 208, 78, 16);
		panel.add(campoTipo);
		
		textTipo = new JTextField();
		textTipo.setHorizontalAlignment(SwingConstants.CENTER);
		textTipo.setForeground(Color.WHITE);
		textTipo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textTipo.setColumns(10);
		textTipo.setBackground(new Color(153, 0, 0));
		textTipo.setBounds(534, 206, 96, 19);
		panel.add(textTipo);
		
		JLabel campoStock = new JLabel("STOCK:");
		campoStock.setHorizontalAlignment(SwingConstants.CENTER);
		campoStock.setForeground(new Color(153, 0, 0));
		campoStock.setFont(new Font("Monospaced", Font.PLAIN, 13));
		campoStock.setBounds(431, 299, 78, 16);
		panel.add(campoStock);
		
		textStock = new JTextField();
		textStock.setHorizontalAlignment(SwingConstants.CENTER);
		textStock.setForeground(Color.WHITE);
		textStock.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textStock.setColumns(10);
		textStock.setBackground(new Color(153, 0, 0));
		textStock.setBounds(534, 297, 96, 19);
		panel.add(textStock);
	}
}
