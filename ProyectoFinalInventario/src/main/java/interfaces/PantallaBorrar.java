package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PantallaBorrar extends JPanel {
	public PantallaBorrar() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorBor = new JPanel();
		add(panelSuperiorBor, BorderLayout.NORTH);
		
		JPanel panelInferiorBor = new JPanel();
		add(panelInferiorBor, BorderLayout.SOUTH);
		
		JPanel panelCentralBo = new JPanel();
		add(panelCentralBo, BorderLayout.CENTER);
		panelCentralBo.setLayout(null);
	}
}
