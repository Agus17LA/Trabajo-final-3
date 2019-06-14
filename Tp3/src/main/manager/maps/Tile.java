/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.maps;

import java.awt.Rectangle;
import main.manager.sprites.Sprite;

/**
 *
 * @author Agus_
 */
public class Tile {
    private final Sprite sprite;
    private final int id; //identificador único para cada tile
    private boolean solid;
    public Tile(final Sprite sprite, final int id){
        this.sprite = sprite;
        this.id = id;
        solid = false;
    }
    public Tile(final Sprite sprite, final int id,final boolean solid){
        this.sprite = sprite;
        this.id = id;
        this.solid = solid;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    
    public Rectangle getLimits(final int x,final int y){
        return new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());
    }
    
}
