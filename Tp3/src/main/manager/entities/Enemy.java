/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.entities;

import java.awt.Point;
import java.awt.image.BufferedImage;
import main.manager.sprites.SpritesSheet;

/**
 *
 * @author Agus_
 */
public class Enemy {
    private Point[] point;
    private BufferedImage[] image;
    private SpritesSheet[] acutalEnemy;
    
    public Enemy(){
        point[3] = new Point();
        
    }
    
}
