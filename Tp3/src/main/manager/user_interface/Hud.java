/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.user_interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import static java.awt.font.TextAttribute.WEIGHT_BOLD;
import java.awt.image.BufferedImage;
import main.manager.Constants;
import main.manager.control.Mouse;
import main.manager.entities.Player;
import main.manager.maps.Map;
import main.manager.tools.ResourceLoader;

/**
 *
 * @author Agus_
 */
public class Hud {
    
    private Rectangle inventoryArea;
    private Rectangle layoutInventoryArea;
    
    public Hud(final Player player){
        int heightMenu = 64;
        inventoryArea = new Rectangle(0,Constants.WINDOW_HEIGHT - heightMenu, Constants.WINDOW_WIDTH, heightMenu);
        layoutInventoryArea = new Rectangle(inventoryArea.x,inventoryArea.y-1,inventoryArea.width,1);
    }
    
    public Hud(){
        
    }
    
    
    public void drawBar(final Graphics g, final Player player){
        drawInventoryArea(g);
    }
    
    private void drawInventoryArea(final Graphics g){
        g.setColor(Color.gray);
        g.fillRect(inventoryArea.x, inventoryArea.y, inventoryArea.width, inventoryArea.height);
        g.setColor(Color.white);
        g.fillRect(layoutInventoryArea.x, layoutInventoryArea.y, layoutInventoryArea.width, layoutInventoryArea.height);
    }
    
    public void drawBattleArea(Graphics g, Map map){
        g.setColor(Color.CYAN);
        for(int i=0;i<map.getEnemyAmount();i++){
            g.drawRect((int)map.getEnemyZone()[i].getX(), (int)map.getEnemyZone()[i].getY(), (int)map.getEnemyZone()[i].getWidth(), (int)map.getEnemyZone()[i].getHeight());
        }
    }
    
    public void drawPriestArea(Graphics g,Map map){
        g.setColor(Color.MAGENTA);
        g.drawRect((int)map.getPriestZone().getX(),(int)map.getPriestZone().getY(),(int)map.getPriestZone().getWidth(),(int)map.getPriestZone().getHeight());
    }
    
    public void drawCollisions(Graphics g, Map map){
            g.setColor(Color.red);   //hago visibles las colisiones
            for(int r = 0; r<map.collisionAreas.size();r++){
                Rectangle a = map.collisionAreas.get(r);
                g.drawRect(a.x,a.y,a.width,a.height);
            }
    }
    
    public void drawTP(Graphics g, Map map){
        g.setColor(Color.green);
        g.drawRect((int)map.getExitZone().getX(), (int)map.getExitZone().getY(), (int)map.getExitZone().getWidth(), (int)map.getExitZone().getHeight());
    }
    
    public void drawLife(Graphics g, int life){
        int width = (100* life/1000);
        Color darkRed = new Color(153,0,0);
        g.setColor(Color.WHITE);
        g.drawRect(540,540,101,10);
        g.setColor(darkRed);
        g.fillRect(541, 541, width, 9);
        g.setColor(Color.BLACK);
        g.drawString("Vida", 505, 550);
    }
    
    public void drawMana(Graphics g, int mana){
        int width = (100* mana/1000);
        Color darkRed = new Color(81,209,246);
        g.setColor(Color.WHITE);
        g.drawRect(540,560,101,10);
        g.setColor(darkRed);
        g.fillRect(541, 561, width, 9);
        g.setColor(Color.BLACK);
        g.drawString("Mana", 500, 570);
    }
    
    public void drawResistance(Graphics g, int resistance){
        int width = (100* resistance/600);
        Color darkYellow = new Color(255,255,0);
        g.setColor(Color.WHITE);
        g.drawRect(30,550,101,10);
        g.setColor(darkYellow);
        g.fillRect(30, 551, width, 9);
        g.setColor(Color.BLACK);
        g.drawString("Stamina", 30, 548);
    }
    
    public void drawMessage(Graphics g){
        g.setColor(Color.red);
        g.drawString("ENEMIGO ENCONTRADO, SI DESEA COMENZAR UNA BATALLA PULSE ENTER",20,580);
    }    
    public void drawXY(Graphics g,Player player){
        g.setColor(Color.blue);
        g.drawString("X = "+player.getPositionX(),730,580);
        g.drawString("Y = "+player.getPositionY(),730,560);
    }
    
    public void drawFilter(Graphics g,BufferedImage layout){
        g.drawImage(layout, 0, 0, null);
    }
    
    public void drawMousePosition(Graphics g,Point p){
        g.setColor(Color.RED);
        g.drawString("RX: "+p.getX(),650,580);
        g.drawString("RX: "+p.getY(),650,560);
    }
    
    
    
}
