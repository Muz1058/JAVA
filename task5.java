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
    public void setBrightness(String brightness){
        if(brightness.equals("low")){
            this.brightness=25;
           System.out.println(this.lightName+" Brightness set to "+this.brightness+ " based on level:"+brightness);
        }
        else if(brightness.equals("medium")){
            this.brightness=50;
            System.out.println(this.lightName+" Brightness set to "+this.brightness+ " based on level:"+brightness);
        }
        else{
            this.brightness=75;
        System.out.println(this.lightName+" Brightness set to 75 based on level: high");
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
        System.out.println("light Name : "+ lightName);
        if(isOn) {
            System.out.println(lightName+" is now ON");
            System.out.println("Brightness Level: "+this.brightness);
        }
        else
            System.out.println(lightName+" is now OFF");
        System.out.println("light Colour : "+color);
    }

}


public class task5 {
    public static void main(String[] args) {
        SmartLight light=new SmartLight();
        light.turnOn();
        light.displayStatus();
        light.turnOff();
        light.displayStatus();
        light.setLightName("Kitchen light");
        light.setStatus(true);
        light.setBrightness(65);
        light.setColor("Green");
        light.displayStatus();
        light.setLightName("BedRoom Light");
        light.setStatus(true);
        light.setBrightness("low");
        light.setColor("Blue");
        light.displayStatus();
    }
}
