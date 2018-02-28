import javax.swing.JOptionPane;

public class SunilsButton implements PushButton
{
    boolean Pressed = false;
    public static String q(String m) {
        String s = JOptionPane.showInputDialog(m);
        return s;
    }
    public void push() {
        Pressed = true;
        System.out.println("Let's play a game");
        String choice = q("Do you want to play a fun game? yes/no");
        if (choice.equals("yes")) {
            System.out.println("Great! Starting your quest now");
            System.out.println("Press the button again");
        } else {
            String choice2 = q("Are you sure? Its a very fun game yes/no");
            if (choice2.equals("yes")) {
                System.out.println("Starting fun game now");
                System.out.println("Press the button again");
            } else {
                System.out.println("Ok, starting the fun game anyway");
                System.out.println("Press the button again");
            }
        }
    }
    public String buttonState() {
        if (Pressed == false) {
            return "Press the button to play the fun game";
        }  else {
            return "congratulations on pressing the best button ever";
        }
    }
}
