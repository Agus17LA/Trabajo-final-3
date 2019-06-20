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
import main.manager.entities.Enemy;
import main.manager.entities.Player;
import main.manager.entities.Priest;
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
    Enemy enemy;
    Priest priest;
    private boolean refresh = false;
    
    
    
    public GameManager(){
        this.p = DrawSurface.mouse.getPosition();
        loadRuteCharacter();
        startMap(Constants.RUTA_MAP);
        enemy = new Enemy(map);
        priest = new Priest(map);
        hud = new Hud(player);
        layout = ResourceLoader.loadCompatibleImageTranslucent(Constants.RUTA_LAYOUT);
        
    }
    
    public void loadRuteCharacter(){
        switch(Constants.SELECTED_CHARACTER){
            case 1:
                typeOfPlayer = Constants.RUTA_MAGOGNOMO;
                break;
            case 2:
                typeOfPlayer = Constants.RUTA_GUERREROHUMANO;
                break;
            case 3:
                typeOfPlayer = Constants.RUTA_MAGOELFO;
                break;
            case 4:
                typeOfPlayer = Constants.RUTA_GUERREROENANO;
                break;
            default:
                break;
        }
    }
    
    private void refreshGame(){
        final String rute = "resources/text/"+map.getNextMap();
        startMap(rute);
        player.setMap(map);
        player.setPositionX(map.getInitialPosition().getX());
        player.setPositionY(map.getInitialPosition().getY());
        enemy = new Enemy(map);
        priest = new Priest(map);
    }
    
    private void startMap(final String rute){
        map = new Map(rute);
    }
    
    private void startPlayer(final Map map,final String rute){
        player = new Player(map,rute);
    }
    
    @Override
    public void refresh(){
        if(!refresh){
            loadRuteCharacter();
            startPlayer(map,typeOfPlayer);  //Inicializamos acá el jugador para poder hacer la correcta eleccion del personaje que se hizo en el menu de inicio
            refresh = true;
        }
        if(player.getLEFT_COLLISION().intersects(map.getExitZone())){
            refreshGame();
        }
        
        player.refresh();
        map.refresh((int)player.getPositionX(),(int)player.getPositionY());
        Constants.BATTLE = battleZone();
        priestZone();
    }
    @Override
    public void draw(Graphics g){
        g.fillRect(0,0,800,600);
        map.draw(g,(int)player.getPositionX(),(int)player.getPositionY());
        player.draw(g);
        g.setColor(Color.red);
        enemy.draw(g);
        priest.draw(g);
        //hud.drawFilter(g,layout);
        if(Keyboard.hud){
            hud.drawTP(g, map);
            hud.drawCollisions(g, map);
            hud.drawBattleArea(g, map);
            hud.drawPriestArea(g, map);
        }
        hud.drawBar(g, player);
        hud.drawMousePosition(g, p);
        hud.drawXY(g, player);
        hud.drawResistance(g, player.resistance);
        hud.drawLife(g, 1000);
        hud.drawMana(g, 1000);
        if(battleZone()){
            hud.drawMessage(g);
        }
    }
    
    public boolean battleZone(){
        boolean flag = false;
        for(int i=0;i<map.getEnemyAmount();i++){ 
            if(player.getLEFT_COLLISION().intersects(map.getEnemyZone()[i])  || player.getABOVE_COLLISION().intersects(map.getEnemyZone()[i]) || player.getRIGHT_COLLISION().intersects(map.getEnemyZone()[i]) || player.getDOWN_COLLISION().intersects(map.getEnemyZone()[i])){
                flag = true;
                Constants.EN_BATALLA = false;
                Constants.ACTUAL_ENEMY_ZONE = i;
            }
            if("spriteSheetE2.png".equals(map.getNameSheetEnemy())){
                Constants.ACTUAL_MAP = 2;
            }else{
                Constants.ACTUAL_MAP = 1;
            }
        }
       return flag;
    }
    
    public boolean priestZone(){
        boolean flag = false;
        if(player.getDOWN_COLLISION().intersects(map.getPriestZone())){
            flag = true;
            Constants.dead = false;
        }
        return flag;
    }
    
    
}
