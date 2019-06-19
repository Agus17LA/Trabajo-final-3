/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.manager.Constants;
import main.manager.control.ControlManager;
import main.manager.control.Keyboard;
import main.manager.control.Mouse;
import main.manager.graphics.DrawSurface;
import main.manager.statesmachine.GameState;
import main.manager.statesmachine.StateManager;
import main.manager.tools.ResourceLoader;
import main.manager.user_interface.Hud;

/**
 *
 * @author Agus_
 */
public class InitialMenu implements GameState{

    
    private Rectangle startNewGame;
    private Rectangle loadGame;
    
    private Rectangle[] characters;
    
    private Point pMouse;
    private boolean screenSelection;
    private BufferedImage layout;
    
    
    public InitialMenu(){
        startNewGame = new Rectangle(Constants.WINDOW_CENTER_X-75,Constants.WINDOW_CENTER_Y + 150,150,20);
        loadGame = new Rectangle(Constants.WINDOW_CENTER_X-75,Constants.WINDOW_CENTER_Y+ 200,150,20);
        screenSelection = false;
        layout = ResourceLoader.loadCompatibleImageTranslucent("textures/borde.png");
        characters = new Rectangle[4];
        for(int i =0;i<characters.length;i++){
            characters[i] = new Rectangle((150*i)+155,200,40,200); //Sucesion
        }
    }
    

    @Override
    public void refresh() {
        pMouse = DrawSurface.mouse.getPosition();
        for(int i=0;i<characters.length;i++){
            if(rectangleClic(pMouse,characters[i])){
                Constants.SELECTED_CHARACTER = i+1;
                ControlManager.keyboard.prsnj1 = false;
                Constants.NEWGAME = true;
             }
        }
        if(rectangleClic(pMouse,loadGame))
            System.out.println("clicLoad");
        if(rectangleClic(pMouse,startNewGame)){
            screenSelection = true;
        }
        DrawSurface.mouse.restartClick();
    }
    
    public boolean rectangleClic(Point pMouse,Rectangle aux){
        boolean clic = false;
        if(aux.intersects(pMouse.getX(),pMouse.getY(),1,1)){
            clic = DrawSurface.mouse.getClick();
        }
        return clic;
    }
    
    @Override
    public void draw(Graphics g) {
        if(screenSelection){
            g.setColor(Color.red);
            for(int i=0;i<characters.length;i++){
                g.fillRect(characters[i].x,characters[i].y,characters[i].width,characters[i].height);
                switch(i){
                    case 0:
                        g.drawString("Elfo", characters[i].x, characters[i].height+215);
                        break;
                    case 1:
                        g.drawString("Gnomo", characters[i].x, characters[i].height+215);
                        break;
                    case 2:
                        g.drawString("Humano", characters[i].x, characters[i].height+215);
                        break;
                    case 3:
                        g.drawString("Enano", characters[i].x, characters[i].height+215);
                        break;
                }
            }
            
            g.drawImage(layout,0,0,null);
            
        }else{
            g.setColor(Color.RED);
            g.drawString("Acá iniciaria una nueva partida o se cargará una", 400, 300);
            g.drawString("Ingrese un numero del 1 al 4 para elegir a su personaje",400,350);
            g.drawString("y pulse N para comenzar", 400, 370);
            g.fillRect(startNewGame.x, startNewGame.y, startNewGame.width, startNewGame.height);
            g.fillRect(loadGame.x, loadGame.y, loadGame.width, loadGame.height);            
        }
        
    }
    
}
