/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.entities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.manager.Constants;
import main.manager.control.ControlManager;
import main.manager.maps.Map;
import main.manager.sprites.SpritesSheet;
/**
 *
 * @author Agus_
 */
public class Player {
    private double positionX;
    private double positionY;
    private final SpritesSheet ss;
    private BufferedImage actualImage;
    private final SpritesSheet dd;
    private BufferedImage deadImage;
    
    private int direction;
    private boolean moving;
    private int animation;
    private int state;
    
    private double velocity = 1;
    public int resistance = 10000;
    private int recovery = 0;
    private int maxRecovery = 150;
    private boolean recover = false;
    
    
    private final Rectangle ABOVE_COLLISION = new Rectangle(Constants.WINDOW_CENTER_X-8,Constants.WINDOW_CENTER_Y+19,14,1);
    private final Rectangle DOWN_COLLISION = new Rectangle(Constants.WINDOW_CENTER_X-8,Constants.WINDOW_CENTER_Y+30,14,1);
    private final Rectangle LEFT_COLLISION = new Rectangle(Constants.WINDOW_CENTER_X-8,Constants.WINDOW_CENTER_Y+19,1,12);
    private final Rectangle RIGHT_COLLISION = new Rectangle(Constants.WINDOW_CENTER_X+7,Constants.WINDOW_CENTER_Y+19,1,12);
    private final int PLAYER_WIDTH = 26;
    private final int PLAYER_HEIGHT = 15;
    private Map map;
    
    public Player(Map map, String rute){
        positionX = map.getInitialPosition().getX();
        positionY = map.getInitialPosition().getY();
        ss = new SpritesSheet(rute,64,false); //Para agregar más jugadores deberemos mandar por parametro por acá nuestro personaje
        actualImage = ss.getSprite(0).getImage();
        dd = new SpritesSheet("textures/dead.png",64,false);
        moving = false;
        animation = 0;
        state = 0;
        this.map = map;
    }
    
    public void refresh(){
        velocityResistenceManager();
        changeAnimationState();
        moving = false;
        decideDirection();
        animation();
    }
    
    public void velocityResistenceManager(){
        if(ControlManager.keyboard.run && resistance > 0){
            velocity = 2;
            recover = false;
            recovery = 0;
        }else{
            velocity = 1;
            if(!recover && recovery < maxRecovery){
                recovery++;
            }
            if(recovery == maxRecovery && resistance < 600){
                resistance++;
            }
        }
    }
    
    private void changeAnimationState(){
        if(animation<35){
           animation++;
        }else{
           animation = 0;
        }
        if(animation < 7){
            state = 1;
        }else if(animation < 14){
            state = 2;
        }else if(animation < 21){
            state = 3;
        }else if(animation < 28){
            state = 4;
        }else if(animation < 35){
            state = 5;
        }
    }
    
    private void decideDirection(){
        final int velocityX = eVelocityX();
        final int velocityY = eVelocityY();
        if((velocityX != 0 && velocityY == 0) || (velocityX == 0 && velocityY !=0)){
            moving(velocityX,velocityY);
        }else{
            if(velocityX == -1 && velocityY ==-1){
                if(ControlManager.keyboard.left.getLastPress() > ControlManager.keyboard.up.getLastPress()){
                    moving(velocityX,0);
                }else{
                    moving(0,velocityY);
                }  
            }
            if(velocityX == -1 && velocityY ==1){
                if(ControlManager.keyboard.left.getLastPress() > ControlManager.keyboard.down.getLastPress()){
                    moving(velocityX,0);
                }else{
                    moving(0,velocityY);
                }
            }
            if(velocityX == 1 && velocityY ==-1){
                if(ControlManager.keyboard.right.getLastPress() > ControlManager.keyboard.up.getLastPress()){
                    moving(velocityX,0);
                }else{
                    moving(0,velocityY);
                }   
            }
            if(velocityX == 1 && velocityY ==1){
                if(ControlManager.keyboard.right.getLastPress() > ControlManager.keyboard.down.getLastPress()){
                    moving(velocityX,0);
                }else{
                    moving(0,velocityY);
                }
            }
        }
    }
    
    private int eVelocityX(){
        int velocityX = 0;
        if(ControlManager.keyboard.left.isPressed() && !ControlManager.keyboard.right.isPressed()){
            velocityX = -1;
        }else if(!ControlManager.keyboard.left.isPressed() && ControlManager.keyboard.right.isPressed()){
            velocityX = 1;
        }
        return velocityX;
    }
    
    private int eVelocityY(){
        int velocityY = 0;
        if(ControlManager.keyboard.up.isPressed() && !ControlManager.keyboard.down.isPressed()){
            velocityY = -1;
        }else if(!ControlManager.keyboard.up.isPressed() && ControlManager.keyboard.down.isPressed()){
            velocityY = 1;
        }
        return velocityY;
    }
    
    private void moving(final int velocityX,final int velocityY){
        moving = true;
        changeDirection(velocityX,velocityY);
        if(!outOfMap(velocityX,velocityY)){
            if(velocityX == -1 && !leftCollision(velocityX)){
                positionX += velocityX * velocity;
                resistanceSubtract();
            }
            if(velocityX == 1 && !rightCollision(velocityX)){
                positionX += velocityX * velocity;
                resistanceSubtract();
            }
            if(velocityY == -1 && !aboveCollision(velocityY)){
                positionY += velocityY * velocity;
                resistanceSubtract();
            }
            if(velocityY == 1 && !downCollision(velocityY)){
                positionY += velocityY * velocity;
                resistanceSubtract();
            }
        }
    }
    
    public void resistanceSubtract(){
        if(ControlManager.keyboard.run && resistance>0){
            resistance--;
        }
    }
    
    private boolean aboveCollision(int velocityY){
        for(int r =0;r<map.collisionAreas.size();r++){
            final Rectangle area = map.collisionAreas.get(r);
            int xOrigin = area.x;
            int yOrigin = area.y + velocityY*(int)velocity + 2 * (int) velocity;
            final Rectangle futureArea = new Rectangle(xOrigin,yOrigin,Constants.SIDE_SPRITE,Constants.SIDE_SPRITE);
            if(ABOVE_COLLISION.intersects(futureArea)){
                return true;
            }
        }
        return false;
    }
    private boolean downCollision(int velocityY){
        for(int r =0;r<map.collisionAreas.size();r++){
            final Rectangle area = map.collisionAreas.get(r);
            int xOrigin = area.x;
            int yOrigin = area.y + velocityY*(int)velocity - 2 * (int) velocity;
            final Rectangle futureArea = new Rectangle(xOrigin,yOrigin,Constants.SIDE_SPRITE,Constants.SIDE_SPRITE);
            if(DOWN_COLLISION.intersects(futureArea)){
                return true;
            }
        }
        return false;
    }
       
    private boolean leftCollision(int velocityX){
        for(int r =0;r<map.collisionAreas.size();r++){
            final Rectangle area = map.collisionAreas.get(r);
            int xOrigin = area.x + velocityX*(int)velocity + 2 * (int) velocity;
            int yOrigin = area.y;
            final Rectangle futureArea = new Rectangle(xOrigin,yOrigin,Constants.SIDE_SPRITE,Constants.SIDE_SPRITE);
            if(LEFT_COLLISION.intersects(futureArea)){
                return true;
            }
        }
        return false;
    }
        
    private boolean rightCollision(int velocityX){
        for(int r =0;r<map.collisionAreas.size();r++){
            final Rectangle area = map.collisionAreas.get(r);
            int xOrigin = area.x + velocityX*(int)velocity - 2 * (int) velocity;
            int yOrigin = area.y;
            final Rectangle futureArea = new Rectangle(xOrigin,yOrigin,Constants.SIDE_SPRITE,Constants.SIDE_SPRITE);
            if(RIGHT_COLLISION.intersects(futureArea)){
                return true;
            }
        }
        return false;
    }
    
    private boolean outOfMap(final int velocityX, final int velocityY){
        int futurePositionX = (int)positionX + velocityX * (int)velocity;
        int futurePositionY = (int)positionY + velocityY * (int)velocity;
        final Rectangle mapEdges = map.getEdges(futurePositionX,futurePositionY,PLAYER_WIDTH,PLAYER_HEIGHT);
        
        final boolean out;
        if(ABOVE_COLLISION.intersects(mapEdges) || DOWN_COLLISION.intersects(mapEdges) || LEFT_COLLISION.intersects(mapEdges) || RIGHT_COLLISION.intersects(mapEdges)){
            out = false;
        }else{
            out = true;
        }
        
        return out;
    }
    
    
    private void changeDirection(final int velocityX,final int velocityY){
        if(velocityX == -1){
            direction = 2;
        }else if(velocityX == 1){
            direction = 3;
        }
        if(velocityY == -1){
            direction = 1;
        }else if(velocityY == 1){
            direction = 0;
        }
    }
    
    private void animation(){
        if(!moving){
            state = 0;
            animation = 0;
        }
        if(!Constants.dead){
            actualImage = ss.getSprite(direction, state).getImage();
        }else{
            deadImage = dd.getSprite(direction,state).getImage();
        }
    }
    
    public void draw(Graphics g){
        final int centerX = Constants.WINDOW_CENTER_X - Constants.SIDE_SPRITE;
        final int centerY = Constants.WINDOW_CENTER_Y - Constants.SIDE_SPRITE;
        g.setColor(Color.green);
        
        if(!Constants.dead)
            g.drawImage(actualImage,centerX,centerY,null);
        else
            g.drawImage(deadImage, centerX, centerY, null);
        
        g.drawRect(ABOVE_COLLISION.x, ABOVE_COLLISION.y, ABOVE_COLLISION.width , ABOVE_COLLISION.height);
        g.drawRect(DOWN_COLLISION.x, DOWN_COLLISION.y, DOWN_COLLISION.width, DOWN_COLLISION.height);
        g.drawRect(LEFT_COLLISION.x, LEFT_COLLISION.y, LEFT_COLLISION.width, LEFT_COLLISION.height);
        g.drawRect(RIGHT_COLLISION.x, RIGHT_COLLISION.y, RIGHT_COLLISION.width, RIGHT_COLLISION.height);
        //Muestro colisiones del jugador*/
        
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public Rectangle getLEFT_COLLISION() {
        return LEFT_COLLISION;
    }

    public Rectangle getABOVE_COLLISION() {
        return ABOVE_COLLISION;
    }

    public Rectangle getDOWN_COLLISION() {
        return DOWN_COLLISION;
    }

    public Rectangle getRIGHT_COLLISION() {
        return RIGHT_COLLISION;
    }
    
    

    public void setMap(Map map) {
        this.map = map;
    }
    
    
    
}
