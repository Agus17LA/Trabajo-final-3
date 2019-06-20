/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.control;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import main.manager.graphics.DrawSurface;

/**
 *
 * @author Agus_
 */
public class Mouse extends MouseAdapter {
    private Point position;
    private boolean click;
    
    public Mouse(final DrawSurface sd){
        position = new Point();
        refreshPosition(sd);
        click = false;
    }
    
    public void refresh(final DrawSurface sd){
        refreshPosition(sd);
    }
    
    private void refreshPosition(final DrawSurface sd){
        final Point initialPosition = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(initialPosition, sd);
        position.setLocation(initialPosition.getX(),initialPosition.getY());

    }
    
    public Point getPosition(){
        return position;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(!click)
            click = true;
    }
    
    public boolean getClick(){
        return click;
    }
    
    public void restartClick(){
        if(click){
            click = false;
        }
    }
    
}
