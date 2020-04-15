package Controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Globales;
import Modelo.VentanaPrincipal_modelo;
import Vista.VentanaPrincipal_vista;

public class VentanaPrincipal_controller {
	
	private VentanaPrincipal_modelo modelo;
	private VentanaPrincipal_vista vista;

	public VentanaPrincipal_controller(VentanaPrincipal_modelo modelo, VentanaPrincipal_vista vista) {
		this.modelo=modelo;
		this.vista=vista;
						
		this.vista.menu_opcion_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Menú pulsado");
				Globales.myAlert("Pulsado ok");
				
			}
			
		});
	}
	
}
