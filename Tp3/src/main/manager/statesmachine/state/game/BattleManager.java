/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JTextField;
import main.manager.Constants;
import main.manager.statesmachine.GameState;
import main.manager.tools.ResourceLoader;
import main.manager.user_interface.Hud;

/**
 *
 * @author Agus_
 */
public class BattleManager implements GameState{
    
    private Hud hud;
    private BufferedImage batalla;
    private BufferedImage gnomo;
    private BufferedImage elfo;
    private BufferedImage humano;
    private BufferedImage enano;
    private BufferedImage gnomoE;
    private BufferedImage elfoE;
    private BufferedImage humanoE;
    private BufferedImage enanoE;
        
    
    public BattleManager(){
        batalla = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_BATALLA);
        gnomo = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_GNOMO);
        elfo = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ELFO);
        humano = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_HUMANO);
        enano = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ENANO);
        gnomoE = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_GNOMOE);
        elfoE = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ELFOE);
        humanoE = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_HUMANOE);
        enanoE = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ENANOE);
    }

    @Override
    public void refresh() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(batalla,0,0,null);
        drawCharacter(g);
        g.setColor(Color.RED);
        
        
        
        g.drawString("PANTALLA DE COMBATE - PROXIMAMENTE",340,480); //Hay que ver como generar una consola scroll
        
        
        
        
    }
    
    public void drawCharacter(Graphics g){
        switch(Constants.SELECTED_CHARACTER){
            case 1:
                g.drawImage(elfo, 50, 30, null);
                if(Constants.ACTUAL_MAP != 2){
                    drawEnemy(g);                
                }else{
                    drawEnemy2(g);
                }
                break;
            case 2:
                g.drawImage(gnomo, 0, 90, null);
                if(Constants.ACTUAL_MAP != 2){
                    drawEnemy(g);                
                }else{
                    drawEnemy2(g);
                }
                break;
            case 3:
                g.drawImage(humano, 0, 40, null);
                if(Constants.ACTUAL_MAP != 2){
                    drawEnemy(g);                
                }else{
                    drawEnemy2(g);
                }
                break;
            case 4:
                g.drawImage(enano, 10, 160, null);
                if(Constants.ACTUAL_MAP != 2){
                    drawEnemy(g);                
                }else{
                    drawEnemy2(g);
                }
                break;
            default:
                break;
        }
    }
    
    private void drawEnemy(Graphics g){
        switch (Constants.ACTUAL_ENEMY_ZONE) {
            case 0:
                g.drawImage(humanoE, 600, 40, null);
                break;
            case 1:
                g.drawImage(enanoE, 500, 150, null);
                break;
            case 2:
                g.drawImage(elfoE, 550, 40, null);
                break;
            default:
                break;
        }
    }
    
    private void drawEnemy2(Graphics g){
        switch (Constants.ACTUAL_ENEMY_ZONE) {
            case 0:
                g.drawImage(elfoE, 550, 40, null);
                break;
            case 1:
                g.drawImage(gnomoE, 510, 90, null);
                break;
            default:
                break;
        }
    }

    public BufferedImage actualPlayer(){
        
        return null;
    }
    
}
