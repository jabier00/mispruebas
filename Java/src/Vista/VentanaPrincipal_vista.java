package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Modelo.VentanaPrincipal_modelo;

public class VentanaPrincipal_vista {
	
	VentanaPrincipal_modelo modelo;
	
	public JFrame frame;		
	public JMenuItem menu_opcion_1;

	/**
	 * Create the application.
	 */
	public VentanaPrincipal_vista() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public VentanaPrincipal_vista(VentanaPrincipal_modelo m) {
		this.modelo = m;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu_opcion_1 = new JMenuItem("Pulsar");
		menuBar.add(menu_opcion_1);
	}

}
