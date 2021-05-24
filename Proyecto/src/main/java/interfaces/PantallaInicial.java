package interfaces;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicial extends JPanel{
	private Ventana ventana;
	
	public PantallaInicial(Ventana v) {
		
		this.ventana = v;
		setBackground(Color.WHITE);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.activeCaption);
		panelSuperior.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		FlowLayout fl_panelSuperior = (FlowLayout) panelSuperior.getLayout();
		fl_panelSuperior.setAlignOnBaseline(true);
		add(panelSuperior, BorderLayout.NORTH);
		
		JLabel labelSistema = new JLabel("SISTEMA DE INVENTARIO");
		labelSistema.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSistema.setHorizontalAlignment(SwingConstants.CENTER);
		panelSuperior.add(labelSistema);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(SystemColor.control);
		panelInferior.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		add(panelInferior, BorderLayout.SOUTH);
		
		JButton botonEntrar = new JButton("ENTRAR");
		botonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantallaUsuario();
			}
		});
		panelInferior.add(botonEntrar);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.WHITE);
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JLabel labelSistema2 = new JLabel("Inventario Seven56 SL.");
		labelSistema2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelSistema2.setHorizontalAlignment(SwingConstants.CENTER);
		labelSistema2.setBounds(82, 95, 276, 32);
		panelCentral.add(labelSistema2);
	}

}
