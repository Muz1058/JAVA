package smartlightcontroller.com;
class SmartLight{
    private String lightName;
    private boolean isOn;
    private int brightness;
    private String color;
    public SmartLight(){
        lightName="Living Room Light";
        isOn=false;
        brightness=10;
        color="Red";
    }
    public void setLightName(String lightName){
        this.lightName=lightName;
    }
    public void setStatus(boolean isOn){
        this.isOn=isOn;
    }
    public void setBrightness(int brightness1){
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
    public void setColor(String color){
        this.color=color;
    }
    String getLightName(){
        return lightName;
    }
    boolean getStatus(){
        return isOn;
    }
    int getBrightness(){
        return brightness;
    }
    String getColor(){
        return color;
    }
    void turnOn(){
        this.isOn=true;
    }
    void turnOff(){
        this.isOn=false;
    }
    void displayStatus(){
        if(isOn) {
            System.out.println(lightName+" is now ON");
            System.out.println("Brightness Level: "+this.brightness);
        }
        else
            System.out.println(lightName+" is now OFF");
        System.out.println("light Colour : "+color);
    }

}


public class AdvancedSmartLightSystem {
    public static void main(String[] args) {
        SmartLight light=new SmartLight();
        light.turnOn();
        light.displayStatus();
        light.turnOff();
        light.displayStatus();
        light.setLightName("Kitchen light");
        light.setStatus(true);
        light.setBrightness(65);
        light.setColor("Blue");
        light.displayStatus();

    }
}
