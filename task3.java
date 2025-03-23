
class SmartHomeSystem{
    String lightName;
    boolean isOn;
    int brightness;
    public SmartHomeSystem(){
        lightName="Living Room Light";
        isOn=false;
        brightness=0;
    }
    public SmartHomeSystem(String lightName){
        this.lightName=lightName;
        isOn=false;
        brightness=0;

    }
    public SmartHomeSystem(String lightName,boolean isOn,int brightness1){
        this.lightName=lightName;
        this.isOn=isOn;
        if(brightness1<=100 && brightness1>=0)
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
            System.out.println(lightName+" is now ON");
            System.out.println("Brightness Level: "+this.brightness);
        }
        else
            System.out.println(lightName+" is now OFF");
       }
}
public class task3 {
    public static void main(String[] abc){
        SmartHomeSystem livingRoomLight=new SmartHomeSystem();
        livingRoomLight.displayStatus();

        SmartHomeSystem livingRoomLight1=new SmartHomeSystem("living Room Light");
        livingRoomLight1.displayStatus();

        SmartHomeSystem livingRoomLight2=new SmartHomeSystem("Kitchen Light",true,75);
        livingRoomLight2.displayStatus();
    }
}
