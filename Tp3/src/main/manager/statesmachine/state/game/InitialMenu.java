/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;

import base.Game;
import base.Playable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import json.JsonUtiles;
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
    private Rectangle exitGame;
    
    private Rectangle[] characters;
    
    private Point pMouse;
    private boolean screenSelection;
    private BufferedImage displayCharacter;
    private BufferedImage indexDisplay;
    private JsonUtiles json;
    
    
    public InitialMenu(){
        startNewGame = new Rectangle(Constants.WINDOW_CENTER_X-145,Constants.WINDOW_CENTER_Y-12 ,290,65);
        loadGame = new Rectangle(Constants.WINDOW_CENTER_X-145,Constants.WINDOW_CENTER_Y+80 ,290,65);
        exitGame = new Rectangle(Constants.WINDOW_CENTER_X-145,Constants.WINDOW_CENTER_Y+172 ,290,65);
        screenSelection = false;
        displayCharacter = ResourceLoader.loadCompatibleImageTranslucent("textures/personajesDisplay.png");
        indexDisplay = ResourceLoader.loadCompatibleImageTranslucent("textures/indexDisplay.png");
        characters = new Rectangle[4];
        for(int i =0;i<characters.length;i++){
            characters[i] = new Rectangle((190*i)+40,360,150,30); //Sucesion
        }
        json = new JsonUtiles();
    }
    

    @Override
    public void refresh() {
        pMouse = DrawSurface.mouse.getPosition();
        for(int i=0;i<characters.length;i++){
            if(rectangleClic(pMouse,characters[i])){
                Constants.SELECTED_CHARACTER = i+1;
                Constants.NEWGAME = true;
             }
        }
        if(rectangleClic(pMouse,loadGame) && !screenSelection){
            Game.player = json.readPlayer();
            Constants.LOADGAME = true;
            Constants.dead = !Game.player.isAlive();
            switch(Game.player.getName()){
                case "GNOMO":
                    Constants.SELECTED_CHARACTER = 1;
                    break;
                case "HUMANO":
                    Constants.SELECTED_CHARACTER = 2;
                    break;
                case "ELFO":
                    Constants.SELECTED_CHARACTER = 3;
                    break;
                case "ENANO":
                    Constants.SELECTED_CHARACTER = 4;
                    break;
            }
            Constants.NEWGAME = true;
        }
        if(rectangleClic(pMouse,startNewGame)){
            screenSelection = true;
        }
        
        if(rectangleClic(pMouse,exitGame)){
            System.exit(0);
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
            g.drawImage(displayCharacter,0,0,null);
        }else{
            g.drawImage(indexDisplay,0,0,null);
            g.setColor(Color.RED);
            g.drawRect(startNewGame.x, startNewGame.y, startNewGame.width, startNewGame.height);
            g.drawRect(loadGame.x, loadGame.y, loadGame.width, loadGame.height);      
            g.drawRect(exitGame.x, exitGame.y, exitGame.width, exitGame.height);   
        }
        
    }
    
}
