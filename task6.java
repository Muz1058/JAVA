class SmartLight{
    private String lightName;
    private boolean isOn;
    private int brightness;
    public SmartLight(){
        lightName="Living Room Light";
        isOn=false;
        brightness=75;
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
    public void setBrightness(String brightness){
        if(brightness.equals("low")){
            this.brightness=25;
            System.out.println("Brightness set to "+this.brightness+ " based on level:"+brightness);
        }
        else if(brightness.equals("medium")){
            this.brightness=50;
            System.out.println("Brightness set to "+this.brightness+ " based on level:"+brightness);
        }
        else{
            this.brightness=75;
            System.out.println("Brightness set to 75 based on level: high");
        }

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
    void turnOn(){
        this.isOn=true;
        this.brightness=75;
        System.out.println(this.lightName+" is now ON");
        System.out.println("Brightness set to "+this.brightness);
    }
    void turnOff(){
        this.isOn=false;
        System.out.println(this.lightName+" is now OFF");
    }
    void displayStatus(){
        if(isOn) {
            System.out.println(lightName+" is ON with Brightness level : "+ this.brightness);
        }
        else
            System.out.println(lightName+" is OFF with Brightness level : "+ this.brightness);
    }
public class task6 {
    public static void main(String[] args) {
        SmartLight light=new SmartLight();
        light.turnOn();
        light.displayStatus();
        light.turnOff();
        light.displayStatus();
        light.setLightName("Default light");
        light.setBrightness(0);
        light.setStatus(false);
        light.displayStatus();
        light.setLightName("Kitchen light");
        light.setStatus(false);
        light.setBrightness(0);
        light.displayStatus();
        light.setLightName("BedRoom Light");
        light.setStatus(true);
        light.setBrightness(50);
        light.displayStatus();
        light.setLightName("Living Room Light");
        light.setStatus(true);
        light.setBrightness("medium");
        light.displayStatus();
    }
}
