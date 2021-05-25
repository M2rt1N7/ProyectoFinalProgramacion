package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class PantallaBienvenida extends JPanel{

	private Ventana ventana;
	
	public PantallaBienvenida(Ventana v) {
		
		this.ventana = v;
		setBackground(Color.WHITE);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(0, 51, 0));
		panelSuperior.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		FlowLayout fl_panelSuperior = (FlowLayout) panelSuperior.getLayout();
		fl_panelSuperior.setAlignOnBaseline(true);
		add(panelSuperior, BorderLayout.NORTH);
		
		JLabel labelSistema = new JLabel("SISTEMA DE INVENTARIO");
		labelSistema.setForeground(new Color(0, 255, 0));
		labelSistema.setBackground(new Color(0, 51, 102));
		labelSistema.setFont(new Font("Monospaced", Font.PLAIN, 20));
		labelSistema.setHorizontalAlignment(SwingConstants.CENTER);
		panelSuperior.add(labelSistema);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(0, 51, 0));
		panelInferior.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		add(panelInferior, BorderLayout.SOUTH);
		
		JButton botonEntrar = new JButton("ENTRAR");
		botonEntrar.setFont(new Font("Monospaced", Font.PLAIN, 10));
		botonEntrar.setForeground(new Color(0, 51, 0));
		botonEntrar.setBackground(new Color(51, 204, 51));
		botonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantallaInicial();
			}
		});
		panelInferior.add(botonEntrar);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(0, 51, 0));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel labelSistema2 = new JLabel("InventorySix48 S.A.");
		labelSistema2.setForeground(new Color(0, 255, 0));
		labelSistema2.setBackground(Color.WHITE);
		labelSistema2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 36));
		labelSistema2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(labelSistema2);
	}
	
}
