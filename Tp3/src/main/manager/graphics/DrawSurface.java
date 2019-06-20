/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import main.manager.control.ControlManager;
import main.manager.control.Keyboard;
import main.manager.control.Mouse;
import main.manager.statesmachine.StateManager;
import main.manager.tools.ResourceLoader;

/**
 *
 * @author Agus_
 */
public class DrawSurface extends Canvas{ //canvas es un componente que nos sirve para dibujar graficos a alta velocidad
    private int width;
    private int height;
    public static Mouse mouse;
    private BufferedImage fondo;
    public static Graphics g;
    
    
    public DrawSurface(final int width,final int height){
        this.width = width;
        this.height = height;
        this.mouse = new Mouse(this);
        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(width,height));
        addKeyListener(ControlManager.keyboard);
        addMouseListener(mouse);
        setFocusable(true);
        requestFocus();
        fondo = ResourceLoader.loadCompatibleImageTranslucent("textures/fondo.png");
    }
    
    public void refresh(){
        mouse.refresh(this);
    }
    
    public void draw(final StateManager sm){
        BufferStrategy buffer = getBufferStrategy();
        if(buffer == null){
            createBufferStrategy(3);
            return;
        }
        g = buffer.getDrawGraphics();
        //g.setColor(Color.black);
        g.drawImage(fondo, 0, 0, null);
        
        //g.fillRect(0, 0, width, height);
        sm.draw(g);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        buffer.show();
    }
    
    



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
    
}
