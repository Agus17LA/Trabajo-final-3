/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;

import base.Enemy;
import base.Game;
import base.Messages;
import base.Playable;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTextField;
import main.manager.Constants;
import main.manager.statesmachine.GameState;
import main.manager.statesmachine.StateManager;
import main.manager.tools.ResourceLoader;
import main.manager.user_interface.Hud;
import races.Dwarf;
import races.Elf;
import races.Gnome;
import races.Human;

/**
 *
 * @author Agus_
 */
public class BattleManager implements GameState{
    
    private Hud hud;
    private BufferedImage batalla;
    private BufferedImage gnomoBI;
    private BufferedImage elfoBI;
    private BufferedImage humanoBI;
    private BufferedImage enanoBI;
    private BufferedImage gnomoEBI;
    private BufferedImage elfoEBI;
    private BufferedImage humanoEBI;
    private BufferedImage enanoEBI;
    
    // He aqui la union
    
    Game game;
    
    
    public BattleManager(){
        batalla = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_BATALLA);
        gnomoBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_GNOMO);
        elfoBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ELFO);
        humanoBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_HUMANO);
        enanoBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ENANO);
        gnomoEBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_GNOMOE);
        elfoEBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ELFOE);
        humanoEBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_HUMANOE);
        enanoEBI = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_ENANOE);
        game = (Game) StateManager.state[3];
    }

    @Override
    public void refresh() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(batalla,0,0,null);
         //Hay que ver como generar una consola scroll
        drawCharacter(g);    
    }
    
    public void drawCharacter(Graphics g){
        switch(Constants.SELECTED_CHARACTER){
            case 1:
                g.drawImage(gnomoBI, 50, 30, null);
                if(Constants.ACTUAL_MAP != 2){
                    drawEnemy(g);
                }else{
                    drawEnemy2(g);
                }
                break;
            case 2:
                g.drawImage(humanoBI, 0, 90, null);
                if(Constants.ACTUAL_MAP != 2){
                    drawEnemy(g);
                }else{
                    drawEnemy2(g);
                }
                break;
            case 3:
                g.drawImage(elfoBI, 0, 40, null);
                if(Constants.ACTUAL_MAP != 2){
                    drawEnemy(g);    
                }else{
                    drawEnemy2(g);
                }
                break;
            case 4:
                g.drawImage(enanoBI, 10, 160, null);
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
                g.drawImage(humanoEBI, 600, 40, null);
                if(!Constants.EN_BATALLA){
                    game.startt();
                    Constants.EN_BATALLA = true;
                }
                break;
            case 1:
                g.drawImage(enanoEBI, 500, 150, null);
                if(!Constants.EN_BATALLA){
                    game.startt();
                    Constants.EN_BATALLA = true;
                }
                break;
            case 2:
                g.drawImage(elfoEBI, 550, 40, null);
                if(!Constants.EN_BATALLA){
                    game.startt();
                    Constants.EN_BATALLA = true;
                }
                break;
            default:
                break;
        }
    }
    
    private void drawEnemy2(Graphics g){
        switch (Constants.ACTUAL_ENEMY_ZONE) {
            case 0:
                g.drawImage(elfoEBI, 550, 40, null);
                if(!Constants.EN_BATALLA){
                    game.startt();
                    Constants.EN_BATALLA = true;
                }
                break;
            case 1:
                g.drawImage(gnomoEBI, 510, 90, null);
                if(!Constants.EN_BATALLA){
                    game.startt();
                    Constants.EN_BATALLA = true;
                }
                break;
            default:
                break;
        }
    }

}
