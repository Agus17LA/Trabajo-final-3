/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import main.manager.Constants;
import main.manager.maps.Map;
import main.manager.sprites.SpritesSheet;

/**
 *
 * @author Agus_
 */
public class Enemy {
    private final Point[] point = new Point[Constants.ENEMY_AMOUNT];
    private BufferedImage actualEnemy1;
    private BufferedImage actualEnemy2;
    private BufferedImage actualEnemy3;
        
    private SpritesSheet enemy1;
    private SpritesSheet enemy2;
    private SpritesSheet enemy3;
    private Map map;
    
    public Enemy(Map map){
        this.map = map;
        enemyStart();
        enemySpriteStart();
        enemyImageStart();
    }

    
    private void enemyStart(){
        for(int i = 0;i<Constants.ENEMY_AMOUNT;i++){
            point[i] = new Point();
            switch (i) {
                case 0:
                    point[i].setLocation(map.getEnemyPoint1());
                    break;
                case 1:
                    point[i].setLocation(map.getEnemyPoint2());
                    break;
                case 2:
                    point[i].setLocation(map.getEnemyPoint3());
                    break;
                default:
                    break;
            }
        }
    }
    
    private void enemySpriteStart(){
        enemy1 = new SpritesSheet(Constants.RUTA_GUERREROENANO,64,false);
        enemy2 =  new SpritesSheet(Constants.RUTA_MAGOGNOMO,64,false);
        enemy3 =  new SpritesSheet(Constants.RUTA_GUERREROHUMANO,64,false);
    }
    
    public BufferedImage[] enemyImageStart(){
        BufferedImage[] todos = new BufferedImage[3];
        todos[0] = actualEnemy1 = enemy1.getSprite(0).getImage();
        todos[1] = actualEnemy2 = enemy2.getSprite(0).getImage();
        todos[2] = actualEnemy3 = enemy3.getSprite(0).getImage();
        return todos;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.CYAN);
        g.drawImage(enemyImageStart()[0],(int)map.getEnemyZone1().getX()+18,(int)map.getEnemyZone1().getY(),null);
        g.drawImage(enemyImageStart()[1],(int)map.getEnemyZone2().getX()+18,(int)map.getEnemyZone2().getY(),null);
        g.drawImage(enemyImageStart()[2],(int)map.getEnemyZone3().getX()+18,(int)map.getEnemyZone3().getY()-10,null);
    }

    
    
}
