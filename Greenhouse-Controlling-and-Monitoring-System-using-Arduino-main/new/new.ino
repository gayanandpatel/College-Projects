/* interfacing LDR sensor with Arduino | LDR Sensor Arduino Code for Digital Output
www.electroduino.com */

// Declare your LDR sensor out pin connected Arduino pin “D3” 
 int LDRSensor = 2;

void setup()
 {
  //Initialize Sensor (pin3) as an INPUT.
  pinMode (LDRSensor, INPUT);
  //Define baud rate for serial communication
  Serial.begin (9600);
 }
 
void loop()
 {
  //Read Digital output value from sensor using digitalRead()function
  int Sensordata = digitalRead (LDRSensor);
  //Print the sensor value on your serial monitor window
  Serial.print("Sensor value:");
  if (Sensordata == 0)
    Serial.println("Light");
  else
    Serial.println("Dark");
  //Delay for 1 second to get clear output on the serial monitor
  delay(1000);
 }