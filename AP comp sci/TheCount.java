public class TheCount
{
    private int number;
    
    public TheCount() {
        number = 15;
    }
    public String getNumber(){
        number++;
        return "" + (number-1) + "! A-HA-HA";
    }
    public void setNumber(int x) {
        number = x;
    }
}