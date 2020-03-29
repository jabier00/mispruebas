package Main;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Arduino_conector {

	// Se crea una instancia de la librería PanamaHitek_Arduino
	private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	private static final SerialPortEventListener listener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent spe) {
			try {
				if (ino.isMessageAvailable()) {
					// Se imprime el mensaje recibido en la consola
					System.out.println(ino.printMessage());
				}
			} catch (SerialPortException | ArduinoException ex) {
				Logger.getLogger(Arduino_conector.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	};

	// listener para el arduino
	public static void arduino_initCOM_Send() {
		try {
			ino.arduinoRXTX("COM4", 9600, listener); // se inicia comunicación con el puerto serie
		} catch (ArduinoException ex) {
			Logger.getLogger(Arduino_conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// listener para el arduino
	public static void arduino_initCOM_Receipt() {
		try {
			ino.arduinoRX("COM3", 9600, listener); // se inicia comunicación con el puerto serie
		} catch (ArduinoException | SerialPortException ex) {
			Logger.getLogger(Arduino_conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// stop listener del arduino
	public static void arduino_closeCOM() {
		try {
			// puerto serie
			ino.killArduinoConnection();
		} catch (ArduinoException ex) {
			Logger.getLogger(Arduino_conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// enciende led
	public static void encender_Arduino() {
		// se hace el envío del string "1"
		try {
			ino.sendData("1");
		} catch (ArduinoException | SerialPortException ex) {
			Logger.getLogger(Arduino_conector.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	// apaga led
	public static void apagar_Arduino() {
		// se hace el envío del string "0"
		try {
			ino.sendData("0");
		} catch (ArduinoException | SerialPortException ex) {
			Logger.getLogger(Arduino_conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
