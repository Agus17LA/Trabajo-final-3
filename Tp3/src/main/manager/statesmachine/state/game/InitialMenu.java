/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;

import java.awt.Color;
import java.awt.Graphics;
import main.manager.Constants;
import main.manager.control.ControlManager;
import main.manager.control.Keyboard;
import main.manager.statesmachine.GameState;
import main.manager.statesmachine.StateManager;

/**
 *
 * @author Agus_
 */
public class InitialMenu implements GameState{

    public InitialMenu(){

    }
    

    @Override
    public void refresh() {
        if(ControlManager.keyboard.prsnj1){
            Constants.SELECTED_CHARACTER = 1;
            ControlManager.keyboard.prsnj1 = false;
        }else if(ControlManager.keyboard.prsnj2){
            Constants.SELECTED_CHARACTER = 2;
            ControlManager.keyboard.prsnj2 = false;
        }else if(ControlManager.keyboard.prsnj3){
            Constants.SELECTED_CHARACTER = 3;
            ControlManager.keyboard.prsnj3 = false;
        }else if(ControlManager.keyboard.prsnj4){
            Constants.SELECTED_CHARACTER = 4;
            ControlManager.keyboard.prsnj4 = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Acá iniciaria una nueva partida o se cargará una", 400, 300);
        g.drawString("Ingrese un numero del 1 al 4 para elegir a su personaje",400,350);
        g.drawString("y pulse N para comenzar", 400, 370);
    }
    
}
