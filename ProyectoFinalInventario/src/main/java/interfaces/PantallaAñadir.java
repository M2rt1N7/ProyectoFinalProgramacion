package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PantallaAñadir extends JPanel {
	public PantallaAñadir() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorAdd = new JPanel();
		panelSuperiorAdd.setBackground(new Color(153, 0, 0));
		add(panelSuperiorAdd, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ADD PRODUCT");
		lblNewLabel.setBackground(new Color(204, 204, 204));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 10));
		panelSuperiorAdd.add(lblNewLabel);
		
		JPanel panelInferiorAdd = new JPanel();
		panelInferiorAdd.setBackground(new Color(153, 0, 0));
		add(panelInferiorAdd, BorderLayout.SOUTH);
		
		JButton botonAñadir = new JButton("ADD");
		botonAñadir.setBackground(new Color(255, 255, 255));
		botonAñadir.setForeground(new Color(255, 255, 255));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		panelInferiorAdd.add(botonAñadir);
	}

	
}
