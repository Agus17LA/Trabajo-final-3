/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.sprites;

import java.awt.image.BufferedImage;

/**
 *
 * @author Agus_
 */
public class Sprite {
    private final BufferedImage image;
    private final int width;
    private final int height;
    public Sprite(final BufferedImage image){
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
