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
public class Enemy {
    private final Point[] point;
    private Map map;
    private SpritesSheet [] enemies;
    private BufferedImage [] images;
    
    public Enemy(Map map){
        this.map = map;
        point = new Point[map.getEnemyAmount()];
        enemies = new SpritesSheet[map.getEnemyAmount()];
        images = new BufferedImage[map.getEnemyAmount()];
        enemiesStart();
        enemiesSpriteStart();
        enemiesImageStart();
    }
    
    private void enemiesStart(){
        for(int i=0;i<map.getEnemyAmount();i++){
            point[i] = new Point();
            point[i].setLocation(map.getEnemiesPoint()[i]);
        }
    }
    
    private void enemiesSpriteStart(){
        for(int i=0;i<map.getEnemyAmount();i++){
            enemies[i] = new SpritesSheet("textures/"+map.getNameSheetEnemy(),64,false);
        }
    }
    
    private void enemiesImageStart(){
        for(int i = 0;i<map.getEnemyAmount();i++){
            images[i] = enemies[i].getSprite(i).getImage();
        }
    }
    
    public void draw(Graphics g){
        for(int i=0;i<map.getEnemyAmount();i++){
            g.drawImage(images[i],(int)map.getEnemyZone()[i].x+16,(int)map.getEnemyZone()[i].y-10,null);
        }
    }
    
}
