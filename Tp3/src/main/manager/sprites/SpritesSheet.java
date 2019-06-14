/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.sprites;

import java.awt.image.BufferedImage;
import main.manager.tools.ResourceLoader;

/**
 *
 * @author Agus_
 */
public class SpritesSheet {
    final private int widthSheetPx;
    final private int heightSheetPx;
    final private int widthSheetSprites;
    final private int heightSheetSprites;
    final private int widthSprites;
    final private int heightSprites;
    
    final private Sprite[] sprites;
    
    public SpritesSheet(final String rute,final int sizeSprites, final boolean opaque){
        final BufferedImage image;       
        if(opaque)
            image = ResourceLoader.loadCompatibleImageOpaque(rute);
        else
            image = ResourceLoader.loadCompatibleImageTranslucent(rute);
        widthSheetPx = image.getWidth();
        heightSheetPx = image.getHeight();
        widthSheetSprites = widthSheetPx / sizeSprites;
        heightSheetSprites = heightSheetPx / sizeSprites;
        widthSprites = sizeSprites;
        heightSprites = sizeSprites;
        sprites = new Sprite[widthSheetSprites * heightSheetSprites];
        fillSpriteFromImage(image);
    }
    public SpritesSheet(final String rute,final int widthSprites,final int heightSprites, final boolean opaque){
        final BufferedImage image;
        if(opaque)
            image = ResourceLoader.loadCompatibleImageOpaque(rute);
        else
            image = ResourceLoader.loadCompatibleImageTranslucent(rute);
        widthSheetPx = image.getWidth();
        heightSheetPx = image.getHeight();
        widthSheetSprites = widthSheetPx / widthSprites;
        heightSheetSprites = heightSheetPx / heightSprites;
        this.widthSprites = widthSprites;
        this.heightSprites = heightSprites;
        sprites = new Sprite[widthSheetSprites * heightSheetSprites];
        fillSpriteFromImage(image);
    }
    private void fillSpriteFromImage(final BufferedImage image){
        for(int y=0;y<heightSheetSprites;y++){
            for(int x=0;x<widthSheetSprites;x++){
                final int positionX=x*widthSprites;
                final int positionY=y*heightSprites;
                sprites[x+y * widthSheetSprites] = new Sprite(image.getSubimage(positionX, positionY, widthSprites, heightSprites));
            }
        }
    }
    
    public Sprite getSprite(final int index){
        return sprites[index];
    }
    
    public Sprite getSprite(final int x, final int y){
        return sprites [x+y*widthSheetSprites];
    }
    
}
