package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PantallaBorrar extends JPanel {
	public PantallaBorrar() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorBor = new JPanel();
		panelSuperiorBor.setBackground(new Color(153, 0, 0));
		add(panelSuperiorBor, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("AMMU-NATION INVENTORY S.A.");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelSuperiorBor.add(lblNewLabel);
		
		JPanel panelInferiorBor = new JPanel();
		panelInferiorBor.setBackground(new Color(153, 0, 0));
		add(panelInferiorBor, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("DELETE PRODUCT");
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 10));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 0, 0));
		panelInferiorBor.add(btnNewButton);
		
		JPanel panelCentralBo = new JPanel();
		panelCentralBo.setBackground(new Color(255, 255, 255));
		add(panelCentralBo, BorderLayout.CENTER);
		panelCentralBo.setLayout(null);
	}
}
