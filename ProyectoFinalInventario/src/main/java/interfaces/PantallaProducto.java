package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import clases.Producto;
import clases.Usuario;
import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreIncorrectoException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JScrollPane;

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
		
		DefaultListModel<Producto> listModel=new DefaultListModel<Producto>();
		JList<Producto> listProducto = new JList<Producto>(listModel);
		
		JButton botonConsultar = new JButton("CHECK INVENTORY");
		botonConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
							"1018Flutox");
					Statement st = conexion.createStatement();
					
					ResultSet resultado = st.executeQuery("select * from producto");
				while(resultado.next()) {
					try {
						listModel.addElement(new Producto(resultado.getString("nombre"),resultado.getString("codigo"),
								resultado.getString("tipo"),resultado.getShort("stock")));
					} catch (NombreIncorrectoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
				
					st.close();
					conexion.close();

				} catch (SQLException e1) {
					
				}
				
			}
		});
		botonConsultar.setForeground(new Color(255, 255, 255));
		botonConsultar.setBackground(new Color(153, 0, 0));
		botonConsultar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonConsultar.setBounds(51, 20, 193, 21);
		panelCentralInv.add(botonConsultar);
		
		JButton botonAñadir = new JButton("ADD STOCK");
		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listProducto.getSelectedIndex()!=-1) {
					if(listProducto.getSelectedValue().getStock()!=0) {
						listProducto.getSelectedValue().setStock((short)(listProducto.getSelectedValue().getStock() +1));
						try {
							Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
									"1018Flutox");
							Statement st = conexion.createStatement();
							st.executeUpdate("update producto set stock = '" + listProducto.getSelectedValue().getStock() + "' where codigo = '" + listProducto.getSelectedValue().getCodigo() +"'");
							st.close();
							conexion.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					listProducto.setModel(listModel);
				}
				
			}
		});
		botonAñadir.setBackground(new Color(153, 0, 0));
		botonAñadir.setForeground(new Color(255, 255, 255));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonAñadir.setBounds(450, 20, 167, 21);
		panelCentralInv.add(botonAñadir);

		JButton botonBorrar = new JButton("DELETE STOCK");
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				if(listProducto.getSelectedIndex()!=-1) {
					if(listProducto.getSelectedValue().getStock()!=0) {
						listProducto.getSelectedValue().setStock((short)(listProducto.getSelectedValue().getStock() -1));
						try {
							Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
									"1018Flutox");
							Statement st = conexion.createStatement();
							st.executeUpdate("update producto set stock = '" + listProducto.getSelectedValue().getStock() + "' where codigo = '" + listProducto.getSelectedValue().getCodigo() +"'");
							st.close();
							conexion.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					listProducto.setModel(listModel);
				}
					
			}	
		});
		botonBorrar.setBackground(new Color(153, 0, 0));
		botonBorrar.setForeground(new Color(255, 255, 255));
		botonBorrar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonBorrar.setBounds(646, 20, 167, 21);
		panelCentralInv.add(botonBorrar);
		
		JButton botonVolverPro = new JButton("RETURN");
		botonVolverPro.setBackground(new Color(153, 0, 0));
		botonVolverPro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.volverDesdeProducto();
			}
		});
		botonVolverPro.setForeground(Color.WHITE);
		botonVolverPro.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonVolverPro.setBounds(679, 463, 85, 21);
		panelCentralInv.add(botonVolverPro);
		
		JButton btnNewButton = new JButton("ADD PRODUCT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantallaAñadir();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.setBounds(275, 20, 152, 21);
		panelCentralInv.add(btnNewButton);
		
		JScrollPane scrollProducto = new JScrollPane();
		scrollProducto.setBounds(108, 104, 662, 326);
		panelCentralInv.add(scrollProducto);
		
				scrollProducto.setViewportView(listProducto);
				
				listProducto.setForeground(new Color(255, 255, 255));
				listProducto.setFont(new Font("Monospaced", Font.BOLD, 14));
				listProducto.setBackground(new Color(153, 0, 0));

		JPanel panelSuperiorInv = new JPanel();
		panelSuperiorInv.setForeground(new Color(255, 255, 255));
		panelSuperiorInv.setBackground(new Color(153, 0, 0));
		add(panelSuperiorInv, BorderLayout.NORTH);

		JLabel labelProducto = new JLabel("AMMU-NATION INVENTORY S.A.");
		labelProducto.setForeground(new Color(255, 255, 255));
		labelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		labelProducto.setBackground(SystemColor.inactiveCaption);
		labelProducto.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperiorInv.add(labelProducto);
	}
}
