class SmartLight{
    String lightName;
    boolean isOn;
    int brightness;
    public SmartLight(){
        lightName="Living Room Light";
        isOn=false;
        brightness=0;
    }
        void turnOn(){
        isOn=true;
    }
    void turnOff(){
        isOn=false;
    }
    void setBrightness(int brightness1){
        if(brightness1<=100&&brightness1>=0)
        {
            this.brightness=brightness1;
        }
        else if(brightness1<0)
        {
            this.brightness=0;
        }
        else{
            this.brightness=100;
        }

      }
    void displayStatus(){
        if(isOn) {
            System.out.println("Living Room Light is now ON");
            System.out.println("Brightness Level: "+this.brightness);
        }
        else
            System.out.println("Living Room Light is now OFF");

    }
}
public class task1 {
    public static void main(String[] abc){
        SmartLight livingRoomLight=new SmartLight();
        livingRoomLight.displayStatus();
        livingRoomLight.turnOn();
        livingRoomLight.setBrightness(75);
        livingRoomLight.displayStatus();
        livingRoomLight.turnOff();
        livingRoomLight.displayStatus();
    }
}
