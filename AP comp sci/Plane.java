
/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane
{
    protected double wingspan;
    protected String name;
    protected double speed;
    
    public Plane(){
        wingspan = 2.5;
        name = "bob";
        speed = 220.4;
    }
    public double getWingspan() {return wingspan;}
    public void setWingspan(double n) {wingspan = n;}
    public String getName() {return name;}
    public void setName(String n) {name = n;}  
}
