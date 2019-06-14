/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.control;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.manager.Constants;

/**
 *
 * @author Agus_
 */
public class Keyboard implements KeyListener {
    private final int numberKeys=  256;
    private final boolean[] keys = new boolean[numberKeys];
    
    public Key up= new Key();
    public Key down=new Key();
    public Key left=new Key();
    public Key right=new Key(); //Los atributos se quedan como publicos debido a que estos datos deberan ser accedidos de manera extremadamente continua y tienen que estar lo más libres de acceso posible para que no haya retrasos a la hora de modificarlos
    public boolean run = false;
    public boolean menu = false;
    public boolean combate = false;
    public static boolean hud = false;
    public Key exit=new Key();
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                up.keyPressed();
                break;
            case KeyEvent.VK_S:
                down.keyPressed();  
                break;
            case KeyEvent.VK_A:
                left.keyPressed();
                break;
            case KeyEvent.VK_D:
                right.keyPressed();
                break;
            case KeyEvent.VK_SHIFT:
                run = true;
                break;
            case KeyEvent.VK_ESCAPE:
                exit.keyPressed();
                break;
            case KeyEvent.VK_I:
                menu = !menu;
                break;
            case KeyEvent.VK_ENTER:
                if(Constants.BATTLE){
                    combate = !combate;
                }
                break;
            case KeyEvent.VK_F3:
                hud = !hud;
                break;
        }
    }

    @Override   
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                up.keyFree();
                break;
            case KeyEvent.VK_S:
                down.keyFree();  
                break;
            case KeyEvent.VK_A:
                left.keyFree();
                break;
            case KeyEvent.VK_D:
                right.keyFree();
                break;
            case KeyEvent.VK_SHIFT:
                run = false;
                break;
            case KeyEvent.VK_ESCAPE:
                exit.keyFree();
                break;
        }
    }
    
}
