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
import races.Dwarf;
import races.Elf;
import races.Gnome;
import races.Human;
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
    
    public void drawCharacterStats(Graphics g, Playable aux){
        g.setColor(Color.RED);
        g.drawString(aux.showHp(), 500, 550);
        g.setColor(Color.CYAN);
        g.drawString(aux.showMana(), 500, 570);
        g.setColor(Color.BLACK);
        g.drawString(aux.showXpState(), 500, 590);
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
        switch(Constants.SELECTED_CHARACTER){
            case 1:
                drawCharacterStats(g,Game.gnome);
                break;
            case 2:
                drawCharacterStats(g,Game.human);
                break;
            case 3:
                drawCharacterStats(g,Game.elf);
                break;
            case 4:
                drawCharacterStats(g,Game.dwarf);
                break;
            default:
                break;
        }
        hud.drawMousePosition(g, p);
        hud.drawXY(g, player);
        hud.drawResistance(g, player.resistance);
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
            switch(Constants.SELECTED_CHARACTER){
                case 1:
                    Game.gnome.setHp(Game.gnome.getMaxHp());
                    Game.gnome.setMana(Game.gnome.getMaxMana());
                    break;
                case 2:
                    Game.human.setHp(Game.human.getMaxHp());
                    Game.human.setMana(Game.human.getMaxMana());
                    break;
                case 3:
                    Game.elf.setHp(Game.elf.getMaxHp());
                    Game.elf.setMana(Game.elf.getMaxMana());
                    break;
                case 4:
                    Game.dwarf.setHp(Game.dwarf.getMaxHp());
                    Game.dwarf.setMana(Game.dwarf.getMaxMana());
                    break;
                default:
                    break;
        }
        }
        return flag;
    }
    
    
}
