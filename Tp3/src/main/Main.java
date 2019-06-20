package main;
import main.manager.Constants;
import main.manager.PrincipalManager;
public class Main {
    public static void main(String[] args) {
        PrincipalManager pm = new PrincipalManager("jueguito", Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        pm.startGame();
        pm.startPrincipalLoop();
    }
}
