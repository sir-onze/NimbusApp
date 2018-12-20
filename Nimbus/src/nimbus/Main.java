package nimbus;
import nimbus.interaction.InitialFrame;
import nimbus.business.*;


public class Main {
    
    public static void main(String[] args) {
        
        NimbusFacade nimbus = new NimbusFacade();
        InitialFrame init = new InitialFrame(nimbus);
        init.setVisible(true);
    }
}
