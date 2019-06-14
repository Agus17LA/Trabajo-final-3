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
    
    public void drawBar(final Graphics g, final Player player){
        drawInventoryArea(g);
    }
    
    private void drawInventoryArea(final Graphics g){
        g.setColor(Color.gray);
        g.fillRect(inventoryArea.x, inventoryArea.y, inventoryArea.width, inventoryArea.height);
        g.setColor(Color.white);
        g.fillRect(layoutInventoryArea.x, layoutInventoryArea.y, layoutInventoryArea.width, layoutInventoryArea.height);
    }
    
    public static void drawLife(Graphics g, int life){
        int width = (100* life/1000);
        Color darkRed = new Color(153,0,0);
        g.setColor(Color.WHITE);
        g.drawRect(540,540,101,10);
        g.setColor(darkRed);
        g.fillRect(541, 541, width, 9);
        g.setColor(Color.BLACK);
        g.drawString("Vida", 505, 550);
    }
    
    public static void drawMana(Graphics g, int mana){
        int width = (100* mana/1000);
        Color darkRed = new Color(81,209,246);
        g.setColor(Color.WHITE);
        g.drawRect(540,560,101,10);
        g.setColor(darkRed);
        g.fillRect(541, 561, width, 9);
        g.setColor(Color.BLACK);
        g.drawString("Mana", 500, 570);
    }
    
    public static void drawResistance(Graphics g, int resistance){
        int width = (100* resistance/600);
        Color darkYellow = new Color(255,255,0);
        g.setColor(Color.WHITE);
        g.drawRect(540,580,101,10);
        g.setColor(darkYellow);
        g.fillRect(541, 581, width, 9);
        g.setColor(Color.BLACK);
        g.drawString("Stamina", 490, 589);
    }
    
    public static void drawMessage(Graphics g){
        g.setColor(Color.red);
        g.drawString("ENEMIGO ENCONTRADO, SI DESEA COMENZAR UNA BATALLA PULSE ENTER",20,580);
    }    
    public static void drawXY(Graphics g,Player player){
        g.setColor(Color.blue);
        g.drawString("X = "+player.getPositionX(),730,580);
        g.drawString("Y = "+player.getPositionY(),730,560);
    }
    
    public static void drawLayout(Graphics g,BufferedImage layout){
        g.drawImage(layout, 0, 0, null);
    }
    
    public static void drawMousePosition(Graphics g,Point p){
        g.setColor(Color.RED);
        g.drawString("RX: "+p.getX(),650,580);
        g.drawString("RX: "+p.getY(),650,560);
    }
    
    
    
}
