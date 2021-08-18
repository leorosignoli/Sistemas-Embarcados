const int ldr = 0; 
const int buz = 8;
int vallido = 0;
int pvm = 200;
int c = 0;
const int led = 7;

void setup(){
  
  pinMode(led, OUTPUT);
  pinMode(buz, OUTPUT);
  Serial.begin(9600);
  
}

void loop(){
  
  vallido= analogRead(ldr);
  Serial.println(vallido);
  tone(23,200,500);
  if (vallido<700){
   
    analogWrite(buz, pvm);
  }
  else{
    digitalWrite(buz,LOW);
  }   
  
  digitalWrite(led,LOW);
  if (c%2==0){
   digitalWrite(led,HIGH); 
  }
  c++;
  delay(500);
}