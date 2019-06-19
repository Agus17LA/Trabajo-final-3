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
    
    
    
    private final Point[] enemiesPoint;
    
    
    private final Rectangle[] enemiesZone;
    private ArrayList<Rectangle> enemiesZone1;
    
    private final int enemyAmount;
    private final String nameSheetEnemy;
    
    
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
        
        
        
        enemyAmount = Integer.parseInt(parts[8]);
        nameSheetEnemy = parts[9];
        enemiesPoint = new Point[enemyAmount];
        enemiesZone = new Rectangle[enemyAmount];
        String enemies = parts[10];
        String[] allEnemies = enemies.split("#");
        enemyAssign(allEnemies);
    }
    
    private void enemyAssign(final String[] allEnemies){
        String enemy;
        String[] enemyDats;
        for(int i = 0;i<allEnemies.length;i++){
            enemy = allEnemies[i];
            enemyDats = enemy.split(":");
            enemiesPoint[i] = new Point();
            enemiesPoint[i].x = Integer.parseInt(enemyDats[0]);
            enemiesPoint[i].y = Integer.parseInt(enemyDats[1]);
        }
    }
    
    private void refreshEnemiesZone(final int positionX,final int positionY){
        int pointX,pointY;
        for(int i=0;i<enemyAmount;i++){
            pointX = ((int)enemiesPoint[i].getX())*Constants.SIDE_SPRITE - positionX + EDGE_X;
            pointY = ((int)enemiesPoint[i].getY())*Constants.SIDE_SPRITE - positionY + EDGE_Y;
            enemiesZone[i] = new Rectangle(pointX-32,pointY-32,96,96);
        }
    }
  
    
    public Rectangle[] getEnemyZone() {
        return enemiesZone;
    }
    
    public Rectangle getEnemyZone1(){
        return enemiesZone[0];
    }

    public ArrayList<Rectangle> getEnemiesZone1() {
        return enemiesZone1;
    }

    public int getEnemyAmount() {
        return enemyAmount;
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
    
    
    public Point[] getEnemiesPoint(){
        return enemiesPoint;
    }

    public String getNameSheetEnemy() {
        return nameSheetEnemy;
    }
    
    
    
    
    
}
