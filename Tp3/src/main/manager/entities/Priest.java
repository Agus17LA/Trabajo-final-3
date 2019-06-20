/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import main.manager.maps.Map;
import main.manager.sprites.SpritesSheet;

/**
 *
 * @author Agus_
 */
public class Priest {
    private final Point point;
    private Map map;
    private SpritesSheet priest;
    private BufferedImage image;
    
    public Priest(Map map){
        this.map = map;
        point = new Point();
        priest = new SpritesSheet("textures/resu.png",160,false);
        image = priest.getSprite(0).getImage();
    }
    
    public void draw(Graphics g){
        g.drawImage(image,(int)map.getPriestZone().x-5,(int)map.getPriestZone().y+5,null);
    }
    
}
