package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;

public class PantallaAñadir extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public PantallaAñadir() {
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
		
		JButton botonAñadir = new JButton("ADD PRODUCT");
		botonAñadir.setBackground(new Color(153, 0, 0));
		botonAñadir.setForeground(new Color(255, 255, 255));
		botonAñadir.setFont(new Font("Monospaced", Font.PLAIN, 10));
		panelInferiorAdd.add(botonAñadir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(35, 32, 78, 16);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(153, 0, 0));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField.setBounds(123, 32, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Code:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(35, 80, 78, 16);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(153, 0, 0));
		textField_1.setBounds(123, 80, 96, 19);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Type:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(153, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(229, 35, 78, 16);
		panel.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(153, 0, 0));
		textField_2.setBounds(318, 32, 96, 19);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Type:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1_2_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(229, 83, 78, 16);
		panel.add(lblNewLabel_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(153, 0, 0));
		textField_3.setBounds(318, 80, 96, 19);
		panel.add(textField_3);
	}
}
