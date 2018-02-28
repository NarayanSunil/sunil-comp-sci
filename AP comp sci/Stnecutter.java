public class Stnecutter {
    static int numberOfMembers;
    int myNumber;
    
    public static int getMembers () {
        return numberOfMembers;
    }
    
    public int getNumber() {
        numberOfMembers = 0;
        return myNumber;
    }
}