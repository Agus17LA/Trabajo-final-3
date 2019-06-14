/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.control;
/**
 *
 * @author Agus_
 */
public class Key {
    private boolean pressed = false;
    private long lastPress = System.nanoTime();
    
    public void keyPressed(){
        pressed = true;
        lastPress = System.nanoTime();
    }
    public void keyFree(){
        pressed = false;
    }

    public boolean isPressed() {
        return pressed;
    }

    public long getLastPress() {
        return lastPress;
    }
    
    
    
}
