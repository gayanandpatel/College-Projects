#include <LiquidCrystal_I2C.h>

#include <Wire.h>
#include <LiquidCrystal_I2C.h>
#include <DHT.h>

// Define the pins for the DHT11 sensor, ldr and the relay module
#define DHTPIN 2
#define RELAY_PIN1 1
#define RELAY_PIN2 3
#define MOISTURE_PIN A0
#define LDR_PIN 5

// Define the type of DHT sensor
#define DHTTYPE DHT11

//pin for ldr module sensor
int LDRSensor = 5;

// Create the DHT object
DHT dht(DHTPIN, DHTTYPE);

// Create the LiquidCrystal object
LiquidCrystal_I2C lcd(0x27, 16, 2);


// Define the threshold temperature at which the fan should turn on
#define TEMP_THRESHOLD 25
#define SOIL_THRESHOLD 400

void setup() {
  
  // Initialize the DHT sensor and the relay module
  dht.begin();
  pinMode(RELAY_PIN1, OUTPUT);
  digitalWrite(RELAY_PIN1, HIGH);
  pinMode(RELAY_PIN2, OUTPUT);
  digitalWrite(RELAY_PIN2, HIGH);

  //Initialize ldr sensor
  pinMode (LDRSensor, INPUT);

  // Initialize the LCD screen
  lcd.init();
  lcd.backlight();
  lcd.clear();
   lcd.setCursor(0, 0);
  lcd.print("Greenhouse ctrl");
  lcd.setCursor(0, 1);
  lcd.print("& Monitor System");
  delay(5000);
  lcd.clear();
}

void loop() {
  // Read the temperature and humidity from the DHT sensor
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  // Read the moisture level from the soil moisture sensor
  int moisture = analogRead(MOISTURE_PIN);

  // read the analog value from the LDR module
  int Sensordata = digitalRead (LDRSensor);

  // Display the temperature and humidity on the LCD screen
  lcd.setCursor(0,0);
  lcd.print("Tempr:   ");
  lcd.setCursor(8, 0);
  lcd.print(temperature);
  lcd.print("'C");
  lcd.setCursor(0,1);
  lcd.print("Humidity:");
  lcd.setCursor(10, 1);
  lcd.print(humidity);
  lcd.print("%");
  delay(2000);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Moisture:");
  lcd.setCursor(10,0);  
  lcd.print(moisture);
  lcd.setCursor(0,1);
  lcd.print("Intensity:");
  lcd.setCursor(10,1);
  if (Sensordata == 0)
    lcd.print("Light");
  else
    lcd.print("Dark");
  delay(2000);
  lcd.clear();
  
  if (temperature >= TEMP_THRESHOLD) {
    lcd.setCursor(0,0);
    lcd.print("Fan ON");
  } else {
    lcd.setCursor(0,0);
    lcd.print("Fan OFF");
  }
   if (moisture >= SOIL_THRESHOLD) {
    lcd.setCursor(0,1);
    lcd.print("Pump ON");
  } else {
    lcd.setCursor(0,1);
    lcd.print("Pump OFF");
  }
  delay(2000);  

  // Turn on the fan if the temperature is above the threshold
  if (temperature >= TEMP_THRESHOLD) {
    digitalWrite(RELAY_PIN1, LOW);
  } else {
    digitalWrite(RELAY_PIN1, HIGH);
    
  }
   if (moisture >= SOIL_THRESHOLD) {
    digitalWrite(RELAY_PIN2, LOW);
  } else {
    digitalWrite(RELAY_PIN2, HIGH);
  }

  delay(2000);
}
