/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.maps;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import main.manager.Constants;
import main.manager.sprites.Sprite;
import main.manager.sprites.SpritesSheet;
import main.manager.tools.ResourceLoader;
/**
 *
 * @author Agus_
 */
public class Map {
    private final int width;
    private final int height;
    
    private final Point initialPosition;
    private final Point exitPoint;
    private String nextMap;
    private Rectangle exitZone;
    
    
    private Point enemyPoint1;
    private Point enemyPoint2;
    private Point enemyPoint3;
    private Rectangle enemyZone1;
    private Rectangle enemyZone2;
    private Rectangle enemyZone3;
    
    
    
    private final Sprite[] palette;
    private final boolean[] collisions;
    
    public final ArrayList<Rectangle> collisionAreas = new ArrayList<Rectangle>();
    
    private final int[] sprites;
    
    private final int EDGE_X = Constants.WINDOW_CENTER_X - Constants.SIDE_SPRITE/2;
    private final int EDGE_Y = Constants.WINDOW_CENTER_Y - Constants.SIDE_SPRITE/2;

    public Map(final String rute){
        String content = ResourceLoader.readTextFile(rute);
        String[] parts = content.split("\\*");
        width = Integer.parseInt(parts[0]);
        height = Integer.parseInt(parts[1]); 
        
        String sheets = parts[2];
        
        String[] separateSheets = sheets.split(",");
        String wholePalette = parts[3];
        String[] paletteParts = wholePalette.split("#");
        palette = spritesAssign(paletteParts,separateSheets);
        
        String collisionsInt = parts[4];
        collisions = collisionsExtract(collisionsInt);
        
        
        String spritesInt = parts[5];
        String[] arraySprites = spritesInt.split(" ");
        sprites = spriteExtract(arraySprites);        
        
        String position = parts[6];
        String[] positions = position.split(":");
        initialPosition = new Point();
        initialPosition.x = Integer.parseInt(positions[0]);// * Constants.SIDE_SPRITE;
        initialPosition.y = Integer.parseInt(positions[1]);// * Constants.SIDE_SPRITE;
        
        String exit = parts[7];
        String[] exitDats = exit.split(":");
        
        exitPoint = new Point();
        exitPoint.x = Integer.parseInt(exitDats[0]);
        exitPoint.y = Integer.parseInt(exitDats[1]);
        nextMap = exitDats[2];
        exitZone = new Rectangle();
        
        String enemies = parts[8];
        String[] allEnemies = enemies.split("#");
        enemyAssign(allEnemies);
        enemyZone1 = new Rectangle();
        enemyZone2 = new Rectangle();
        enemyZone3 = new Rectangle();
        
    }
    
    private void enemyAssign(final String[] allEnemies ){
        String enemy;
        String[] enemyDats;
        for(int i=0;i<allEnemies.length;i++){
            enemy = allEnemies[i];
            enemyDats = enemy.split(":");
            switch(i){
                case 0:
                    enemyPoint1 = new Point();
                    enemyPoint1.x = Integer.parseInt(enemyDats[0]);
                    enemyPoint1.y = Integer.parseInt(enemyDats[1]);
                    break;
                case 1:
                    enemyPoint2 = new Point();
                    enemyPoint2.x = Integer.parseInt(enemyDats[0]);
                    enemyPoint2.y = Integer.parseInt(enemyDats[1]);
                    break;
                case 2:
                    enemyPoint3 = new Point();
                    enemyPoint3.x = Integer.parseInt(enemyDats[0]);
                    enemyPoint3.y = Integer.parseInt(enemyDats[1]);
                    break;
                default:
                    break;
            }
        }
    }
    
    
    private void refreshEnemiesZone(final int positionX,final int positionY){
        int pointX = ((int)enemyPoint1.getX())*Constants.SIDE_SPRITE - positionX + EDGE_X;
        int pointY = ((int)enemyPoint1.getY())*Constants.SIDE_SPRITE - positionY + EDGE_Y;
        enemyZone1 = new Rectangle(pointX-32,pointY-32,96,96);
        
        int pointX2 = ((int)enemyPoint2.getX())*Constants.SIDE_SPRITE - positionX + EDGE_X;
        int pointY2 = ((int)enemyPoint2.getY())*Constants.SIDE_SPRITE - positionY + EDGE_Y;
        enemyZone2 = new Rectangle(pointX2-32,pointY2-32,96,96);
        
        int pointX3 = ((int)enemyPoint3.getX())*Constants.SIDE_SPRITE - positionX + EDGE_X;
        int pointY3 = ((int)enemyPoint3.getY())*Constants.SIDE_SPRITE - positionY + EDGE_Y;
        enemyZone3 = new Rectangle(pointX3-32,pointY3-32,96,96);
    }

    public Rectangle getEnemyZone1() {
        return enemyZone1;
    }

    public Rectangle getEnemyZone2() {
        return enemyZone2;
    }

    public Rectangle getEnemyZone3() {
        return enemyZone3;
    }
    
    private void refreshExitZone(final int positionX,final int positionY){
        int pointX = ((int)exitPoint.getX())*Constants.SIDE_SPRITE - positionX + EDGE_X;
        int pointY = ((int)exitPoint.getY())*Constants.SIDE_SPRITE - positionY + EDGE_Y;
        exitZone = new Rectangle(pointX,pointY,Constants.SIDE_SPRITE,Constants.SIDE_SPRITE);
    }

    public Rectangle getExitZone() {
        return exitZone;
    }
    

    
    private Sprite[] spritesAssign(final String[] paletteParts, final String[] separateSheets){
        Sprite[] palette = new Sprite[paletteParts.length];
        
        SpritesSheet sheet = new SpritesSheet("textures/"+separateSheets[0]+".png",32,false);
        
        for(int i=0;i<paletteParts.length;i++){
            String temporalSprite = paletteParts[i];
            String[] partsOfSprite = temporalSprite.split(":");
            int paletteIndex = Integer.parseInt(partsOfSprite[0]);
            int spriteSheetIndex = Integer.parseInt(partsOfSprite[2]);
            palette[paletteIndex] = sheet.getSprite(spriteSheetIndex);
        }
        
        return palette;
    }
    
    
    private boolean[] collisionsExtract(final String arrayCollisions){
        boolean[] collisions = new boolean[arrayCollisions.length()];
        for(int i=0;i<arrayCollisions.length();i++){
            if(arrayCollisions.charAt(i) == '0'){
                collisions[i] = false;
            }else{
                collisions[i] = true;
            }
        }
        return collisions;
    }
    
    private int[] spriteExtract(final String[] arraySprites){
        ArrayList<Integer> sprites = new ArrayList<Integer>();
        for(int i = 0;i<arraySprites.length;i++){
            if(arraySprites[i].length() == 2){
                sprites.add(Integer.parseInt(arraySprites[i]));
            }else{
                String one = "";
                String two = "";
                String error = arraySprites[i];
                one+= error.charAt(0);
                one+= error.charAt(1);
                two+= error.charAt(2);
                two+= error.charAt(3);
                sprites.add(Integer.parseInt(one));
                sprites.add(Integer.parseInt(two));
            }
        }
        int[] spritesVector = new int[sprites.size()];
        for(int i = 0;i<sprites.size();i++){
            spritesVector[i]=sprites.get(i);
        }
        return spritesVector;
    }
    
    public void refresh(final int positionX,final int positionY){
        refreshCollisionAreas(positionX,positionY);
        refreshExitZone(positionX,positionY);
        refreshEnemiesZone(positionX,positionY);
    }
    
    private void refreshCollisionAreas(final int positionX,final int positionY){
        if(!collisionAreas.isEmpty()){
            collisionAreas.clear();
        }
        for(int y = 0;y<this.height;y++){
            for(int x=0;x<this.width;x++){
                int pointX = x*Constants.SIDE_SPRITE - positionX + EDGE_X;
                int pointY = y*Constants.SIDE_SPRITE - positionY + EDGE_Y;
                
                if(collisions[x+y * this.width]){
                    final Rectangle r = new Rectangle(pointX,pointY,Constants.SIDE_SPRITE,Constants.SIDE_SPRITE);
                    collisionAreas.add(r);
                }
            }
        }
    }
    

    
    public void draw(Graphics g, int positionX, int positionY){
        for(int y=0;y<this.height;y++){
            for(int x=0;x<this.width;x++){
                BufferedImage image = palette[sprites[x+y*this.width]].getImage();
                int pointX = x*Constants.SIDE_SPRITE - positionX + EDGE_X;
                int pointY = y*Constants.SIDE_SPRITE - positionY + EDGE_Y;
                g.drawImage(image,pointX,pointY,null);
                
            }
        }
    }
    
    public Rectangle getEdges(final int positionX,final int positionY,final int playerWidth,final int playerHeight){
        int x = EDGE_X - positionX + playerWidth;
        int y = EDGE_Y - positionY + playerHeight;
        int rectangleWidth = this.width * Constants.SIDE_SPRITE - playerWidth * 2;
        int rectangleHeight = this.height * Constants.SIDE_SPRITE - playerHeight * 2;
        return new Rectangle(x,y,rectangleWidth,rectangleHeight);
    }

    public Point getInitialPosition() {
        return initialPosition;
    }
    
    public Point getExitPoint() {
        return exitPoint;
    }

    public String getNextMap() {
        return nextMap;
    }

    public Point getEnemyPoint1() {
        return enemyPoint1;
    }

    public Point getEnemyPoint2() {
        return enemyPoint2;
    }

    public Point getEnemyPoint3() {
        return enemyPoint3;
    }
    
    
    
    
}
