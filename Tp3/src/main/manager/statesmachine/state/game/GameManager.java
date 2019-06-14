/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import main.manager.Constants;
import main.manager.control.ControlManager;
import main.manager.entities.Player;
import main.manager.graphics.DrawSurface;
import main.manager.maps.Map;
import main.manager.statesmachine.GameState;
import main.manager.statesmachine.StateManager;
import main.manager.tools.ResourceLoader;
import main.manager.user_interface.Hud;
/**
 *
 * @author Agus_
 */
public class GameManager implements GameState{
    Map map;
    Player player;
    BufferedImage layout; //borde estetico del juego
    Point p;
    String typeOfPlayer;
    Hud hud;
    
    
    
    public GameManager(String typeOfPlayer){
        this.p = DrawSurface.mouse.getPosition();
        this.typeOfPlayer = typeOfPlayer;
        startMap(Constants.RUTA_MAP);
        startPlayer(map,typeOfPlayer);
        hud = new Hud(player);
        layout = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_LAYOUT);
        
    }
    
    private void refreshGame(){
        final String rute = "resources/text/"+map.getNextMap();
        startMap(rute);
        player.setMap(map);
        player.setPositionX(map.getInitialPosition().getX());
        player.setPositionY(map.getInitialPosition().getY());
    }
    
    private void startMap(final String rute){
        map = new Map(rute);
    }
    
    private void startPlayer(final Map map,final String rute){
        player = new Player(map,rute);
    }
    
    public void refresh(){
        if(player.getLEFT_COLLISION().intersects(map.getExitZone())){
            refreshGame();
        }
        if(player.getLEFT_COLLISION().intersects(map.getEnemyZone1()) || player.getLEFT_COLLISION().intersects(map.getEnemyZone2()) || player.getLEFT_COLLISION().intersects(map.getEnemyZone3())){
            Constants.BATTLE = true;
        }else{
            Constants.BATTLE = false;
        }
        
        player.refresh();
        map.refresh((int)player.getPositionX(),(int)player.getPositionY());
    }
    public void draw(Graphics g){
        map.draw(g,(int)player.getPositionX(),(int)player.getPositionY());
        player.draw(g);
        //Hud.drawLayout(g,layout);
        g.setColor(Color.red);
        g.drawRect((int)map.getEnemyZone1().getX(), (int)map.getEnemyZone1().getY(), (int)map.getEnemyZone1().getWidth(), (int)map.getEnemyZone1().getHeight());
        g.drawRect((int)map.getEnemyZone2().getX(), (int)map.getEnemyZone2().getY(), (int)map.getEnemyZone2().getWidth(), (int)map.getEnemyZone2().getHeight());
        g.drawRect((int)map.getEnemyZone3().getX(), (int)map.getEnemyZone3().getY(), (int)map.getEnemyZone3().getWidth(), (int)map.getEnemyZone3().getHeight());
        g.setColor(Color.green);
        g.drawRect((int)map.getExitZone().getX(), (int)map.getExitZone().getY(), (int)map.getExitZone().getWidth(), (int)map.getExitZone().getHeight());
        hud.drawBar(g, player);
        Hud.drawMousePosition(g, p);
        Hud.drawXY(g, player);
        Hud.drawResistance(g, player.resistance);
        Hud.drawLife(g, 1000);
        Hud.drawMana(g, 1000);
        if(player.getLEFT_COLLISION().intersects(map.getEnemyZone1()) || player.getLEFT_COLLISION().intersects(map.getEnemyZone2()) || player.getLEFT_COLLISION().intersects(map.getEnemyZone3())){
            Hud.drawMessage(g);
        }
        //Hud.drawMessage(g);
        //g.drawString("Next map: "+map.getNextMap(),380,580);
        
    }
}
