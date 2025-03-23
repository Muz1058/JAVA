class SmartHomeSystem{
    String lightName;
    boolean isOn;
    int brightness;
    public SmartHomeSystem(){
        lightName="Living Room Light";
        isOn=false;
        brightness=0;
    }
//    public SmartHomeSystem(String name,boolean isOn,int brightness1){
//        this.lightName=name;
//        this.isOn=isOn;
//        if(brightness1<=100 && brightness1>=0)
//        {
//            this.brightness=brightness1;
//        }
//        else if(brightness1<0)
//        {
//            this.brightness=0;
//        }
//        else{
//            this.brightness=100;
//        }
//    }

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
public class task2 {
    public static void main(String[] abc){
        SmartHomeSystem livingRoomLight=new SmartHomeSystem();
        livingRoomLight.displayStatus();
         livingRoomLight.turnOn();
         livingRoomLight.setBrightness(75);
     //   SmartHomeSystem livingRoomLight1=new SmartHomeSystem("living Room Light");
        livingRoomLight.displayStatus();
      livingRoomLight.turnOff();
     //   SmartHomeSystem livingRoomLight2=new SmartHomeSystem("living Room Light",true,75);
        livingRoomLight.displayStatus();
    }
}
