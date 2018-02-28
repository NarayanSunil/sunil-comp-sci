
public class Troll
{
    double Imoney;
    static double Tmoney;
    public void collect(double x){
       Imoney = Imoney + x; 
       Tmoney = Tmoney + x;
    }
    public double myMoney() {
       return Imoney;      
    }
    public static double treasury(){
       return Tmoney;
    }
    public static void emptyTreasury(){
        Tmoney = 0;
    }
}
