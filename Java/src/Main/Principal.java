package Main;

//import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Modelo.*;
import Vista.*;
import Controlador.*;

public class Principal {
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {

		try {

			Globales.myAlert("hola!!");

			ArrayList<Map<String, Object>> queryResult = new ArrayList<Map<String, Object>>();

			SQL_conexion conexSQL = new SQL_conexion();
			conexSQL.setQuery("select * from products");

			queryResult = conexSQL.getSelectData();

			List<Coche> ListaCoches = new ArrayList<Coche>();

			for (Map<String, Object> filamap : queryResult) {
				String id = Globales.valueToStringOrEmpty(filamap, "productCode").toString();
				String modelo = Globales.valueToStringOrEmpty(filamap, "productName").toString();
				int stock = filamap.get("quantityInStock") == null ? 0 : (int) filamap.get("quantityInStock");
				Coche micoche = new Coche(id, modelo, stock);
				ListaCoches.add(micoche);
			}

			for (Coche c : ListaCoches) {
				System.out.println(c.get_id() + "\t" + c.get_modelo());
			}
			
			Globales.myAlert("ventana!!");			
			
			VentanaPrincipal_modelo window_modelo = new VentanaPrincipal_modelo();
			VentanaPrincipal_vista  window_vista = new VentanaPrincipal_vista(window_modelo);
			VentanaPrincipal_controller window_controller = new VentanaPrincipal_controller(window_modelo, window_vista);
			
			window_vista.frame.setVisible(true);
			
			
		} catch (Exception e) {
			System.out.println("Error no controlado: " + e.toString());
		}
		
		
	}
}
