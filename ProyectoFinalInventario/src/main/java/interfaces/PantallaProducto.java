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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Clase que modela la interfaz PantallaProducto en la que podemos visualizar un inventario con todos los productos que tenemos en nuestra
 * base de datos, a éstos podemos aumentarle o disminuirle el stock disponible y por otro lado podemos eliminar el producto del inventario y 
 * por ende de la base de datos
 * @author Fede
 *
 */
public class PantallaProducto extends JPanel {

	private Ventana ventana;

	/**
	 * Contructor PantallaProducto
	 * @param v ventana a la que apunta
	 */
	public PantallaProducto(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentralInv = new JPanel();
		panelCentralInv.setForeground(new Color(51, 51, 0));
		panelCentralInv.setBackground(new Color(255, 255, 255));
		add(panelCentralInv, BorderLayout.CENTER);
		panelCentralInv.setLayout(null);

		
		JPanel panelListaArmas = new JPanel();
		panelListaArmas.setForeground(new Color(0, 0, 0));
		panelListaArmas.setBackground(new Color(153, 0, 0));
		

		JScrollPane scrollProducto = new JScrollPane(panelListaArmas);
		scrollProducto.setBounds(10, 104, 868, 326);
		panelCentralInv.add(scrollProducto);
		
		
		GridBagLayout gbl_PanelListaArmas = new GridBagLayout();
		gbl_PanelListaArmas.columnWidths = new int[]{0, 0};
		gbl_PanelListaArmas.rowHeights = new int[]{0, 0};
		gbl_PanelListaArmas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_PanelListaArmas.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelListaArmas.setLayout(gbl_PanelListaArmas);
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
					"1018Flutox");
			Statement st = conexion.createStatement();
			
			ResultSet resultado = st.executeQuery("select * from producto");
			int filaActual=0;
		while(resultado.next()) {
			try {
				Producto actual=new Producto(resultado.getString("nombre"),resultado.getString("codigo"),
						resultado.getString("tipo"),resultado.getShort("stock"));
				JPanel panelInfoArma = new JPanel();
				panelInfoArma.setBackground(new Color(153,0,0));
				panelInfoArma.setForeground(new Color(255,255,255));
				panelInfoArma.setSize(200,100);
				GridBagConstraints gbc_panelInfoArma = new GridBagConstraints();
				gbc_panelInfoArma.fill = GridBagConstraints.BOTH;
				gbc_panelInfoArma.gridx = 0;
				gbc_panelInfoArma.gridy = filaActual;
				filaActual++;
				GridBagLayout gbl_panelInfoArma = new GridBagLayout();
				gbl_panelInfoArma.columnWidths = new int[]{171, 162, 175, 147, 0};
				gbl_panelInfoArma.rowHeights = new int[]{30};
				panelInfoArma.setLayout(gbl_panelInfoArma);
				
				JLabel labelNombreArma = new JLabel(actual.getNombre());
				labelNombreArma.setForeground(new Color(255,255,255));
				labelNombreArma.setFont(new Font("Monospaced", Font.BOLD, 13));
				GridBagConstraints gbc_labelNombreArma = new GridBagConstraints();
				gbc_labelNombreArma.insets = new Insets(0, 0, 0, 5);
				gbc_labelNombreArma.gridx = 0;
				gbc_labelNombreArma.gridy = 0;
				panelInfoArma.add(labelNombreArma, gbc_labelNombreArma);
				
				JLabel labelCodigoArma = new JLabel(actual.getCodigo());
				labelCodigoArma.setForeground(new Color(255,255,255));
				labelCodigoArma.setFont(new Font("Monospaced", Font.BOLD, 13));
				GridBagConstraints gbc_labelCodigoArma = new GridBagConstraints();
				gbc_labelCodigoArma.insets = new Insets(0, 0, 0, 5);
				gbc_labelCodigoArma.gridx = 1;
				gbc_labelCodigoArma.gridy = 0;
				panelInfoArma.add(labelCodigoArma, gbc_labelCodigoArma);
				
				JLabel labelTipoArma = new JLabel(actual.getMarca());
				labelTipoArma.setForeground(new Color(255,255,255));
				labelTipoArma.setFont(new Font("Monospaced", Font.BOLD, 13));
				GridBagConstraints gbc_labelTipoArma = new GridBagConstraints();
				gbc_labelTipoArma.insets = new Insets(0, 0, 0, 5);
				gbc_labelTipoArma.gridx = 2;
				gbc_labelTipoArma.gridy = 0;
				panelInfoArma.add(labelTipoArma, gbc_labelTipoArma);
				
				JLabel labelStockArma = new JLabel(""+actual.getStock());
				labelStockArma.setForeground(new Color(255,255,255));
				labelStockArma.setFont(new Font("Monospaced", Font.BOLD, 13));
				GridBagConstraints gbc_labelStockArma = new GridBagConstraints();
				gbc_labelStockArma.gridx = 3;
				gbc_labelStockArma.gridy = 0;
				panelInfoArma.add(labelStockArma, gbc_labelStockArma);

				JButton botonMasStock=new JButton("+");
				
				botonMasStock.addMouseListener(new MouseAdapter() {
				@Override
				
				/**
				 * Evento que cada vez que clicamos aumenta el stock en 1  
				 */
					public void mouseClicked(MouseEvent e) { 
						
					actual.setStock((short)(actual.getStock()+1));
					
					labelStockArma.setText(""+ actual.getStock());
					try {
						Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
								"1018Flutox");
						Statement st = conexion.createStatement();
						st.executeUpdate("update producto set stock = '" + actual.getStock() + "' where codigo = '" + actual.getCodigo() +"'");
						st.close();
						conexion.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}	
				});
					
				GridBagConstraints constraints_botonMasStock = new GridBagConstraints();
				constraints_botonMasStock.gridx = 4;
				constraints_botonMasStock.gridy = 0;
				panelInfoArma.add(botonMasStock, constraints_botonMasStock);
				

				JButton botonMenosStock=new JButton("-");
				botonMenosStock.addMouseListener(new MouseAdapter() {
					
					@Override
					
					/**
					 * Evento que cada vez que clicamos disminuye el stock en 1 
					 */
					public void mouseClicked(MouseEvent e) {
						if(actual.getStock()!=0) {
							actual.setStock((short)(actual.getStock() -1));
							labelStockArma.setText(""+ actual.getStock());
							try {
								Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
										"1018Flutox");
								Statement st = conexion.createStatement();
								st.executeUpdate("update producto set stock = '" + actual.getStock() + "' where codigo = '" + actual.getCodigo() +"'");
								st.close();
								conexion.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}	
					}
				});
				
				GridBagConstraints constraints_botonMenosStock = new GridBagConstraints();
				constraints_botonMenosStock.gridx = 5;
				constraints_botonMenosStock.gridy = 0;
				panelInfoArma.add(botonMenosStock, constraints_botonMenosStock);

				JButton botonBorrar=new JButton("X");
				botonBorrar.addMouseListener(new MouseAdapter() {
					
					@Override
					
					/**
					 * Evento que al clicarlo borra el producto de la tabla y por ende de la base de datos
					 */
					public void mouseClicked(MouseEvent e) {
						try {
							Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root",
									"1018Flutox");
							Statement st = conexion.createStatement();
							st.executeUpdate("delete from producto where codigo = '" + actual.getCodigo() +"'");
							st.close();
							conexion.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ventana.volverAPantallaProducto();
						}
					});
				GridBagConstraints constraints_botonBorrar = new GridBagConstraints();
				constraints_botonBorrar.gridx = 6;
				constraints_botonBorrar.gridy = 0;
				panelInfoArma.add(botonBorrar, constraints_botonBorrar);

				panelListaArmas.add(panelInfoArma, gbc_panelInfoArma);
				/*listModel.addElement(); */
			} catch (NombreIncorrectoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}

		panelListaArmas.setVisible(false);
		panelListaArmas.setVisible(true);
			st.close();
			conexion.close();

		} catch (SQLException e1) {
			
		}
		
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
		botonVolverPro.setBounds(755, 463, 85, 21);
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
		btnNewButton.setBounds(578, 463, 152, 21);
		panelCentralInv.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 67, 74, 21);
		panelCentralInv.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CODE");
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(261, 67, 74, 21);
		panelCentralInv.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TYPE");
		lblNewLabel_2.setForeground(new Color(153, 0, 0));
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(434, 67, 74, 21);
		panelCentralInv.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("STOCK");
		lblNewLabel_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(596, 67, 74, 21);
		panelCentralInv.add(lblNewLabel_3);
		
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
