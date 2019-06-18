/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
        
        g.setColor(Color.RED);
        g.drawString("PANTALLA DE COMBATE - PROXIMAMENTE",340,480);
    }
    
    public BufferedImage actualPlayer(){
        
        return null;
    }
    
}
