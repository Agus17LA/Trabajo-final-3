/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.tools;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Agus_
 */

//metodo de dibujo nativo
 
public class ResourceLoader {
    public static BufferedImage loadCompatibleImageOpaque(final String rute){ //Cargamos imagenes que serán totalmente opacas (Pisos, paredes, etc)
        Image image = null;        
        try {
            image = ImageIO.read(ClassLoader.getSystemResource(rute)); //Intentamos cargar una imagen (CREAR EXEPCION PROPIA)
        } catch (IOException ex) {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        GraphicsConfiguration gc;
        gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage ai = gc.createCompatibleImage(image.getWidth(null),image.getHeight(null), Transparency.OPAQUE); //obtenemos nuestra configuracion optima de pantalla y cargamos nuestra imagen en el buffer 

        Graphics g = ai.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return ai;
    } 
    
    public static BufferedImage loadCompatibleImageTranslucent(final String rute){ // cargamos imagenes que pueden ser translucidas (personajes, objetos, etc)
        Image image =  null;
        try {
            image = ImageIO.read(ClassLoader.getSystemResource(rute)); //Intentamos cargar una imagen
        } catch (IOException ex) {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GraphicsConfiguration gc;
        gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage ai = gc.createCompatibleImage(image.getWidth(null),image.getHeight(null), Transparency.TRANSLUCENT); //obtenemos nuestra configuracion optima de pantalla y cargamos nuestra imagen en el buffer 
       
        
        Graphics g = ai.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return ai;
    }
    
    public static String readTextFile(final String rute) {
        String content = "";
        FileInputStream byteInput = null;
        BufferedReader reader = null;
        try {
            byteInput = new FileInputStream(rute);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        reader = new BufferedReader(new InputStreamReader(byteInput));
        String line;
        try {
                while ((line = reader.readLine()) != null) {
                        content += line;
                }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (byteInput != null) {
                                byteInput.close();
                        }
                        if (reader != null) {
                                reader.close();
                        }
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }

        return content;
    }
    
    
    
}
