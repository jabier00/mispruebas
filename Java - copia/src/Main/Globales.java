package Main;

import java.util.Map;

import javax.swing.JOptionPane;

public class Globales {	

		
	/*===============================
	 * Alert 1 argumento
	 *===============================*/
	public static void myAlert(String mensaje) {		
		JOptionPane.showMessageDialog(null, mensaje, "Atención", JOptionPane.WARNING_MESSAGE);		
	}	
	
	/**
	 * devuelve en string el valor de un map, si es nulo devuelve cadena vacía
	 * @param map
	 * @param key
	 * @return string 
	 */	
	public static String valueToStringOrEmpty(Map<String, ?> map, String key) {
	    Object value = map.get(key);
	    return value == null ? "" : value.toString();
	}
	/**
	 * devuelve en int el valor de un map, si es nulo devuelve 0
	 * @param map
	 * @param key
	 * @return
	 */
	public static int valueToIntOrEmpty(Map<String, ?> map, String key) {
	    Object value = map.get(key);
	    return value == null ? 0 : (int)value;	    
	}

}
