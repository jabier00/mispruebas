#include <SPI.h>
#include <LiquidCrystal_I2C.h>
#include <MFRC522.h>

// Lectores RFID
#define N_Lectores      2 //Numero de lectores de tarjetas rfid, entrada 1 y salida 2
#define RST_PIN         9
#define SS_1_PIN        4
#define SS_2_PIN        5
#define SS_3_PIN        6
#define SS_4_PIN        7
byte ssPins[] = {SS_1_PIN, SS_2_PIN, SS_3_PIN, SS_4_PIN};
MFRC522 rfid[N_Lectores];
LiquidCrystal_I2C lcd(0x3F, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE);  // Set the LCD I2C address

//Constantes para los accesos
const byte N_Accesos = 2; 
const int PinPermiLed[N_Accesos] = { 36, 34 }; //luces de permitido se pueden poner otros actuadores
const int PinDeniLed[N_Accesos] = { 37, 35 };  //luces de denegado se pueden poner otros actuadores

void setup() {
  Serial.begin(9600);

  // Inicializa bus SPI
  SPI.begin();

  // Inicializa los lectores rfid que se van a usar
  for (uint8_t lector = 0; lector < N_Lectores; lector++) {
    rfid[lector].PCD_Init(ssPins[lector], RST_PIN);
  }
  lcd.begin(16,2);    //Inicializa el LCD (16,2) porque tiene 16 columnas y 2 filas
  lcd.backlight();   //iluminacion de fondo del display
  lcd.clear();       //Procedimiento borrado display
}


void loop() {
  
  // peticiones de entrada, solo si hay algo en el serial --> from java
  if (Serial.available() > 0) {
    ges_entrada();
  }
  
  // si hay tarjetas RFID en lectores, genera la salida para el serial --> to java
  lectores_rfid(); //lector entrada
  
  // Delay para no saturar los circuitos
  delay(50);
}


void ges_entrada () {
  // Lee la información entrante en el Serial e identifica donde van los mensajes y las actuaciones
  String input = Serial.readString();
    

  
		// Entrada Permitido en Acceso - 1 
  if (input.startsWith("Permite: 1")) {
		// quitamos "Permite: "
    input.remove(0, 9);
		// Conversion a entero, para referenciar el lector de Acceso
    int n_acceso = input.toInt();
		//Actuaciones sobre los led 
      digitalWrite(PinPermiLed[n_acceso], HIGH);
      digitalWrite(PinDeniLed[n_acceso], LOW);
		//Puede haber más actuaciones
		// escribimos en pantalla 
      lcd.clear(); 
      lcd.setCursor(0,0);
      lcd.print("Usuario");
      lcd.setCursor(0,1);
      lcd.print("Reconocido");
      
		// escribimos en el serial la vuelta
	  Serial.print("Reconocido: 1");
    }
		// Entrada Denegada en un Acceso - 1
    else if (input.startsWith("Deniega: 1")) {
		// quitamos  "Deniega: "
    input.remove(0, 9);
		// Conversion a entero, para referenciar el lector de Acceso
    int n_acceso = input.toInt();
      digitalWrite(PinDeniLed[n_acceso], HIGH);
		// Desactivamos el Permit del mismo acceso, por si esta activo
      digitalWrite(PinPermiLed[n_acceso], LOW);
      
		// escribimos en pantalla 
      lcd.clear(); 
      lcd.setCursor(0,0);
      lcd.print("Usuario");
      lcd.setCursor(0,1);
      lcd.print("Denegado");
	  
		// escribimos en el serial la vuelta
      Serial.print("Denegado: 1");
    }

 		// Entrada Permitido en Acceso - 2 
  if (input.startsWith("Permite: 2")) {
		// quitamos "Permite: "
    input.remove(0, 9);
		// Conversion a entero, para referenciar el lector de Acceso
    int n_acceso = input.toInt();
		//Actuaciones sobre los led 
      digitalWrite(PinPermiLed[n_acceso], HIGH);
      digitalWrite(PinDeniLed[n_acceso], LOW);
		
		// escribimos en pantalla 
      lcd.clear(); 
      lcd.setCursor(0,0);
      lcd.print("Usuario");
      lcd.setCursor(0,1);
      lcd.print("Reconocido");
      
		// escribimos en el serial la vuelta
	  Serial.print("Reconocido: 2");
    }
		// Entrada Denegada en un Acceso - 2
    else if (input.startsWith("Deniega: 2")) {
		// quitamos  "Deniega: "
    input.remove(0, 9);
		// Conversion a entero, para referenciar el lector de Acceso
    int n_acceso = input.toInt();
      digitalWrite(PinDeniLed[n_acceso], HIGH);
		// Desactivamos el Permit del mismo acceso, por si esta activo
      digitalWrite(PinPermiLed[n_acceso], LOW);
      
		// escribimos en pantalla 
      lcd.clear(); 
      lcd.setCursor(0,0);
      lcd.print("Usuario");
      lcd.setCursor(0,1);
      lcd.print("Denegado");
	  //Puede haber más actuaciones
		// escribimos en el serial la vuelta
      Serial.print("Denegado: 2");
    }

}

void lectores_rfid() {
// Recorre los lectores Entrada y salida
  for (uint8_t lector = 0; lector < N_Lectores; lector++) {
    // cuando reconoce la tarjeta en el lector si la ha leido
    if (rfid[lector].PICC_IsNewCardPresent() && rfid[lector].PICC_ReadCardSerial()) {
      // Hay tarjeta. Hacer salida por serie
      Serial.print(F("RFID: "));
      Serial.print(lector);
      Serial.print(F(". UID: "));
      for (byte i = 0; i < rfid[lector].uid.size; i++) {
        Serial.print(rfid[lector].uid.uidByte[i] < 0x10 ? "0" : "");
        Serial.print(rfid[lector].uid.uidByte[i], HEX);
      }
      Serial.println();

      rfid[lector].PICC_HaltA();
    }
  }
}
